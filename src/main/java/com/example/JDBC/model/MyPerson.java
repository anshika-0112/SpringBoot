package com.example.JDBC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MyPerson {
    @Id
    private Integer id;
    private String name;
}
