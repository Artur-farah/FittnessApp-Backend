package com.sda.fitness.center.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="Exercises")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Exercises {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="exercises_id")
    private Long id;
    @Column(name="exercises_name")
    private String name;
    @Column(name="exercises_duration")
    private int duration;
    @Column(name="exercises_level")
    private String level;


}
