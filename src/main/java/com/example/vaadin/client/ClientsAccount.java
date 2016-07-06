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
public class ClientsAccount extends HorizontalLayout implements View {

    private Button out;
    private Button newUser;
    private Button logNow;
    private NativeSelect loginNativeSelect;
    private PasswordField password;
    private VerticalLayout verticalLayout;

    @Autowired
    private ClientsPresenter clientsPresenter ;

    public ClientsAccount() {
        setMargin(true);
        setSpacing(true);
        setSizeFull();
    }

    @PostConstruct
    private void initView() {
        verticalLayout= new VerticalLayout();

        out = new Button("Cofnij");
        out.setWidth("125");
        out.setHeight("30");
        out.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                password.setValue("");
                getUI().getNavigator().navigateTo(ViewNames.MAINVIEW_VIEW);
            }
        });

        newUser = new Button("Nowy użytkownik");
        newUser.setWidth("175");
        newUser.setHeight("30");
        newUser.addClickListener(new Button.ClickListener(){
            @Override
            public void buttonClick(Button.ClickEvent event2){
                password.setValue("");
                getUI().getNavigator().navigateTo(ViewNames.NEW_ACCOUNT);
            }
        });

        loginNativeSelect = new NativeSelect("Wybierz użytkownika");
        loginNativeSelect.setWidth("200");
        loginNativeSelect.setHeight("40");

        password = new PasswordField("Wpisz swoje hasło");
        password.setWidth("200");
        password.setHeight("30");

        logNow = new Button("Zaloguj");
        logNow.setWidth("200");
        logNow.setHeight("30");
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
        addComponent(verticalLayout);
        addComponent(newUser);

        verticalLayout.addComponent(loginNativeSelect);
        verticalLayout.addComponent(password);
        verticalLayout.addComponent(logNow);

        verticalLayout.addComponent(loginNativeSelect);
        verticalLayout.addComponent(password);
        verticalLayout.addComponent(logNow);

        setComponentAlignment(out,Alignment.TOP_LEFT);
        setComponentAlignment(verticalLayout,Alignment.MIDDLE_CENTER);
        setComponentAlignment(newUser,Alignment.TOP_RIGHT);

        verticalLayout.setComponentAlignment(loginNativeSelect,Alignment.MIDDLE_CENTER);
        verticalLayout.setComponentAlignment(password,Alignment.MIDDLE_CENTER);
        verticalLayout.setComponentAlignment(logNow,Alignment.MIDDLE_CENTER);
    }

    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Zaloguj się na swoje konto bankowe");
        loginNativeSelect.setNullSelectionAllowed(false);
        loginNativeSelect.setImmediate(true);
        List<Clients> clientsList = clientsPresenter.getAllClients();
        loginNativeSelect.addItems(clientsList);
    }
}
