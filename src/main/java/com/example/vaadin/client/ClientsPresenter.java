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
    public List<Clients> getAllClients(){
        List<Clients> clients = clientsService.getAllClients();
        return clients;
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

    }

    public void newClient(Clients clients, String name, String surname, String number, String login, String password){
        clients.setName(name);
        clients.setSurname(surname);
        clients.setNumber(number);
        clients.setLogin(login);
        clients.setPassword(password);
        clients.setBallance((float) 0);

    }

    public Clients search(String login,String password){
        return clientsService.searchClient(login,password);
    }
    public Clients searchByIdAndName(Integer Id,String name){
        return clientsService.searchThisClient(Id,name);
    }
}
