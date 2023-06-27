package com.group.Demo.models;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
}
