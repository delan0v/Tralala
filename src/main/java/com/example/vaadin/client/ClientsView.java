package com.example.vaadin.client;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
public class ClientsView extends VerticalLayout implements View {

    Grid grid = new Grid();
    @Autowired
    private ClientsPresenter clientsPresenter;

    public ClientsView() {
        setMargin(true);
        setSpacing(true);
    }



    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Witaj w bazie danych");
        grid.setContainerDataSource(clientsPresenter.getClientsContainer());
        addComponent(grid);
    }

}
