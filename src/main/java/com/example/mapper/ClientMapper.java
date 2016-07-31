//package com.example.mapper;
//
//import com.example.database.model.Clients;
//import com.example.generated.ClientBO;
//import com.example.generated.ClientListBO;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by pkaczmar on 2016-07-09.
// */
//@Component
//public class ClientMapper {
//
//	public ClientListBO map(List<Clients> clientList) {
//		List<ClientBO> clientBOList = new ArrayList<>();
//		for (Clients client: clientList) {
//			clientBOList.add(map(client));
//		}
//		ClientListBO clientListBO = new ClientListBO();
//		clientListBO.getClientListBO().addAll(clientBOList);
//
//		return clientListBO;
//	}
//
//	public ClientBO map(Clients client) {
//		ClientBO clientBO = new ClientBO();
//		clientBO.setId(client.getId());
//		clientBO.setBallance(client.getBallance());
//		clientBO.setLogin(client.getLogin());
//		clientBO.setName(client.getName());
//		clientBO.setNumber(client.getNumber());
//		clientBO.setSurname(client.getSurname());
//
//		return clientBO;
//	}
//}
