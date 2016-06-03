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
@SpringView(name = ViewNames.ACCOUNT)
@Scope("prototype")
public class ClientsAccount extends VerticalLayout implements View {
    Button out;
    Button newUser;
    Button logNow;
    TextArea login;
    TextArea password;

    public ClientsAccount() {
        setMargin(true);
        setSpacing(true);
        initView();
    }

    private void initView() {
        out = new Button("Cofnij");
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
        login = new TextArea("");
        password = new TextArea("");
        addComponent(out);
        addComponent(login);
        addComponent(password);

        addComponent(newUser);
    }

    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Zaloguj się na swoje konto bankowe");


    }
}
