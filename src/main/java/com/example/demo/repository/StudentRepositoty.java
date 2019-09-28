package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepositoty extends JpaRepository<Student, Integer> {
    Optional<Student> findByEmail(String email);
}
