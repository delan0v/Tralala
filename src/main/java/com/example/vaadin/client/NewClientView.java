package com.example.vaadin.client;


import com.example.database.model.Clients;
import com.example.util.SessionUtil;
import com.example.vaadin.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.apache.catalina.manager.util.SessionUtils;
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
    private VerticalLayout verticalLayout;
    private SessionUtil sessionUtil;

    @Autowired
    private ClientsPresenter clientsPresenter;

    public NewClientView() {
        setMargin(true);
        setSpacing(true);
        setSizeFull();
    }

    @PostConstruct
    private void initView() {
        verticalLayout = new VerticalLayout();

        out = new Button("Cofnij");
        out.setWidth("125");
        out.setHeight("30");
        out.addClickListener(this);

        login = new TextArea("Podaj nowy login");
        login.setWidth("150");
        login.setHeight("30");

        password = new PasswordField("Podaj swoje hasło");
        password.setWidth("150");
        password.setHeight("30");

        name = new TextArea("Podaj imię");
        name.setWidth("150");
        name.setHeight("30");

        surname = new TextArea("Podaj nazwisko");
        surname.setWidth("150");
        surname.setHeight("30");

        number = new TextArea("Podaj numer telefonu");
        number.setWidth("150");
        number.setHeight("30");

        newUser = new Button("Załóż konto");
        newUser.setWidth("150");
        newUser.setHeight("30");
        newUser.addClickListener(this);

        addComponent(out);
        addComponent(verticalLayout);

        verticalLayout.addComponent(newUser);
        verticalLayout.addComponent(name);
        verticalLayout.addComponent(surname);
        verticalLayout.addComponent(number);
        verticalLayout.addComponent(login);
        verticalLayout.addComponent(password);

        setComponentAlignment(out,Alignment.TOP_LEFT);
        setComponentAlignment(verticalLayout,Alignment.MIDDLE_CENTER);

        verticalLayout.setComponentAlignment(name,Alignment.MIDDLE_CENTER);
        verticalLayout.setComponentAlignment(surname,Alignment.MIDDLE_CENTER);
        verticalLayout.setComponentAlignment(number,Alignment.MIDDLE_CENTER);
        verticalLayout.setComponentAlignment(login,Alignment.MIDDLE_CENTER);
        verticalLayout.setComponentAlignment(password,Alignment.MIDDLE_CENTER);
        verticalLayout.setComponentAlignment(newUser,Alignment.MIDDLE_CENTER);
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
                sessionUtil.setLoggedUser(clients.getId(),clients.getName());
                getUI().getNavigator().navigateTo(ViewNames.INDIVIDUAL_ACCOUNT);

            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
