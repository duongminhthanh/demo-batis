package com.example.demo;

import com.example.demo.config.AppConfig;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

public class DemoApplication {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentService studentService = (StudentService) context.getBean("studentService");

        // create student
        Student student1 = new Student("Jim", "Java Dev", 95, 1234568, "jimdev@gmail.com");

        // insert student
        studentService.insertStudent(student1);
        System.out.println("insert : " + student1);

        // select all student
        List<Student> listStudents = studentService.selectAllStudent();
        System.out.println("select all : ");
        for (Student student : listStudents) {
            System.out.println(student);
        }

        // select student by id
        Student student2 = studentService.selectStudentById(1);

        // update student
        student2.setPercentage(99);
        studentService.updateStudent(student2);
        System.out.println("update : " + student2);

        // delete student by id
        studentService.deleteStudentById(student2.getId());
        System.out.println("delete : " + student2);

    }

}
