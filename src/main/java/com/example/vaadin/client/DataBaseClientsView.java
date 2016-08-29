package com.example.vaadin.client;

import com.example.vaadin.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
public class DataBaseClientsView extends VerticalLayout implements View {

    Grid grid = new Grid();
    Button out;
    @Autowired
    private ClientsPresenter clientsPresenter;

    public DataBaseClientsView() {

        setMargin(true);
        setSpacing(true);
    }
    @PostConstruct
    public void initViev(){

        out = new Button("Cofnij");
        out.setWidth("125");
        out.setHeight("30");
        out.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.MAINVIEW_VIEW);
            }
        });
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Witaj w bazie danych");
        grid.setContainerDataSource(clientsPresenter.getClientsContainer());
        addComponent(out);
        addComponent(grid);
        setComponentAlignment(out,Alignment.TOP_LEFT);
        setComponentAlignment(grid, Alignment.MIDDLE_CENTER);
    }

}
