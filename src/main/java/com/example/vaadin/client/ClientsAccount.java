package com.example.vaadin.client;

import com.example.database.model.Clients;
import com.example.util.SessionUtil;
import com.example.vaadin.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
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
    private NativeSelect loginNativeSelect;
    private TextArea password;

    @Autowired
    private ClientsPresenter clientsPresenter ;

    public ClientsAccount() {
        setMargin(true);
        setSpacing(true);
        loginNativeSelect = new NativeSelect("Wybierz użytkownika");
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
                Clients clients = (Clients) loginNativeSelect.getValue();
                if (clients == null) {
                    loginNativeSelect.setValue("Popełniłeś błąd podczas logowania");
                } else {
                    if (password.getValue().equals(clients.getPassword())) {
                        SessionUtil.setLoggedUser(clients.getId(), clients.getName());
                        getUI().getNavigator().navigateTo(ViewNames.INDIVIDUAL_ACCOUNT);
                    }
                }
            }
        });
        addComponent(out);
        addComponent(loginNativeSelect);
        addComponent(password);
        addComponent(logNow);
        addComponent(newUser);

    }

    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Zaloguj się na swoje konto bankowe");
        loginNativeSelect.setNullSelectionAllowed(false);
        loginNativeSelect.setImmediate(true);
        // for (int i = 1; i < 100; i++) {
        // if (clientsPresenter.searchById(i) != null) {
        // loginNativeSelect.addItem(clientsPresenter.searchById(i).getLogin());
        // }
        // }
        List<Clients> clientsList = clientsPresenter.getAllClients();
        loginNativeSelect.addItems(clientsList);
    }
}
