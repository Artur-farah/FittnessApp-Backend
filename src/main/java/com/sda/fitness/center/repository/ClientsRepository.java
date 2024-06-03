package com.sda.fitness.center.repository;

import com.sda.fitness.center.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientsRepository  extends JpaRepository<Clients,Long> {

    List<Clients> findAllClientsByName(String name);
    List<Clients>findAllClientsByNameAndEmail(String name,String email);

}
