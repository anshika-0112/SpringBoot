package com.example.JDBC.services;

import com.example.JDBC.CustomException;
import com.example.JDBC.Person;
import com.example.JDBC.model.MyPerson;
import com.example.JDBC.repository.IPerson;
import com.example.JDBC.repository.MyPersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Transactional(rollbackOn = {CustomException.class})
    public boolean addPerson(Person person) throws SQLException,CustomException {
        MyPerson myPerson = new MyPerson(person.getName()); //id can be generated by backend
        MyPerson p =  myPersonRepository.save(myPerson);
        if(p.getName().equalsIgnoreCase("yuvi")){
            throw new CustomException("not valid");
        }
        return true;
    }

    public int updatePerson(String name, Integer id) throws SQLException {
        return iPerson.updatePerson(name,id);
    }
}
