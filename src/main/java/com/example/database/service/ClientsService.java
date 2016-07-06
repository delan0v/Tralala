package com.example.database.service;

import com.example.database.model.Clients;

import java.util.List;

/**
 * Created by pkaczmar on 2016-05-27.
 */
public interface ClientsService {

    void addClient(Clients clients);

    void updateClient(Clients clients);

    void removeClient(Clients clients);

    Clients searchClient(String login, String password);

    Clients searchThisClient(Integer id,String name) ;

    List<Clients> getAllClients();
}
