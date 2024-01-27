package com.example.JDBC;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DBbean {
    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "");
    }

//    @Bean
//    public DataSource getDb(){
//        DataSourceBuilder builder= DataSourceBuilder.create(); //helps us to create object of DataSource
//        builder.url("jdbc:mysql://localhost:3306/jdbc");
//        builder.username("root");
//        builder.password("");
//        return builder.build();
//    }
}
