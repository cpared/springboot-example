package com.SpringChallange.springchallange.service;

import com.SpringChallange.springchallange.dto.ClientDTO;
import com.SpringChallange.springchallange.exception.ClientException;
import com.SpringChallange.springchallange.exception.InternalServerException;
import com.SpringChallange.springchallange.model.ClientValidator;
import com.SpringChallange.springchallange.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ClientService implements IClientService{

    @Autowired
    IClientRepository repository;

    @Override
    public void addClient(ClientDTO client) throws IOException, InternalServerException, ClientException {
        if(ClientValidator.clientAlreadyExist(client, this.repository.clients())){
            throw new ClientException("Client already exist");
        }
        if(!ClientValidator.isValidProvincia(client.getProvincia(), this.repository.provincias())){
            throw new ClientException("Invalid provincia");
        }
        repository.addClientToDataBase(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return this.repository.clients();
    }

    @Override
    public List<ClientDTO> getAllClients(String provincia) throws ClientException {
        if(!ClientValidator.isValidProvincia(provincia, this.repository.provincias())){
            throw new ClientException("Invalid provincia");
        }
        return this.repository.getClientsByProvincia(provincia);
    }
}
