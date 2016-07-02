package com.example.vaadin.client;

import com.example.database.model.Clients;
import com.example.database.service.ClientsService;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by pkaczmar on 2016-05-27.
 */
@UIScope
@Component
public class ClientsPresenter {

    @Autowired
    private ClientsService clientsService;

    public BeanItemContainer<Clients> getClientsContainer() {
        List<Clients> clientses = clientsService.getAllClients();
        return new BeanItemContainer<Clients>(Clients.class, clientses);
    }

    public void addNewClient(Clients clients) {
        try{
            clientsService.addClient(clients);
            Notification.show("Konto zostało założone");
        }
        catch(Exception e){
            e.printStackTrace();
            Notification.show("Wyjebało wszystko", Notification.Type.ERROR_MESSAGE);
        }
        // TODO za duże odstępy


    }
    public Clients search(String login,String password){
        return clientsService.searchClient(login,password);}
}
