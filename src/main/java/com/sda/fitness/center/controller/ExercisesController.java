package com.sda.fitness.center.controller;



import com.sda.fitness.center.exception.ResourceNotFoundException;

import com.sda.fitness.center.model.Exercises;
import com.sda.fitness.center.service.ExercisesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/exercises")
public class ExercisesController {

    private final ExercisesService exercisesService;

    public ExercisesController(ExercisesService exercisesService) {
        this.exercisesService = exercisesService;
    }

    @GetMapping
    public ResponseEntity<List<Exercises>> getAllExercises() {

        return new ResponseEntity<>(exercisesService.getAllExercises(), HttpStatus.OK);
    }

    @GetMapping("/getExercisesById/{id}")
    public ResponseEntity<Exercises> readExercisesById(@PathVariable Long id) {
       Exercises exercisesFromDB = exercisesService.getAllExercisesById(id).orElseThrow(() -> new ResourceNotFoundException("Exercise with id : " + id + "doesnt exist in Database"));

        return new ResponseEntity<>(exercisesFromDB, HttpStatus.OK); //200

    }

    @PostMapping("/addNewExercise")
    public ResponseEntity<Exercises> addExercise(@RequestBody Exercises exercise) {
        Exercises exercisesToBeSaved = exercisesService.saveExercise(exercise);
        return new ResponseEntity<>(exercisesToBeSaved, HttpStatus.OK);

    }

    @DeleteMapping("/deleteExerciseId/{id}")
    public ResponseEntity<?> removeExerciseById(@PathVariable Long id) {
        Exercises exercisesFromDB = exercisesService.getAllExercisesById(id).orElseThrow(() -> new ResourceNotFoundException("Exercise with id : " + id + "doesnt exist in Database"));
        exercisesService.deleteExerciseById(id);
        return new ResponseEntity<>("Exercise with id : " + id + "was deleted", HttpStatus.OK);
    }

    @GetMapping("/getAllExercisesByduration/{duration}")
    public ResponseEntity<List<Exercises>> readAllExercisesByDuration(@PathVariable int duration ) {
        List<Exercises> exercisesListfromDB =exercisesService.getAllExercisessByDuration(duration);
        if (exercisesListfromDB.size() == 0) {
            throw new ResourceNotFoundException("No clients with the name : " + duration + "  not found");
        }
        return new ResponseEntity<>(exercisesListfromDB, HttpStatus.OK);
    }

}

