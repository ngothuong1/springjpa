package com.springmvc.demo.repo;

import com.springmvc.demo.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Integer> {

}
