package com.example.fishingstore.domain.products;

import javax.persistence.Entity;

@Entity
public class Rod extends Product {
       private Double length;
       private Double testMax;
       private Double testMin;

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getTestMax() {
        return testMax;
    }

    public void setTestMax(Double testMax) {
        this.testMax = testMax;
    }

    public Double getTestMin() {
        return testMin;
    }

    public void setTestMin(Double testMin) {
        this.testMin = testMin;
    }

    public Rod(String name, String manufacturer, Double price, Integer currentlyamount, Double length, Double testMax, Double testMin) {
        super(name, manufacturer, price, currentlyamount);
        this.length = length;
        this.testMax = testMax;
        this.testMin = testMin;
    }

    public Rod() {
    }

    @Override
    public String toString() {
        return "Rod{" +super.toString()+
                "length=" + length +
                ", testMax=" + testMax +
                ", testMin=" + testMin +
                '}';
    }
}
