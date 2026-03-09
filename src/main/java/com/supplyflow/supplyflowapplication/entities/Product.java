package com.supplyflow.supplyflowapplication.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    public Product() {
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    @Id
    private int id1;
    private int id;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Product(int id, int quantity, double price, String category, String name) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.name = name;
    }
}
