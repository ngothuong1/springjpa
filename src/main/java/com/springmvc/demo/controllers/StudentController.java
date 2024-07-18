package com.springmvc.demo.controllers;

import com.springmvc.demo.models.Student;
import com.springmvc.demo.repo.StudentRepo;
import com.springmvc.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "student")
public class StudentController {
    @Autowired // Inject "StudentRepo" - Dependency Injection // tự động tạo mới trong trường hợp không thấy
    private StudentRepo studentRepo;
    private com.springmvc.demo.models.Student Student;

    @GetMapping
    public List<Student> getAllStudents() {
        return StudentService.getAllStudents();
    }

    @GetMapping(value = "id")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
        return ResponseEntity.ok(Student);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return StudentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student studentDetails) {
        Student updatedStudent = StudentService.updateStudent(id, studentDetails);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        StudentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}



