package com.zc.pattern.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: ZhouCong
 * @date: Create in 2021/1/11 15:55
 * @description:
 */
public abstract class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) {
        try {
//            1、获取链接
            Connection connection = this.getConnection();
//            2、创建语句集
            PreparedStatement prepareStatement = this.createPrepareStatement(connection, sql);
//            3、执行语句集
            ResultSet rs = this.executeQuery(prepareStatement,values);
//            4、处理结果集
            List<?> result = this.paresResultSet(rs, rowMapper);
//            5、关闭结果集
            this.closeResultSet(rs);
//            6、关闭语句集
            this.closePreperStatement(prepareStatement);
//            7、关闭连接
            this.closeConnection(connection);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void closeConnection(Connection connection) throws Exception {
//        数据库连接池可以不关闭
        connection.close();
    }

    final void closePreperStatement(PreparedStatement prepareStatement) throws Exception {
        prepareStatement.close();
    }

    final void closeResultSet(ResultSet rs) throws Exception {
        rs.close();
    }

    protected List<?> paresResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<>();
        int rowNum = 0;
        while (rs.next()){
            result.add(rowMapper.mapRow(rs,++rowNum));
        }
        return result;
    }

    protected ResultSet executeQuery(PreparedStatement prepareStatement, Object[] values) throws Exception {
        for (int i = 0; i < values.length; i++) {
            prepareStatement.setObject(i+1,values[i]);
        }
        return prepareStatement.executeQuery();
    }

    protected PreparedStatement createPrepareStatement(Connection connection, String sql) throws Exception {
        return connection.prepareStatement(sql);
    }

    public Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    }
}
