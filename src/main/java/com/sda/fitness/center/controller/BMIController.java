package com.sda.fitness.center.controller;


import com.sda.fitness.center.model.BMI;
import com.sda.fitness.center.service.BMIService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/bmi")
public class BMIController {
    private final BMIService bmiService;

    public BMIController(BMIService bmiService) {
        this.bmiService = bmiService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<String> calculateBMI(@RequestBody BMI bmiCalculator) {
        double bmi = bmiService.calculateBMI(bmiCalculator.getWeightInKg(), bmiCalculator.getHeightInM());
        String interpretation = bmiService.interpretBMI(bmi);

        return ResponseEntity.ok("BMI-ul este: " + bmi + ". Interpretare: " + interpretation);
    }
}
