package com.example.vaadin.client;

import com.example.vaadin.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * Created by Błażej on 03.06.2016.
 */
@SpringView(name = ViewNames.ACCOUNT)
@Scope("prototype")
public class ClientsAccount extends VerticalLayout implements View {
    private Button out;
    private Button newUser;
    private Button logNow;
    private TextArea login;
    private TextArea password;
    private Integer ClientNumber;
    @Autowired
    private ClientsPresenter clientsPresenter;
    public ClientsAccount() {
        setMargin(true);
        setSpacing(true);
        initView();
    }

    private void initView() {
        out = new Button("Cofnij");
        newUser=new Button("Nowy użytkownik");
        logNow=new Button("Zaloguj");
        out.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.MAINVIEW_VIEW);
            }
        });
        newUser.addClickListener(new Button.ClickListener(){
            @Override
            public void buttonClick(Button.ClickEvent event2){
                getUI().getNavigator().navigateTo(ViewNames.NEW_ACCOUNT);
            }
        });
        logNow.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                // TODO to co tu jest powinno być metodą w prezenterze ! ! !
               ClientNumber =clientsPresenter.search(login.getValue(),password.getValue());
                if(ClientNumber==-1)login.setValue("Popełniłeś błąd podczas logowania");
                else getUI().getNavigator().navigateTo(ViewNames.INDIVIDUAL_ACCOUNT);
                }

        });
        login = new TextArea("Wpisz swój login");
        password = new TextArea("Wpisz swoje hasło");
        addComponent(out);
        addComponent(login);
        addComponent(password);
        addComponent(logNow);
        addComponent(newUser);
    }

    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Zaloguj się na swoje konto bankowe");


    }
}
