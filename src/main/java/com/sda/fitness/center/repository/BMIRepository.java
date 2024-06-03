package com.sda.fitness.center.repository;

import com.sda.fitness.center.model.BMI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BMIRepository extends JpaRepository<BMI, Long> {

}
