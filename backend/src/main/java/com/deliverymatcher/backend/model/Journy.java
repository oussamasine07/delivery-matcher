package com.deliverymatcher.backend.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "journies")
public class Journy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "take_off_at", nullable = false)
    private LocalDate takeOffAt;

    @Column(name = "arrived_at", nullable = true)
    private LocalDate arrivedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "road_to", referencedColumnName = "id")
    private City roadTo;

    @Enumerated(EnumType.STRING)
    @Column(name = "journy_stats", columnDefinition = "VARCHAR(255) DEFAULT 'STAND_BY'")
    private JournyStatus journyStatus;

    @ManyToOne
    private Announcement announcement;

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

    public LocalDate getTakeOffAt() {
        return takeOffAt;
    }

    public void setTakeOffAt(LocalDate takeOffAt) {
        this.takeOffAt = takeOffAt;
    }

    public LocalDate getArrivedAt() {
        return arrivedAt;
    }

    public void setArrivedAt(LocalDate arrivedAt) {
        this.arrivedAt = arrivedAt;
    }

    public City getRoadTo() {
        return roadTo;
    }

    public void setRoadTo(City roadTo) {
        this.roadTo = roadTo;
    }

    public JournyStatus getJournyStatus() {
        return journyStatus;
    }

    public void setJournyStatus(JournyStatus journyStatus) {
        this.journyStatus = journyStatus;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }
}




















