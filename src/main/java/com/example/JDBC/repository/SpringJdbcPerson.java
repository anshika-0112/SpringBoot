package com.example.JDBC.repository;

import com.example.JDBC.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class SpringJdbcPerson implements IPerson{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Person> getAllPerson() throws SQLException {
        return jdbcTemplate.query("select * from person", (rs, rowNum) ->
                new Person(rs.getString("name"), rs.getInt("id")));
    }

    @Override
    public boolean addPerson(Person person) throws SQLException {
        MapSqlParameterSource parameterSource=new MapSqlParameterSource();
        parameterSource.addValue("name",person.getName());
        parameterSource.addValue("id",person.getId());
        namedParameterJdbcTemplate.update("insert into person (name,id) VALUES(:name,:id)",parameterSource);
        return false;
    }

    @Override
    public int updatePerson(String name, Integer id) throws SQLException {
        return 0;
    }
}
