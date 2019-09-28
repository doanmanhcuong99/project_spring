package com.example.demo.repository;

import com.example.demo.entity.AptechClass;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClassRepository extends JpaRepository<AptechClass, Integer> {
}
