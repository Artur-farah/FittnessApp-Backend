package com.sda.fitness.center.service;

public interface BMIService {
    double calculateBMI(double weightInKg, double heightInM);

    String interpretBMI(double bmi);
}
