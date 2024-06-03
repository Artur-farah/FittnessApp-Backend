package com.sda.fitness.center.controller;

import com.sda.fitness.center.exception.ResourceNotFoundException;
import com.sda.fitness.center.model.Alimentation;
import com.sda.fitness.center.service.AlimentationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/meals")
public class AlimentationController {
    private final AlimentationService mealsService;

    public AlimentationController(AlimentationService mealsService) {
        this.mealsService = mealsService;
    }

    @GetMapping
    public ResponseEntity<List<Alimentation>> getAllMeals() {
        return new ResponseEntity<>(mealsService.getAllMeals(), HttpStatus.OK);
    }

    @GetMapping("/getMealsById/{id}")
    public ResponseEntity<Alimentation> readMealsById(@PathVariable Long id) {
        Alimentation mealsFromDB = mealsService
                .getAllMealsById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meal with id : " + id + "doesn't exist in the database"));
        return new ResponseEntity<>(mealsFromDB, HttpStatus.OK); //200

    }

    @PostMapping("/addNewMeal")
    public ResponseEntity<Alimentation> addMeal(@RequestBody Alimentation meal) {
        Alimentation mealsToBeSaved = mealsService.saveMeal(meal);
        return new ResponseEntity<>(mealsToBeSaved, HttpStatus.OK);
    }

    @PutMapping("/updateMeal")
    public ResponseEntity<Alimentation> updateMeal(@RequestBody Alimentation meal) {
        Alimentation updatedMeal = mealsService.updateMeal(meal);
        return new ResponseEntity<>(updatedMeal, HttpStatus.OK);
    }


    public ResponseEntity<List<Alimentation>> readAllMealsByName(@PathVariable String name) {
        List<Alimentation> mealsListfromDB = mealsService.getAllMealsByName(name);
        if (mealsListfromDB.size() == 0) {
            throw new ResourceNotFoundException("No meals with the name : " + name + "  not found");
        }
        return new ResponseEntity<>(mealsListfromDB, HttpStatus.OK);
    }

}
