package com.example.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.database.model.Clients;

//To jest zwykły interfejs :)
//Ale kurwysyn dużo potrafi. wystarczy go rozszerzyć o JpaRepository to ona dostarcza metod
// typowych dla bazy danych - wejdź w niego z lewym CTRL :)
public interface ClientsRepository extends JpaRepository<Clients, Integer> {
}
