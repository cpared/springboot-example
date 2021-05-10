package com.SpringChallange.springchallange.service;

import com.SpringChallange.springchallange.dto.ClientDTO;
import com.SpringChallange.springchallange.exception.ClientException;
import com.SpringChallange.springchallange.exception.InternalServerException;

import java.io.IOException;
import java.util.List;


public interface IClientService {
    void addClient(ClientDTO client) throws IOException, InternalServerException, ClientException;

    List<ClientDTO> getAllClients();
    List<ClientDTO> getAllClients(String provincia) throws ClientException;
}
