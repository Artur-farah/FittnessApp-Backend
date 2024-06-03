package com.sda.fitness.center.service.impl;

import com.sda.fitness.center.model.TrainingLog;
import com.sda.fitness.center.repository.TrainingLogRepository;
import com.sda.fitness.center.service.TrainingLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingLogServiceImpl implements TrainingLogService {

    @Autowired
    private TrainingLogRepository trainingLogRepository;

    @Override
    public List<TrainingLog> getAllTrainings() {
        List<TrainingLog>trainingLogList= trainingLogRepository.findAll();
        return trainingLogList;
    }

    @Override
    public Optional<TrainingLog> getTrainingLogById(Long id) {
        return trainingLogRepository.findById(id);
    }

    @Override
    public TrainingLog saveTrainingLog(TrainingLog training) {
        return trainingLogRepository.save(training);
    }

    @Override
    public TrainingLog updateTrainingLog(TrainingLog training) {
        return trainingLogRepository.save(training);
    }

    @Override
    public void deleteTrainingLogById(Long id) {
        trainingLogRepository.deleteById(id);

    }

    @Override
    public List<TrainingLog> getAllTrainingLogByName(String name) {
        return trainingLogRepository.findAllTrainingsByName(name);
    }

    @Override
    public List<TrainingLog> getAllTrainingLogByNameAndDate(String name, LocalDate date) {
        return trainingLogRepository.findAllTrainingsByNameAndDate(name,date);
    }


}
