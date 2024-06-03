package com.sda.fitness.center.service;

import com.sda.fitness.center.model.TrainingLog;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TrainingLogService {

    List<TrainingLog>getAllTrainings();

    Optional<TrainingLog> getTrainingLogById(Long id);

    TrainingLog saveTrainingLog(TrainingLog training);


    TrainingLog updateTrainingLog(TrainingLog training);

    void deleteTrainingLogById(Long id);

    List<TrainingLog>getAllTrainingLogByName(String name);

    List<TrainingLog>getAllTrainingLogByNameAndDate(String name, LocalDate date);





}
