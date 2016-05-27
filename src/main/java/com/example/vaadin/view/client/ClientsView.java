package com.example.vaadin.view.client;

import com.example.vaadin.view.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = ViewNames.CLIENTS_VIEW)
public class ClientsView extends VerticalLayout implements View {

    public ClientsView() {
        setMargin(true);
        setSpacing(true);
        initView();
    }

    private void initView() {
        Grid grid = new Grid();

        addComponent(grid);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("JESTEś w ClientsView.java");
    }
}
