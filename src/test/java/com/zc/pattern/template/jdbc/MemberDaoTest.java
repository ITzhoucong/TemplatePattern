package com.zc.pattern.template.jdbc;

import com.zc.pattern.template.jdbc.dao.MemberDao;

import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;
import java.util.AbstractList;
import java.util.List;

/**
 * @author: ZhouCong
 * @date: Create in 2021/1/11 16:48
 * @description:
 */
public class MemberDaoTest {

    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<?> result = memberDao.selectAll();
        System.out.println(result);
    }

}
