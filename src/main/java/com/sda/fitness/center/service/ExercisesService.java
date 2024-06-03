package com.sda.fitness.center.service;

import com.sda.fitness.center.model.Exercises;

import java.util.List;
import java.util.Optional;

public interface ExercisesService {
    List<Exercises> getAllExercises();

    Optional<Exercises> getAllExercisesById(Long Id);

    Exercises saveExercise(Exercises exercise);


    void deleteExerciseById(Long id);

    List<Exercises>getAllExercisessByDuration(int duration);


}
