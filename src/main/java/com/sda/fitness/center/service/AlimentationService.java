package com.sda.fitness.center.service;
import com.sda.fitness.center.model.Alimentation;

import java.util.List;
import java.util.Optional;

public interface AlimentationService {
    List<Alimentation> getAllMeals();

    Optional<Alimentation> getAllMealsById(Long Id);

    Alimentation saveMeal(Alimentation meal);

    Alimentation updateMeal(Alimentation meal);


    List<Alimentation> getAllMealsByName(String name);

}
