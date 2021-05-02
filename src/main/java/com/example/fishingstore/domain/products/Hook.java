package com.example.fishingstore.domain.products;

import javax.persistence.Entity;

@Entity
public class Hook extends Product{
  private Integer size;

    public Integer getSize() {
              return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Hook(String name, String manufacturer, Double price, Integer currentlyamount, Integer size) {
        super(name, manufacturer, price, currentlyamount);
        this.size = size;
    }

    public Hook() {
    }



}
