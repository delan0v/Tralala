package com.example.database.service;

import java.util.List;

import com.example.database.model.Clients;

/**
 * Created by pkaczmar on 2016-05-27.
 */
public interface ClientsService {

    void addClient(Clients client);

    void updateClient(Clients client);

    void removeClient(Clients client);

    public Integer searchClient(String surname, String password);

    List<Clients> getAllClients();

}
