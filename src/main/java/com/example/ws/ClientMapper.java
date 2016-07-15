package com.example.ws;

import com.example.database.model.Clients;
import com.example.generated.Client;
import com.example.generated.ClientsList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Błażej on 12.07.2016.
 */
@Component
public class ClientMapper {

    public ClientsList map(List<Clients> clientList) {
        List<Client> clientBOList = new ArrayList<>();
        for (Clients client: clientList) {
            clientBOList.add(map(client));
        }
        ClientsList clientListBO = new ClientsList();
        clientListBO.getClientList().addAll(clientBOList);

        return clientListBO;
    }

    public Client map(Clients client) {
        Client clientBO = new Client();
        clientBO.setId(client.getId());
        clientBO.setBallance(client.getBallance());
        clientBO.setLogin(client.getLogin());
        clientBO.setName(client.getName());
        clientBO.setNumber(client.getNumber());
        clientBO.setSurname(client.getSurname());

        return clientBO;
    }
}
