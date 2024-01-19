package com.example.JDBC.repository;

import com.example.JDBC.model.MyPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyPersonRepository extends JpaRepository<MyPerson,Integer> {
}
