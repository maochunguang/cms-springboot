package com.cms.dao;

import org.mybatis.spring.SqlSessionTemplate;

/**
 * @author mac
 * Date: 2017/9/8
 * Description: 根据支付类型选择不同的数据源,并实现读写分离
 */
public class DataSource {

    public static SqlSessionTemplate getDataSource(String channel) {
        return null;
    }
    public static SqlSessionTemplate getReadDataSource(String channel) {
        return null;
    }
    public static SqlSessionTemplate getWriteDataSource(String channel) {
        return null;
    }
}
