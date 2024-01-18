package com.example.JDBC.repository;

import com.example.JDBC.Person;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface IPerson {
    List<Person> getAllPerson() throws SQLException;
    boolean addPerson(Person person) throws SQLException ;

    int updatePerson(String name, Integer id) throws SQLException;

}
