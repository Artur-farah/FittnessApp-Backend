package com.sda.fitness.center.service.impl;


import com.sda.fitness.center.model.Exercises;
import com.sda.fitness.center.repository.ExercisesRepository;
import com.sda.fitness.center.service.ExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercisesServiceImpl implements ExercisesService {
    @Autowired
    private ExercisesRepository exercisesRepository;


    @Override
    public List<Exercises> getAllExercises() {
        List<Exercises>exercisesList=exercisesRepository.findAll();
        return exercisesList;
    }

    @Override
    public Optional<Exercises> getAllExercisesById(Long Id) {
        return exercisesRepository.findById(Id);
    }

    @Override
    public Exercises saveExercise(Exercises exercise) {
        return exercisesRepository.save(exercise);
    }

    @Override
    public void deleteExerciseById(Long id) {

        exercisesRepository.deleteById(id);
    }

    @Override
    public List<Exercises> getAllExercisessByDuration(int duration) {
        return exercisesRepository.findAllExercisesByDuration(duration);
    }


}
