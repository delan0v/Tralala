package com.example.vaadin.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.database.model.Clients;
import com.example.database.service.ClientsService;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.spring.annotation.UIScope;

/**
 * Created by pkaczmar on 2016-05-27.
 */
@UIScope
@Component
public class ClientsPresenter {

    @Autowired
    private ClientsService clientsService;

    public BeanItemContainer<Clients> getClientsContainer() {
        List<Clients> clients = clientsService.getAllClients();
        return new BeanItemContainer<Clients>(Clients.class, clients);
    }
}
