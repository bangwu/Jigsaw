package com.thoughtworks.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class JigsawSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        if (sqlSessionFactory == null) {
            try {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("db/databaseConfig.xml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static SqlSessionFactory getInstance() {
        return sqlSessionFactory;
    }

    public static <T> T getMapper(Class<T> clazz) {
        return sqlSessionFactory.openSession(true).getMapper(clazz);
    }
}
