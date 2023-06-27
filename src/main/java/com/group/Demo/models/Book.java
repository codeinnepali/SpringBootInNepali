package com.group.Demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Book {
    @Id
    private  Long id;

    @OneToOne(mappedBy = "book")
    private  Student student;
}
