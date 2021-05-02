package com.example.fishingstore.domain.products;

import javax.persistence.Entity;

@Entity
public class Reel extends Product {
    private Integer amount_balls;

    public Integer getAmount_balls() {
        return amount_balls;
    }

    public void setAmount_balls(Integer amount_balls) {
        this.amount_balls = amount_balls;
    }

    public Reel(String name, String manufacturer, Double price, Integer currentlyamount, Integer amount_balls) {
        super(name, manufacturer, price, currentlyamount);
        this.amount_balls = amount_balls;
    }

    public Reel() { }

    @Override
    public String toString() {
        return "Reel{"+super.toString() +
                "amount_balls=" + amount_balls +
                '}';
    }
}
