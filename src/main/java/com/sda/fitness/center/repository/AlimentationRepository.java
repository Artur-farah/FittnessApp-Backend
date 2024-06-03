package com.sda.fitness.center.repository;

import com.sda.fitness.center.model.Alimentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlimentationRepository extends JpaRepository<Alimentation,Long> {

    List<Alimentation> findAllMealsByName(String name);


}
