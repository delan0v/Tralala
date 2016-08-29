package com.example.database.model;

import javax.persistence.*;
import javax.print.attribute.IntegerSyntax;

/**
 * Adnotacja @Entity mówi Springowi że ta klasa jest częscią ORM czyli ma tę klasę mapować
 * na tabelkę z bazy danych.
 * Adnotacja @Table oznacza tabelkę w bazie danych: name = "nazwa tabelki w bazie"
 */
@Entity
@Table(name = "CLIENTS")
public class Clients {

/**
 * Id ponieważ w bazie danych oznaczyłem tę kolumne jako PRIVATE KEY czyli
 * klucz główny
 */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surename")
    private String surname;

    @Column(name = "number")
    private String number;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "ballance")
    private Double ballance;

    @Column(name="time")
    private String lastLogin;

    /**
    *  NIEZBĘDNE GETTERY i SETTERY oraz EQUALS HASHCODE i TOSTRING
    *  Obowiązkowe pola każdego obiektu.
    */
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBallance() {
        return ballance;
    }

    public void setBallance(Double ballance) {
        this.ballance = ballance;
    }
    public String getNumber() {return number;}

    public void setNumber(String number) {this.number = number;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }



    @Override
    public String toString() {
        return getLogin();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clients clients = (Clients) o;

        if (id != null ? !id.equals(clients.id) : clients.id != null) return false;
        if (name != null ? !name.equals(clients.name) : clients.name != null) return false;
        if (surname != null ? !surname.equals(clients.surname) : clients.surname != null) return false;
        if (number != null ? !number.equals(clients.number) : clients.number != null) return false;
        if (login != null ? !login.equals(clients.login) : clients.login != null) return false;
        if (password != null ? !password.equals(clients.password) : clients.password != null) return false;
        if (ballance != null ? !ballance.equals(clients.ballance) : clients.ballance != null) return false;
        return lastLogin != null ? lastLogin.equals(clients.lastLogin) : clients.lastLogin == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (ballance != null ? ballance.hashCode() : 0);
        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
        return result;
    }
}
