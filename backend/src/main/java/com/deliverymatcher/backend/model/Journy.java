package com.deliverymatcher.backend.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "journies")
public class Journy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "journy name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "departure_destination", referencedColumnName = "id")
    private City departureDestination;

    @ManyToOne
    @JoinColumn(name = "final_destination", referencedColumnName = "id")
    private City finalDestination;

    @ManyToMany
    @JoinTable(
            name = "passed_by_cities",
            joinColumns = @JoinColumn(name = "journy_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id")

    )
    private List<City> passedByCities;

    @OneToMany(mappedBy = "journy")
    private List<Travel> travels;

    @OneToMany(mappedBy = "journy")
    private List<Announcement> announcements;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public City getDepartureDestination() {
        return departureDestination;
    }

    public void setDepartureDestination(City departureDestination) {
        this.departureDestination = departureDestination;
    }

    public City getFinalDestination() {
        return finalDestination;
    }

    public void setFinalDestination(City finalDestination) {
        this.finalDestination = finalDestination;
    }

    public List<City> getPassedByCities() {
        return passedByCities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassedByCities(List<City> passedByCities) {
        this.passedByCities = passedByCities;
    }
}




















