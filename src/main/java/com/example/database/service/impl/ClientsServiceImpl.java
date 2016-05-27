package com.example.database.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.model.Clients;
import com.example.database.repository.ClientsRepository;
import com.example.database.service.ClientsService;

@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    @Override
    public void addClient(Clients client) {
        clientsRepository.save(client);
    }

    @Override
    public void updateClient(Clients client) {
        Clients newClient = clientsRepository.getOne(client.getId());
        newClient.setName(client.getName());
        newClient.setSurname(client.getSurname());
        clientsRepository.save(newClient);
    }

    @Override
    public void removeClient(Clients client) {
        clientsRepository.delete(client);
    }

    @Override
    public List<Clients> getAllClients() {
        return clientsRepository.findAll();
    }
}
