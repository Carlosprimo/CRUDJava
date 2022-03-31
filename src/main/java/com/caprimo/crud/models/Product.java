package com.caprimo.crud.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name",nullable = false)
    private String productName;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private int price;
}
