package com.sda.fitness.center.controller;


import com.sda.fitness.center.exception.ResourceNotFoundException;
import com.sda.fitness.center.model.TrainingLog;
import com.sda.fitness.center.service.TrainingLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/trainingLog") // base url : http://localhost:8081/api/trainingLog
public class TrainingLogController {

    private final TrainingLogService trainingLogService;

    public TrainingLogController(TrainingLogService trainingLogService) {
        this.trainingLogService = trainingLogService;
    }

    @GetMapping
    public ResponseEntity<List<TrainingLog>> getAllTrainingLogs(){
        return  new ResponseEntity<>(trainingLogService.getAllTrainings(), HttpStatus.OK);

    }

    @GetMapping("/getTrainingLogById/{id}")
    public ResponseEntity<TrainingLog>readTrainingsById(@PathVariable Long id){
        TrainingLog trainingLogFromDB=trainingLogService.getTrainingLogById(id).orElseThrow(() -> new ResourceNotFoundException("TrainingLog with id : "+id+"doesnt exist in Database"));
        return new ResponseEntity<>(trainingLogFromDB,HttpStatus.OK);

    }

    @GetMapping("/getAllTrainingLogsByName/{name}")
    public ResponseEntity<List<TrainingLog>> readAllTrainingLogsByName(@PathVariable String name){
        List<TrainingLog> trainingLogfromDB= trainingLogService.getAllTrainingLogByName(name);
        if(trainingLogfromDB.size()==0){
            throw new ResourceNotFoundException("Training logs with the name : "+name+"  not found");
        }
        return new ResponseEntity<>(trainingLogfromDB,HttpStatus.OK);
    }


    @GetMapping("/getAllTrainingLogsByNameAndDate/{name}/{date}")
    public ResponseEntity<List<TrainingLog>> readAllTrainingLogsByNameAndPrice(@PathVariable String name,@PathVariable LocalDate date){
        List<TrainingLog>trainingLogfromDB= trainingLogService.getAllTrainingLogByNameAndDate(name,date);
        if(trainingLogfromDB.size()==0){
            throw new ResourceNotFoundException("No products with the name : "+name+ "and" +date +"  not found");
        }
        return new ResponseEntity<>(trainingLogfromDB,HttpStatus.OK);
    }

    @PostMapping("/addNewTrainingLog")
    public ResponseEntity<TrainingLog> addTraining(@RequestBody TrainingLog trainingLog){
        TrainingLog trainingToBeSaved=trainingLogService.saveTrainingLog(trainingLog);
        return new ResponseEntity<>(trainingToBeSaved ,HttpStatus.OK);

    }

    @PutMapping("/updateTraining")
    public ResponseEntity<TrainingLog> updateTraining(@RequestBody TrainingLog trainingLog){
       TrainingLog updatedTraining=trainingLogService.updateTrainingLog(trainingLog) ;
        return new ResponseEntity<>(updatedTraining,HttpStatus.OK);
    }

    @DeleteMapping("/deleteTrainingLogById/{id}")
    public  ResponseEntity<?> removeTrainingLogById(@PathVariable Long id){
       TrainingLog trainingLogFromDB=trainingLogService.getTrainingLogById(id).orElseThrow(() ->new ResourceNotFoundException("Training log  with id : "+id+"doesnt exist in Database"));
       trainingLogService.deleteTrainingLogById(id);
        return new ResponseEntity<>("Training log with id : "+id+ "was deleted",HttpStatus.OK);
    }

}
