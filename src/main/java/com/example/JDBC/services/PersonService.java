package com.example.JDBC.services;

import com.example.JDBC.Person;
import com.example.JDBC.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    public List<Person> getAllPerson() throws SQLException {
        return personRepository.getAllPerson();
    }

    public boolean addPerson(Person person) throws SQLException {
        return personRepository.addPerson(person);
    }

    public int updatePerson(String name, Integer id) {
        return personRepository.updatePerson(name,id);
    }
}
