package com.kaishengit.service;

import com.kaishengit.entity.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by zhao on 2017/10/22.
 */
public class StudentServiceTest {

    @Test
    public void findAllStudentsTest() {
        StudentService studentService = new StudentService();
        List<Student> students = studentService.findAllStudents();
        Assert.assertNotNull(students);
        for(Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void createStudentTest() {
        Student student = new Student();
        int id = 3;
        student.setStudId(id);
        student.setName("stu_" + id);
        student.setEmail("stu_" + id + "@163.com");
        student.setDob(new Date());

        StudentService studentService = new StudentService();
        studentService.createStudent(student);

        Student newStudent = studentService.findStudentById(id);
        Assert.assertNotNull(newStudent);
    }

    @Test
    public void findStudentByIdTest() {
        int id = 3;
        StudentService studentService = new StudentService();
        Student student = studentService.findStudentById(3);
        Assert.assertNotNull(student);
        System.out.println(student);
    }

    @Test
    public void deleteStudentByIdTest() {
        int id = 3;
        StudentService studentService = new StudentService();
        studentService.deleteStudentById(3);
    }

    @Test
    public void updateStudent() {
        StudentService studentService = new StudentService();
        Student student = studentService.findStudentById(2);

        student.setName("tom");
        studentService.updateStudent(student);
    }
}
