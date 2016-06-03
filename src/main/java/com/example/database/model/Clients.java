package com.example.database.model;

import javax.persistence.*;
import javax.print.attribute.IntegerSyntax;

//Adnotacja @Entity mówi Springowi że ta klasa jest częscią ORM czyli ma tę klasę mapować
// na tabelkę z bazy danych.
//Adnotacja @Table oznacza tabelkę w bazie danych: name = "nazwa tabelki w bazie"
@Entity
@Table(name = "CLIENTS")
public class Clients {

    // Id ponieważ w bazie danych oznaczyłem tę kolumne jako PRIVATE KEY czyli
    // klucz główny
    // Generated Value ponieważ dodałem sekwencję jako, że za każdym razem nowy
    // wiersz w tabeli
    // będzie mieć nową wartość większą o 1. :) Z automatu.
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Oznaczenie, jak ta kolumna w tej tabeli się nazywa ;)
    @Column(name = "name")
    private String name;

    @Column(name = "surename")
    private String surname;

    @Column(name="number")
    private Integer number;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private Integer password;

    @Column(name="ballance")
    private Integer ballance;

    //NIEZBĘDNE GETTERY i SETTERY oraz EQUALS HASHCODE i TOSTRING
    // Obowiązkowe pola każdego obiektu.
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Integer getBallance() {
        return ballance;
    }

    public void setBallance(Integer ballance) {
        this.ballance = ballance;
    }
    public Integer getNumber() {return number;}

    public void setNumber(Integer number) {this.number = number;}

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


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Clients clients = (Clients) o;

        if (id != null ? !id.equals(clients.id) : clients.id != null)
            return false;
        if (name != null ? !name.equals(clients.name) : clients.name != null)
            return false;
        if (number!=null ? !number.equals(clients.number) : clients.number!=null)
            return false;
        if (login!=null ? !login.equals(clients.login) : clients.login!=null)
            return false;
        if (password!=null ? !password.equals(clients.password) : clients.password!=null)
            return false;
        if (ballance!=null ? !ballance.equals(clients.ballance) : clients.ballance!=null)
            return false;
        return surname != null ? surname.equals(clients.surname) : clients.surname == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result +(number !=null ? number.hashCode():0);
        result = 31 * result +(login !=null ? login.hashCode():0);
        result = 31 * result +(password !=null ? password.hashCode():0);
        result = 31 * result +(ballance !=null ? ballance.hashCode():0);
        return result;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id="
                + id
                +
                ", name='"
                + name
                + '\''
                +
                ", surname='"
                + surname
                + '\''
                +
                ", number='"
                +number
                +'\''
                +
                ", login='"
                +login
                +'\''
                +
                ", password='"
                +password
                +'\''
                +
                ", ballance='"
                +ballance
                +'\''
                +
                '}';
    }
}
