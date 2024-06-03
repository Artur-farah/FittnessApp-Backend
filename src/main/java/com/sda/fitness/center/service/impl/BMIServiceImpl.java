package com.sda.fitness.center.service.impl;

import com.sda.fitness.center.repository.BMIRepository;
import com.sda.fitness.center.service.BMIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BMIServiceImpl implements BMIService {

    @Autowired
    private BMIRepository bmiRepository;

    @Override
    public double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    @Override
    public String interpretBMI(double bmi) {
        if (bmi < 18.5) {
            return "Subponderal";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Supraponderal";
        } else {
            return "Obezitate";
        }
    }
}
