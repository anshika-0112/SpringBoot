package com.example.JDBC.services;

import com.example.JDBC.Person;
import com.example.JDBC.model.MyPerson;
import com.example.JDBC.repository.IPerson;
import com.example.JDBC.repository.MyPersonRepository;
import com.example.JDBC.repository.PersonRepository;
import com.example.JDBC.repository.SpringJdbcPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    @Qualifier("personRepository")
    private IPerson iPerson;

    @Autowired
    private MyPersonRepository myPersonRepository;
    public List<Person> getAllPerson() throws SQLException {
        return iPerson.getAllPerson();
    }

    public boolean addPerson(Person person) throws SQLException {
        MyPerson myPerson = new MyPerson(person.getId(), person.getName());
        MyPerson p =  myPersonRepository.save(myPerson);
        return true;
    }

    public int updatePerson(String name, Integer id) throws SQLException {
        return iPerson.updatePerson(name,id);
    }
}
