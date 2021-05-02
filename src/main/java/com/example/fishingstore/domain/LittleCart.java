package com.example.fishingstore.domain;

public class LittleCart {
    private long id;
    private String name;
    private double price;
    private int amount;
    private String type;

    public LittleCart(long id, String name, double price, int amount, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.amount = amount;
    }

    public LittleCart() {
    }

    @Override
    public String toString() {
        return "LittleCart{" +
                "id=" + id +
                ", name_product='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName_product() {
        return name;
    }

    public void setName_product(String name_product) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
