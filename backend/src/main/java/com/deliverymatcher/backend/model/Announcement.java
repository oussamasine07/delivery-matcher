package com.deliverymatcher.backend.model;

import jakarta.persistence.*;

import javax.swing.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "announcements")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "departure_destination")
    private String departureDestination;

    @Column(name = "final_destination")
    private String finalDestination;

    @Column(name = "max_dimentions")
    private double maxDimentions;

    @Column(name = "goods_type")
    private String goodsType;

    @Column(name = "capacity")
    private double capacity;

    @ManyToMany
    @JoinTable(
            name = "passed_by_cities",
            joinColumns = @JoinColumn(name = "announcement_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id")
    )
    private Set<City> passedByCities = new HashSet<>();

    @ManyToOne
    private Driver driver;

    @OneToMany(mappedBy = "announcement")
    private List<Journy> journies;

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

    public String getDepartureDestination() {
        return departureDestination;
    }

    public void setDepartureDestination(String departureDestination) {
        this.departureDestination = departureDestination;
    }

    public String getFinalDestination() {
        return finalDestination;
    }

    public void setFinalDestination(String finalDestination) {
        this.finalDestination = finalDestination;
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

    public Set<City> getPassedByCities() {
        return passedByCities;
    }

    public void setPassedByCities(Set<City> passedByCities) {
        this.passedByCities = passedByCities;
    }

    public List<Journy> getJournies() {
        return journies;
    }

    public void setJournies(List<Journy> journies) {
        this.journies = journies;
    }
}


























