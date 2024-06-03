package com.sda.fitness.center.repository;


import com.sda.fitness.center.model.Exercises;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExercisesRepository extends JpaRepository<Exercises, Long> {
    List<Exercises> findAllExercisesByName(String name);

    List<Exercises> findAllExercisesByLevel(String level);

    List<Exercises> findAllExercisesByDuration(int duration);

}
