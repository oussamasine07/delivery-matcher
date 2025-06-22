package com.deliverymatcher.backend.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_date")
    private LocalDate applicationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "application_status")
    private ApplicationStatus applicationStatus;

    @ManyToOne
    private Announcement announcement;

    @ManyToOne
    private Sender sender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "package_id", referencedColumnName = "id")
    private Package pack;

}
