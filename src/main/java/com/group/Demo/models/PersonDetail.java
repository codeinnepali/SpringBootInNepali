package com.group.Demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PersonDetail {
    @Id
    private int id;
    private String name;
    private int roll;
}
