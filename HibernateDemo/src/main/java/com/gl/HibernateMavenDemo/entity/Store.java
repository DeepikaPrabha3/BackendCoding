package com.gl.HibernateMavenDemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "store")
public class Store {
    @Id
    private String storeid;
    private String storename;
    @OneToMany//One store will have many products
    @JoinColumn(name = "storeid")
    private List<Product> products;

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
