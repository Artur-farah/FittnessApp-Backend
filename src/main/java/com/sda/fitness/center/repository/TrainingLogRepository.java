package com.sda.fitness.center.repository;

import com.sda.fitness.center.model.TrainingLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TrainingLogRepository extends JpaRepository<TrainingLog,Long> {

    List<TrainingLog> findAllTrainingsByName(String name);
    List<TrainingLog> findAllTrainingsByNameAndDate(String name, LocalDate date);



}
