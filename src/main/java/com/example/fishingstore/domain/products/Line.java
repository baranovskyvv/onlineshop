package com.example.fishingstore.domain.products;

import javax.persistence.Entity;

@Entity
public class Line extends Product {
   private double length;
   private double diameter;

    public Line(String name, String manufacturer, double price, Integer currentlyamount, double length, double diameter) {
        super(name, manufacturer, price, currentlyamount);
        this.length = length;
        this.diameter = diameter;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public Line() {
         }

    @Override
    public String toString() {
        return "Line{" +
                "length=" + length +
                ", diameter=" + diameter +
                '}';
    }
}
