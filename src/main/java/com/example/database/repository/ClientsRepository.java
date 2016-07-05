package com.example.database.repository;

import com.example.database.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//To jest zwykły interfejs :)
//Ale kurwysyn dużo potrafi. wystarczy go rozszerzyć o JpaRepository to ona dostarcza metod
// typowych dla bazy danych - wejdź w niego z lewym CTRL :)
public interface ClientsRepository extends JpaRepository<Clients, Integer> {

	 Clients findByLoginAndPassword(String login, String password);
	 Clients findByIdAndName(Integer id,String name);
	 Clients findById(Integer id);

}
