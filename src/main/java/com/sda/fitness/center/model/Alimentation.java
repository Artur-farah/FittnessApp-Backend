package com.sda.fitness.center.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="Alimentation")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Alimentation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="alimentation_id")

    private Long id;
    @Column(name="meal_name", nullable = false)
    private String name;

    @Column(name="alimentation_calories", nullable = false)
    private int calories;
    @Column(name="alimentation_proteins", nullable = false)
    private int proteins;
    @Column(name="alimentation_fats", nullable = false)
    private int fats;
    @Column(name="alimentation_meal", nullable = false)
    private String meal;


    /* @ManyToMany
    @JoinTable(name = "")
    private List<Exercises> exercises;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Clients clients;

     */

}
