package com.kaishengit.service;

import com.kaishengit.entity.Student;
import com.kaishengit.mapper.StudentMapper;
import com.kaishengit.util.MybatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by zhao on 2017/10/22.
 * @author zhao
 */
public class StudentService {

    public List<Student> findAllStudents() {
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findAllStudents();
        } finally {
            sqlSession.close();
        }
    }

    public Student findStudentById(Integer id) {
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findStudentById(id);
        } finally {
            sqlSession.close();
        }
    }

    public void createStudent(Student student) {
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.insertStudent(student);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteStudentById(Integer id) {
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.deleteStudentById(id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void updateStudent(Student student) {
        SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.updateStudent(student);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
