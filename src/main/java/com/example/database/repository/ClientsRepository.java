package com.example.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.database.model.Clients;

//To jest zwykły interfejs :)
//Ale kurwysyn dużo potrafi. wystarczy go rozszerzyć o JpaRepository to ona dostarcza metod
// typowych dla bazy danych - wejdź w niego z lewym CTRL :)
@Repository
public interface ClientsRepository extends JpaRepository<Clients, Integer> {
}
