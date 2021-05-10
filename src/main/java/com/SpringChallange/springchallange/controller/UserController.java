package com.SpringChallange.springchallange.controller;

import com.SpringChallange.springchallange.dto.ClientDTO;
import com.SpringChallange.springchallange.exception.ClientException;
import com.SpringChallange.springchallange.exception.InternalServerException;
import com.SpringChallange.springchallange.model.ClientValidator;
import com.SpringChallange.springchallange.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    IClientService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/api/v1/add-client")
    public void addNewClient(@RequestBody ClientDTO client) throws InternalServerException, IOException, ClientException {
        if(!ClientValidator.validateSchema(client)){
            throw new ClientException("Invalid client input");
        }
        service.addClient(client);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/api/v1/clients")
    public List<ClientDTO> getAllClients(String provincia) throws InternalServerException, IOException, ClientException {
        if(provincia == null) return service.getAllClients();
        return service.getAllClients(provincia);
    }
}
