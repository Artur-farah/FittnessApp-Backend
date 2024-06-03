package com.sda.fitness.center.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="Training Log")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TrainingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="training_id")

    private Long id;
    @Column(name="client_name")
    private String name;
    @Column(name="training_date")
    private LocalDate date;
    @Column(name="meal_name")
    private String meal;



    @ManyToOne
    @JoinColumn(name="client_id")
    private Clients clients;
}
