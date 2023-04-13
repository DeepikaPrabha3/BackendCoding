package com.gl.HibernateMavenDemo.entity;

import jakarta.persistence.Embeddable;

//I do not want 'Address' as a separate. need to use Address a column => use 'Embeddable' for this
@Embeddable //city and country columns will be created in student table => no separate address table will be created
public class Address {
    private String city;
    private String country;

    public Address() {
    }

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
