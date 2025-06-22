package com.deliverymatcher.backend.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "packages")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "width")
    private Double width;

    @Column(name = "hight")
    private Double hight;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "type")
    private String type;

    @OneToOne(mappedBy = "pack")
    private Application application;


}
