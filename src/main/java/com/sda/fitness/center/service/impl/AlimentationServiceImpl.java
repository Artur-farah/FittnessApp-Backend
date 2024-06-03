package com.sda.fitness.center.service.impl;

import com.sda.fitness.center.model.Alimentation;
import com.sda.fitness.center.repository.AlimentationRepository;
import com.sda.fitness.center.service.AlimentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlimentationServiceImpl implements AlimentationService {

    @Autowired
    private AlimentationRepository mealsRepository;

    @Override
    public List<Alimentation> getAllMeals() {
        List<Alimentation>mealsList=mealsRepository.findAll();
        return mealsList;
    }

    @Override
    public Optional<Alimentation> getAllMealsById(Long Id) {
        return  mealsRepository.findById(Id);
    }

    @Override
    public Alimentation saveMeal(Alimentation meal) {
        return mealsRepository.save(meal);
    }

    @Override
    public Alimentation updateMeal(Alimentation meal) {
        return mealsRepository.save(meal);
    }

    @Override
    public List<Alimentation> getAllMealsByName(String name) {
        return mealsRepository.findAllMealsByName(name);
    }
}
