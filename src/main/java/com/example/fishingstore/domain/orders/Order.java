package com.example.fishingstore.domain.orders;

import javax.persistence.*;

@Entity
@Table(name="ord")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long customer_id;
    @Column(insertable = false)
    private boolean active;

    public Order(long id, long customer_id,boolean active) {
        this.id = id;
        this.customer_id = customer_id;
        this.active=active;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

