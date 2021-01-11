package com.zc.pattern.template.jdbc;

import java.sql.ResultSet;

/**
 * 功能描述:  ORM映射定制化的接口
 *
 * @Param:
 * @Return:
 * @Author: ZhouCong
 * @Date: 2021/1/11 15:55
 */
public interface RowMapper<T> {

    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
