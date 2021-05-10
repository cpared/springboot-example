package com.SpringChallange.springchallange.repository;

import com.SpringChallange.springchallange.dto.ClientDTO;
import com.SpringChallange.springchallange.exception.InternalServerException;

import java.io.IOException;
import java.util.List;

public interface IClientRepository {

    void addClientToDataBase(ClientDTO client) throws InternalServerException, IOException;

    List<String> provincias();
    List<ClientDTO> clients();

    List<ClientDTO> getClientsByProvincia(String provincia);
}
