package com.springmvc.demo.service;

import com.springmvc.demo.models.Student;
import com.springmvc.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private static StudentRepo studentRepo;

    public static List<Student> getAllStudents() {
        return (List<Student>) studentRepo.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepo.findById(Math.toIntExact(id));
    }

    public static Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    public static Student updateStudent(Integer id, Student studentDetails){
        Student student = studentRepo.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
        student.setName(studentDetails.getName());
        student.setAge(studentDetails.getAge());

        return studentRepo.save(student);
    }

    public static void deleteStudent(Integer id) {
        studentRepo.deleteById(id);
    }



}
