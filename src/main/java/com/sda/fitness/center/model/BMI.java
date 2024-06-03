package com.sda.fitness.center.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="BMI")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BMI {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="BMI_id")
    private Long Id;

    @Column(name="weight_in_kg")
    private double weightInKg;

    @Column(name="height_in_kg")
    private double heightInM;


}