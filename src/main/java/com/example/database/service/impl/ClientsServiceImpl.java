package com.example.database.service.impl;

import com.example.database.model.Clients;
import com.example.database.repository.ClientsRepository;
import com.example.database.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    @Override
    public void addClient(Clients clients) {
        clientsRepository.save(clients);
    }

    @Override
    public void updateClient(Clients clients) {
        Clients newClients = clientsRepository.getOne(clients.getId());
        newClients.setName(clients.getName());
        newClients.setSurname(clients.getSurname());
        newClients.setNumber(clients.getNumber());
        newClients.setLogin(clients.getLogin());
        newClients.setPassword(clients.getPassword());
        newClients.setBallance(clients.getBallance());
        newClients.setLastLogin(clients.getLastLogin());
        clientsRepository.save(newClients);
    }

    @Override
    public void removeClient(Clients clients) {
        clientsRepository.delete(clients);
    }

    @Override
    public List<Clients> getAllClients() {
        return clientsRepository.findAll();
    }

    @Override
    public Clients searchClient(String login, String password) {
        return clientsRepository.findByLoginAndPassword(login, password);
    }
    @Override
    public Clients searchThisClient(Integer id,String name)    {
        return clientsRepository.findByIdAndName(id,name);
    }
}

