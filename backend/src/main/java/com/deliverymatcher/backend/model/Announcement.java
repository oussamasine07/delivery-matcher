package com.deliverymatcher.backend.model;

import jakarta.persistence.*;

import javax.swing.*;
import java.util.HashSet;
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

    public Announcement () {}




}


























