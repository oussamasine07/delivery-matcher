package com.deliverymatcher.backend.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "take_off", nullable = false)
    private LocalTime takeOff;

    @Column(name = "arrived_at")
    private LocalTime arrivedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "journy_status", nullable = false)
    private JournyStatus journyStatus;

    @OneToOne
    @JoinColumn(name = "road_to", referencedColumnName = "id")
    private City roadTo;

    @OneToOne
    @JoinColumn(name = "current_destination", referencedColumnName = "id")
    private City currentDestination;

    @ManyToOne
    private Journy journy;

    public Journy getJourny() {
        return journy;
    }

    public void setJourny(Journy journy) {
        this.journy = journy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(LocalTime takeOff) {
        this.takeOff = takeOff;
    }

    public LocalTime getArrivedAt() {
        return arrivedAt;
    }

    public void setArrivedAt(LocalTime arrivedAt) {
        this.arrivedAt = arrivedAt;
    }

    public JournyStatus getJournyStatus() {
        return journyStatus;
    }

    public void setJournyStatus(JournyStatus journyStatus) {
        this.journyStatus = journyStatus;
    }

    public City getRoadTo() {
        return roadTo;
    }

    public void setRoadTo(City roadTo) {
        this.roadTo = roadTo;
    }

    public City getCurrentDestination() {
        return currentDestination;
    }

    public void setCurrentDestination(City currentDestination) {
        this.currentDestination = currentDestination;
    }
}








