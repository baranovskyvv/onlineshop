package com.example.fishingstore.domain;

public class ListOrder {
    private long id;
    private String username;
    private boolean active;

    public ListOrder(long id, String username, boolean active) {
        this.id = id;
        this.username = username;
        this.active = active;
    }

    public ListOrder() {
    }

    public long getId_ord() {
        return id;
    }

    public void setId_ord(long id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ListOrder{" +
                "id_ord=" + id +
                 ", username='" + username +
                ", active=" + active +
                '}';
    }
}
