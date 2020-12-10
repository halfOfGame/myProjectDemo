package com.service;

import com.domain.Data;
import com.mapper.ChangeDataMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class ChangeData {

    public static String resource;
    public static InputStream inputStream;
    public static SqlSessionFactory sqlSessionFactory;
    public static SqlSession session;
    public static ChangeDataMapper mapper;

    public static void init() throws IOException {
        resource = "mybatis-config.xml";
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSessionFactory.getConfiguration().addMapper(ChangeDataMapper.class);
    }

    public static void destory() throws IOException {
        session.close();
        inputStream.close();
    }

    public static void printData() {
        Data data = mapper.getData();
        System.out.println(data.getData1() + "," + data.getData2() + "," + data.getData3());
    }

    public static void change() throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            session = sqlSessionFactory.openSession();
            mapper = session.getMapper(ChangeDataMapper.class);

            Data data = mapper.getData();
            Integer IntegerOne = Integer.valueOf(data.getData1());
            Integer IntegerTwo = Integer.valueOf(data.getData2());
            Integer IntegerThree = Integer.valueOf(data.getData3());
            String value1 = String.valueOf(IntegerOne + random.nextInt(20));
            String value2 = String.valueOf(IntegerTwo + random.nextInt(20));
            String value3 = String.valueOf(IntegerThree + random.nextInt(20));
            mapper.ChangeData(value1, value2,value3);
            printData();

            session.commit();
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        init();
        change();
        destory();
    }
}
