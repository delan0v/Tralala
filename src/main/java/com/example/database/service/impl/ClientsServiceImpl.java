package com.example.database.service.impl;

import java.util.List;

import com.sun.deploy.util.SessionState;
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
        newClient.setNumber(client.getNumber());
        newClient.setLogin(client.getLogin());
        newClient.setPassword(client.getPassword());
        newClient.setBallance(client.getBallance());
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
    @Override
    public Integer searchClient(String login, String password) {
        for (int i = 1; i < getAllClients().size(); i++) {
            if ((clientsRepository.findOne(i).getLogin().equals(login)) &&
                    (clientsRepository.findOne(i).getPassword().equals(password)))
                    {
                return i;}

    }
        return -1;
    }

}

