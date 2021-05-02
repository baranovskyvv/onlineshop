package com.example.fishingstore.domain.products;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private String manufacturer;
    private Double price;
    private Integer currentlyamount;
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Long getId() {
        return Id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCurrentlyamount() {
        return currentlyamount;
    }

    public void setCurrentlyamount(Integer currentlyamount) {
        this.currentlyamount = currentlyamount;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Product(String name, String manufacturer, Double price, Integer currentlyamount) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.currentlyamount = currentlyamount;
    }

    public Product() {
    }
}
