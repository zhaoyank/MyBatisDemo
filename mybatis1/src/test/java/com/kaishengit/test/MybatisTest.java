package com.kaishengit.test;

import com.kaishengit.entity.Student;
import com.kaishengit.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by zhao on 2017/10/23.
 */
public class MybatisTest {

    @Test
    public void findAllTest() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        List<Student> studentList = sqlSession.selectList("com.kaishengit.entity.Student.findAll");

        for(Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

}
