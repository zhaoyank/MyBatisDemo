package com.kaishengit.com.kaishengit.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @Author zhao
 */
public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

}
