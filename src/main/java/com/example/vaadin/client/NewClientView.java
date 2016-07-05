package com.example.vaadin.client;


import com.example.database.model.Clients;
import com.example.vaadin.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.NumberFormat;

import javax.annotation.PostConstruct;

/**
 * Created by Błażej on 03.06.2016.
 */
@SpringView(name = ViewNames.NEW_ACCOUNT)
@Scope("prototype")
public class NewClientView extends HorizontalLayout implements View, Button.ClickListener {

    private Button out;
    private Button newUser;
    private TextArea login;
    private PasswordField password;
    private TextArea name;
    private TextArea surname;
    private TextArea number;

    @Autowired
    @NumberFormat
    private ClientsPresenter clientsPresenter;

    public NewClientView() {
        setMargin(true);
        setSpacing(true);
    }

    @PostConstruct
    private void initView() {
        out = new Button("Cofnij");
        out.addClickListener(this);
        newUser = new Button("Załóż konto");
        newUser.addClickListener(this);
        login = new TextArea("Podaj nowy login");
        password = new PasswordField("Podaj swoje hasło");
        name = new TextArea("Podaj imię");
        surname = new TextArea("Podaj nazwisko");
        number = new TextArea("Podaj numer telefonu");
        addComponent(out);
        addComponent(name);
        addComponent(surname);
        addComponent(number);
        addComponent(login);
        addComponent(password);
        addComponent(newUser);

    }
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Wpisz swoje dane");

    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        if (event.getButton() == out) {
            getUI().getNavigator().navigateTo(ViewNames.ACCOUNT);
        } else if (event.getButton() == newUser) {
            try {

                Clients clients=new Clients();
                clientsPresenter.newClient(clients,name.getValue(),surname.getValue(),number.getValue(),login.getValue(),password.getValue());
                clientsPresenter.addNewClient(clients);

            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
