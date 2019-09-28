package com.example.demo.service;

import com.example.demo.entity.AptechClass;
import com.example.demo.entity.Student;
import com.example.demo.repository.ClassRepository;
import com.example.demo.repository.StudentRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepositoty studentRepositoty;
    @Autowired
    ClassRepository classRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    public Student create(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setCreateAt(Calendar.getInstance().getTimeInMillis());
        student.setUpdateAt(Calendar.getInstance().getTimeInMillis());
        student.setRole(Student.Role.STUDENT.getValue());
        student.setStatus(1);
        return studentRepositoty.save(student);
    }


    public Page<Student> getList(int page, int limit) {
        return studentRepositoty.findAll(PageRequest.of(page - 1, limit));
    }
        public Student getDetail(int id) {
        return studentRepositoty.findById(id).orElse(null);
    }

    public Student getByEmail(String email) {
        return studentRepositoty.findByEmail(email).orElse(null);
    }

}
