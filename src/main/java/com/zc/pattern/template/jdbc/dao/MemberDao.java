package com.zc.pattern.template.jdbc.dao;

import com.zc.pattern.template.jdbc.JdbcTemplate;
import com.zc.pattern.template.jdbc.Member;
import com.zc.pattern.template.jdbc.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author: ZhouCong
 * @date: Create in 2021/1/11 16:30
 * @description:
 */
public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll(){
        String sql = "select * from t_member";
        return super.executeQuery(sql, new RowMapper<Member>() {

            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
//                字段过多  用原型模式优化
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setNickname(rs.getString("nickname"));
                member.setAge(rs.getInt("age"));
                member.setAddress(rs.getString("address"));
                return member;
            }
        },null);
    }
}
