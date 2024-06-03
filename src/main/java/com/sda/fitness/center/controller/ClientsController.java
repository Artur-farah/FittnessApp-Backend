package com.sda.fitness.center.controller;

import com.sda.fitness.center.exception.ResourceNotFoundException;
import com.sda.fitness.center.model.Clients;
import com.sda.fitness.center.service.ClientsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController  
@RequestMapping("/api/clients") 
public class ClientsController {

    private final ClientsService clientsService;

    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @GetMapping
    public ResponseEntity<List<Clients>> getAllClients() {

        return new ResponseEntity<>(clientsService.getAllClients(), HttpStatus.OK);
    }



    @GetMapping("/getClientsById/{id}")
    public ResponseEntity<Clients> readClientsById(@PathVariable Long id) {
        Clients clientsFromDB = clientsService.getAllClientsById(id).orElseThrow(() -> new ResourceNotFoundException("Client with id : " + id + "doesnt exist in Database"));

        return new ResponseEntity<>(clientsFromDB, HttpStatus.OK); //200

    }


    @GetMapping("/getAllClientsByName/{name}")
    public ResponseEntity<List<Clients>> readAllClientsByName(@PathVariable String name) {
        List<Clients> clientsListfromDB = clientsService.getAllClientsByName(name);
        if (clientsListfromDB.size() == 0) {
            throw new ResourceNotFoundException("No clients with the name : " + name + "  not found");
        }
        return new ResponseEntity<>(clientsListfromDB, HttpStatus.OK);
    }



    @GetMapping("/getAllClientsByNameandEmail/{name}/{email}")
    public ResponseEntity<List<Clients>> readAllCientsByNameAndEmail(@PathVariable String name, @PathVariable String email) {
        List<Clients> clientsListfromDB =clientsService.getAllClientsByNameAndEmail(name, email);
        if (clientsListfromDB.size() == 0) {
            throw new ResourceNotFoundException("No clients with the name : " + name + "and" +email+ "  not found");
        }
        return new ResponseEntity<>(clientsListfromDB, HttpStatus.OK);
    }



    @PostMapping("/addNewClient")
    public ResponseEntity<Clients> addClient(@RequestBody Clients client) {
        Clients clientsToBeSaved = clientsService.saveClient(client);
        return new ResponseEntity<>(clientsToBeSaved, HttpStatus.OK);

    }

    @PutMapping("/updateClient")
    public ResponseEntity<Clients> updateClient(@RequestBody Clients client) {
        Clients updatedClient = clientsService.updateClient(client);
        return new ResponseEntity<>(updatedClient, HttpStatus.OK); // return ResponseEntity.ok(updatedClient);
    }


    @DeleteMapping("/deleteClientById/{id}")
    public ResponseEntity<?> removeClientById(@PathVariable Long id) {
       Clients clientsFromDB = clientsService.getAllClientsById(id).orElseThrow(() -> new ResourceNotFoundException("Client with id : " + id + "doesnt exist in Database"));
        clientsService.deleteClientById(id);
        return new ResponseEntity<>("Client with id : " + id + "was deleted", HttpStatus.OK);
    }

}
