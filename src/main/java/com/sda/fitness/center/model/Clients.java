package com.sda.fitness.center.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="Clients")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Clients {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="client_id")
    private Long Id;
    @Column(name="client_name")
    private String name;
    @Column(name="client_email")

    private String email;
    @Column(name="client_age")
    private int age;
    @Column(name="client_weight")
    private int weight;
    @Column(name="client_height")
    private int height;

    @OneToMany(mappedBy = "clients")
    private List<TrainingLog> trainingLogs;

}
