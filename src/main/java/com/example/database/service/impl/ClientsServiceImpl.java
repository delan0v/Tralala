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

    // TODO zła implementacja ;) Wykorzystaj QueryMethdos - wpisz w google : QueryMethods Spring JPA examples
    // poza tym zobacz co tu robisz : 1. szukasz wszystkich clientów : no spoko - masz ich :) Fajnie :)
    // 2. iterujesz po każdym kliencie i dla każdego klienta szukasz kolejnego klienta : czyli jak masz clienta np.
    // z id 1 to znów go szukasz w bazie :) bez sensu.... :D a jak go znajdziesz to znów szukasz dla klienta którego masz
    // w bazie danych tego samego klienta... i sprawdzasz mu hasło...
    // TODO złe formatowanie klamerka : { powinna być na końcu linijki zawsze ! <3
    @Override
    public Clients searchClient(String login, String password) {
        return clientsRepository.findByLoginAndPassword(login, password);
    }

}

