package com.example.JDBC.controllers;

import com.example.JDBC.JdbcApplication;
import com.example.JDBC.Person;
import com.example.JDBC.services.PersonService;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PersonController {
    private static final Logger log= LoggerFactory.getLogger(JdbcApplication.class);

    @Autowired
    private PersonService personService;
    @GetMapping("/getPersons")
    private List<Person> getAllPerson() throws SQLException {
        return personService.getAllPerson();
    }

    @PostMapping("/addPerson")
    private ResponseEntity<Boolean> addPerson(@RequestBody Person person) throws SQLException {
        log.info("name is here "+ person.getName());
        if(person.getName()==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(personService.addPerson(person),HttpStatus.CREATED);
        }
    }

    @PutMapping("/updatePerson")
    private int updatePerson(@RequestParam String name, @RequestParam Integer id) throws Exception {
        if(id==null){
            throw new Exception("Id cannot be null");
        }
        else {
            return personService.updatePerson(name,id);
        }
    }
}
