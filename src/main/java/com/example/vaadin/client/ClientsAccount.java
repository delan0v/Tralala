package com.example.vaadin.client;

import com.example.database.service.ClientsService;
import com.example.database.service.impl.ClientsServiceImpl;
import com.example.util.SessionUtil;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.example.database.model.Clients;
import com.example.vaadin.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Błażej on 03.06.2016.
 */
@SpringView(name = ViewNames.ACCOUNT)
@Scope("prototype")
public class ClientsAccount extends VerticalLayout implements View {
    private Button out;
    private Button newUser;
    private Button logNow;
    private NativeSelect login;
    private TextArea password;

    @Autowired
    private ClientsPresenter clientsPresenter ;

    public ClientsAccount() {
        setMargin(true);
        setSpacing(true);
        login = new NativeSelect("Wybierz użytkownika");
    }

    @PostConstruct
    private void initView() {
        out = new Button("Cofnij");
        newUser=new Button("Nowy użytkownik");
        logNow=new Button("Zaloguj");
        password = new TextArea("Wpisz swoje hasło");

        out.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                password.setValue("");
                getUI().getNavigator().navigateTo(ViewNames.MAINVIEW_VIEW);
            }
        });
        newUser.addClickListener(new Button.ClickListener(){
            @Override
            public void buttonClick(Button.ClickEvent event2){
                password.setValue("");
                getUI().getNavigator().navigateTo(ViewNames.NEW_ACCOUNT);
            }
        });
        logNow.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                Clients clients = clientsPresenter.search(String.valueOf(login.getValue()), password.getValue());
                if (clients == null) {
                    login.setValue("Popełniłeś błąd podczas logowania");
                } else {
                    SessionUtil.setLoggedUser(clients.getId(), clients.getName());
                    password.setValue("");
                    getUI().getNavigator().navigateTo(ViewNames.INDIVIDUAL_ACCOUNT);
                }
                }
        });
        addComponent(out);
        addComponent(login);
        addComponent(password);
        addComponent(logNow);
        addComponent(newUser);

    }

    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Zaloguj się na swoje konto bankowe");
        login.setNullSelectionAllowed(false);
        login.setImmediate(true);
        for(int i=1;;i++){
            if(clientsPresenter.searchById(i)==null) break;
            else login.addItem(clientsPresenter.searchById(i).getLogin());
        }
    }
}
