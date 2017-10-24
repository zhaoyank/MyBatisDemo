package com.kaishengit.mapper;

import com.kaishengit.entity.Student;

import java.util.List;

/**
 * Created by zhao on 2017/10/22.
 * @author zhao
 */
public interface StudentMapper {
    /**
     * 查询所有学生
     * @return 学生列表
     */
    List<Student> findAllStudents();

    /**
     * 根据id查找学生
     * @param id
     * @return id为param的学生
     */
    Student findStudentById(Integer id);

    /**
     * 向Student表插入新学生
     * @param student
     */
    void insertStudent(Student student);

    /**
     * 根据id删除
     * @param id
     */
    void deleteStudentById(Integer id);

    /**
     * 更新学生信息
     * @param student
     */
    void updateStudent(Student student);
}
