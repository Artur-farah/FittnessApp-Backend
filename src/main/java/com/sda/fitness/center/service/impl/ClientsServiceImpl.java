package com.sda.fitness.center.service.impl;

import com.sda.fitness.center.model.Clients;
import com.sda.fitness.center.repository.ClientsRepository;
import com.sda.fitness.center.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    @Override
    public List<Clients> getAllClients() {
        List<Clients> clientsList = clientsRepository.findAll();
        return clientsList;
    }

    @Override
    public Optional<Clients> getAllClientsById(Long id) {
        return clientsRepository.findById(id);
    }

    @Override
    public Clients saveClient(Clients client) {
        return clientsRepository.save(client);
    }

    @Override
    public Clients updateClient(Clients client) {
        return clientsRepository.save(client);
    }

    @Override
    public void deleteClientById(Long id) {
        clientsRepository.deleteById(id);
    }

    @Override
    public List<Clients> getAllClientsByName(String name) {
        return clientsRepository.findAllClientsByName(name);
    }

    @Override
    public List<Clients> getAllClientsByNameAndEmail(String name, String email) {
        return clientsRepository.findAllClientsByNameAndEmail(name, email);
    }
}
