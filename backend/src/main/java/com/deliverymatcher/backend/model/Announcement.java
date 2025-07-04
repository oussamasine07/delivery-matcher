package com.deliverymatcher.backend.model;

import jakarta.persistence.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "announcements")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "max_dimentions", nullable = false)
    private double maxDimentions;

    @Column(name = "goods_type", nullable = false)
    private String goodsType;

    @Column(name = "capacity", nullable = false)
    private double capacity;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Journy journy;

    @OneToMany(mappedBy = "announcement")
    private List<Application> applications;

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public Announcement () {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxDimentions() {
        return maxDimentions;
    }

    public void setMaxDimentions(double maxDimentions) {
        this.maxDimentions = maxDimentions;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public Journy getJourny() {
        return journy;
    }

    public void setJourny(Journy journy) {
        this.journy = journy;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}


























