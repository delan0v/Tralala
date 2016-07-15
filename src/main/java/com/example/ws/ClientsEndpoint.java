package com.example.ws;

import com.example.database.repository.ClientsRepository;
import com.example.generated.GetClientsListRequest;
import com.example.generated.GetClientsListResponse;
import com.example.generated.GetClientsRequest;
import com.example.generated.GetClientsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
/**
 * Created by Błażej on 12.07.2016.
 */
    @Endpoint
    public class ClientsEndpoint {
        private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @Autowired
    ClientMapper mapper;
        private ClientsRepository clientsRepository;

        @Autowired
        public ClientsEndpoint(ClientsRepository clientsRepository) {
            this.clientsRepository = clientsRepository;
        }

        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClientsRequest")
        @ResponsePayload
        public GetClientsResponse getClient(@RequestPayload GetClientsRequest request) {
            GetClientsResponse response = new GetClientsResponse();
            response.setThisClient(mapper.map(clientsRepository.findOneByLogin(request.getLogin())));

            return response;
        }
        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClientsListRequest")
        @ResponsePayload
        public GetClientsListResponse getClientList(@RequestPayload GetClientsListRequest request) {
            GetClientsListResponse response = new GetClientsListResponse();
            response.setAllClientsList(mapper.map(clientsRepository.findAll()));

        return response;
    }
}

