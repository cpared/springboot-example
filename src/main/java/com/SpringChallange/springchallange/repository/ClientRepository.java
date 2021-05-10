package com.SpringChallange.springchallange.repository;

import com.SpringChallange.springchallange.dto.ClientDTO;
import com.SpringChallange.springchallange.exception.InternalServerException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Repository
public class ClientRepository implements IClientRepository{

    //TODO -> Refactor
    private final static String FILEPATH = "classpath:clients.json";
    private final static String CLIENTPATH = "./src/main/resources/clients.json";
    private final static String PROVINCIAPATH = "./src/main/resources/provincia.txt";
    private List<ClientDTO> clients = new ArrayList<>();
    private List<String> provincias = new ArrayList<>();

    public ClientRepository() throws InternalServerException {
        loadProvincias();
        loadDataBase();
    }

    @Override
    public void addClientToDataBase(ClientDTO client) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            this.clients.add(client);

            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            FileWriter file = new FileWriter(CLIENTPATH);
            writer.writeValue(file, this.clients);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<String> provincias() {
        return this.provincias;
    }

    @Override
    public List<ClientDTO> clients() {
        return this.clients;
    }

    @Override
    public List<ClientDTO> getClientsByProvincia(String provincia) {
        List<ClientDTO> clientsByProvincia = new ArrayList<>();
        for(ClientDTO client: this.clients){
            if(client.getProvincia().equalsIgnoreCase(provincia)) clientsByProvincia.add(client);
        }
        return clientsByProvincia;
    }

    private void loadDataBase() throws InternalServerException {
        try {
            ObjectMapper mapper = new ObjectMapper();

            if(ResourceUtils.getFile(FILEPATH).length() == 0) return;
            this.clients = mapper.readValue(ResourceUtils.getFile(FILEPATH), new TypeReference<>() {});

        } catch (Exception ex){
            ex.printStackTrace();
            throw new InternalServerException("File Error");
        }
    }

    private void loadProvincias() throws InternalServerException {
        try {

            File myObj = new File(PROVINCIAPATH);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                this.provincias.add(data);
            }
            myReader.close();

        } catch (Exception ex){
            ex.printStackTrace();
            throw new InternalServerException("File Error");
        }
    }
}
