package com.example.database.repository;

import com.example.database.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Integer> {

	 Clients findByLoginAndPassword(String login, String password);
	 Clients findByIdAndName(Integer id,String name);
	 Clients findOneByLogin(String login);
}
