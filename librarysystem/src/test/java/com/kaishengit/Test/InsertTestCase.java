package com.kaishengit.Test;

import com.kaishengit.mapper.BookMapper;
import com.kaishengit.mapper.StudentMapper;
import com.kaishengit.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhao on 2017/10/26.
 */
public class InsertTestCase {

    private SqlSession sqlSession;
    private StudentMapper studentMapper;

    @Before
    public void init() {
        sqlSession = MybatisUtil.getSqlSession();
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    @After
    public void close() {
        sqlSession.close();
    }

    @Test
    public void saveTest() {
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            studentMapper.save("tom");
        }
        sqlSession.commit();
        Long endTime = System.currentTimeMillis();

        System.out.println("用时>>>>>>>>>" + (endTime - startTime));

        // 用时>>>>>>>>>5031
    }

    @Test
    public void batchSaveTest() {
        Long startTime = System.currentTimeMillis();

        List<String> nameList = new ArrayList<>();
        for(int i = 0; i < 5000; i++) {
            nameList.add("jack");
        }

        studentMapper.batchSave(nameList);
        sqlSession.commit();

        Long endTime = System.currentTimeMillis();

        System.out.println("用时>>>>>>>>>" + (endTime - startTime));
        // 用时>>>>>>>>>749
    }

}
