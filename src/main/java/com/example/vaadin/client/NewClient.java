package com.example.vaadin.client;

import com.example.vaadin.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import org.springframework.context.annotation.Scope;

/**
 * Created by Błażej on 03.06.2016.
 */
@SpringView(name = ViewNames.NEW_ACCOUNT)
@Scope("prototype")
public class NewClient extends VerticalLayout implements View {
    Button out;
    Button newUser;
    TextArea login;
    TextArea password;
    TextArea name;
    TextArea surname;
    TextArea number;

    public NewClient() {
        setMargin(true);
        setSpacing(true);
        initView();
    }

    private void initView() {
        out = new Button("Cofnij");
        out.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.ACCOUNT);
            }
        });
        newUser = new Button("Załóż konto");
        newUser.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {

            }
        });
        login = new TextArea("Podaj nowy login");
        password = new TextArea("Podaj swoje hasło");
        name =new TextArea("Podaj imię");
        surname=new TextArea("Podaj nazwisko");
        number =new TextArea("Podaj numer telefonu");
        addComponent(out);
        addComponent(name);
        addComponent(surname);
        addComponent(number);
        addComponent(login);
        addComponent(password);
        addComponent(newUser);

    }

    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Wpisz swoje dane");

    }
}
