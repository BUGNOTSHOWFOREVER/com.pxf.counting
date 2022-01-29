package com.pxf.counting.utill;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;

/**
 * @className: DBUtils
 * @author: pangxiaofu
 * @description: TODO
 * @date: 2022/1/27 15:26
 * @version: 1.0
 */
public class DBUtils {
    private static SqlSessionFactory sqlSessionFactory = null;
    private static final Log log = LogFactory.getLog(DBUtils.class);

    static {
        String resource = "mybatis-config.xml";

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
        } catch (IOException var3) {
            var3.printStackTrace();
            log.error("db connection error message", var3);
        }

    }

    public DBUtils() {
    }

    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }
}
