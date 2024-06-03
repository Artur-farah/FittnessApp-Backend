package com.sda.fitness.center.service;

import com.sda.fitness.center.model.Clients;

import java.util.List;
import java.util.Optional;

public interface ClientsService {

    List<Clients>getAllClients();

    Optional<Clients>getAllClientsById(Long Id);

    Clients saveClient(Clients client);

    Clients updateClient(Clients client);

    void deleteClientById(Long id);

    List<Clients>getAllClientsByName(String name);

    List<Clients>getAllClientsByNameAndEmail(String name,String email);

}
