package com.example.fishingstore.domain.orders;


import javax.persistence.*;

@MappedSuperclass
public class ProductCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long id_ord;
    private long id_prod;
    private int amount;
    private double price;

    @Column(insertable = false)
    private String type;

    public ProductCart() {
    }

    public ProductCart(long id_ord, long id_prod, int amount, double price, String type) {
        this.id_ord = id_ord;
        this.id_prod = id_prod;
        this.amount = amount;
        this.price = price;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_ord() {
        return id_ord;
    }

    public void setId_ord(long id_ord) {
        this.id_ord = id_ord;
    }

    public long getId_prod() {
        return id_prod;
    }

    public void setId_prod(long id_prod) {
        this.id_prod = id_prod;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProductCart{" +
                "id=" + id +
                ", id_ord=" + id_ord +
                ", id_prod=" + id_prod +
                ", amount=" + amount +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
