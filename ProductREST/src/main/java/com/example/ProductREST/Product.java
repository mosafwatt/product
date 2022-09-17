package com.example.ProductREST;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //represents the product table from db
public class Product {
    private Integer id;
    private String name;
    private Float price;

    public Product() {

    }

    public Product(Integer id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

//Generated getters and setters for the attributes
@Id //primary column
@GeneratedValue(strategy = GenerationType.IDENTITY) //values of ID column will be generated automatically
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }



}
