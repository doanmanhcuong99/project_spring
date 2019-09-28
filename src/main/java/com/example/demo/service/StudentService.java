package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepositoty studentRepositoty;
    @Autowired
    PasswordEncoder passwordEncoder;


    public Student login(String email, String password) {
        // Tìm tài khoản có email trùng xem tồn tại không.
        Optional<Student> optionalAccount = studentRepositoty.findById(email);
        if (optionalAccount.isPresent()) {
            Student student = optionalAccount.get();
            if (student.getPassword().equals(password)) {
                return student;
            }
        }

        return null;
    }

    public Student create(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setCreateAt(Calendar.getInstance().getTimeInMillis());
        student.setUpdateAt(Calendar.getInstance().getTimeInMillis());
        student.setStatus(1);
        return studentRepositoty.save(student);
    }

    public Student getDetail(String email) {
        return studentRepositoty.findById(email).orElse(null);
    }

    public Page<Student> getList(int page, int limit) {
        return studentRepositoty.findAll(PageRequest.of(page - 1, limit));
    }

    public Student getByEmail(String email) {
        return studentRepositoty.findById(email).orElse(null);
    }
}
