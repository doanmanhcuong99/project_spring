package com.example.demo.config;

import com.example.demo.entity.AptechClass;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepositoty;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    StudentService studentService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = studentService.getByEmail(email);
        if (student == null){
            throw new UsernameNotFoundException("User not found");
        }
        return User.builder()
                .username(student.getEmail())
                .password(student.getPassword())
                .roles(student.getRole())
                .build();

    }
}
