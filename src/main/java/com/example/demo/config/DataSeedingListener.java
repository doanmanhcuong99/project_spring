/*
package com.example.demo.config;

import com.example.demo.entity.AptechClass;
import com.example.demo.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ClassRepository classRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        // Roles
        if (classRepository.findByName("T1708M") == null) {
            classRepository.save(new AptechClass("T1708M"));
        }

        if (classRepository.findByName("T1708M1") == null) {
            classRepository.save(new AptechClass("T1708M1"));
        }

    }
}
*/
