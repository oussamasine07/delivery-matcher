package com.deliverymatcher.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "drivers")
public class Driver extends User {

    @Column(name = "number_of_trucks", nullable = true)
    private int numberOfTrucks;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    public Driver () {}

    public int getNumberOfTrucks() {
        return numberOfTrucks;
    }

    public void setNumberOfTrucks(int numberOfTrucks) {
        this.numberOfTrucks = numberOfTrucks;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
