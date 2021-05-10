package com.SpringChallange.springchallange.model;

import com.SpringChallange.springchallange.dto.ClientDTO;

import java.util.List;

public class ClientValidator {

    public static boolean validateSchema(ClientDTO client){
        return client.getFirstName() != null &&
                client.getLastName() != null &&
                client.getDirection() != null &&
                client.getDni() != null &&
                client.getProvincia() != null;
    }

    public static boolean clientAlreadyExist(ClientDTO client, List<ClientDTO> clients){
        return clients.contains(client) || containsDni(client, clients);
    }

    public static boolean isValidProvincia(String provincia, List<String> provincias){
        return containsString(provincias, provincia);
    }

    private static boolean containsString(List<String> provincias, String match){
        for(String provincia: provincias) {
            if(provincia.equalsIgnoreCase(match)) return true;
        }
        return false;
    }

    private static boolean containsDni(ClientDTO client, List<ClientDTO> clients){
        for(ClientDTO registeredClient: clients){
            if(registeredClient.getDni().equals(client.getDni())) return true;
        }
        return false;
    }
}
