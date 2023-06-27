package com.group.Demo.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Customers {
    @Id
    private  Long id;


    @ManyToMany
    @JoinTable(name = "customers_products", joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<Products> products;
}
