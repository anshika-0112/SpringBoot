package com.example.JDBC.repository;

import com.example.JDBC.Person;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository implements IPerson {

    private final Connection connection;
    PersonRepository(Connection connection) throws SQLException {
        this.connection=connection;
        createTable();
    }
    @Override
    public List<Person> getAllPerson(){
        List<Person> list = new ArrayList<>();
        try{
            ResultSet set=connection.createStatement().executeQuery("select * from person");
            while(set.next()){
                Person p = new Person(set.getString("name"), set.getInt("id"));
                list.add(p);
            }
            return list;
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void createTable() throws SQLException {
        connection.createStatement().execute("create table if not exists person (name varchar(25) , id int);");
    }

    @Override
    public boolean addPerson(Person person) throws SQLException {
        return  connection.createStatement().execute("insert into person (name, id) Values ('"+ person.getName() + "' , '"+person.getId()+"' )");
    }

    @Override
    public int updatePerson(String name, Integer id) throws SQLException {
        boolean autoCommit=connection.getAutoCommit();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement=connection.prepareStatement("update person set name =? where id=?");
            statement.setString(1,name);
            statement.setInt(2,id);
            int res=statement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(autoCommit);
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
