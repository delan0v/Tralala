package com.example.vaadin.firstViev;

import org.springframework.context.annotation.Scope;

import com.example.vaadin.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = ViewNames.MAINVIEW_VIEW)
@Scope("prototype")
public class FirstViev extends VerticalLayout implements View {

    private Button calculator;
    private Button offers;
    private Button clientFromDB;
    private TextField firstMenu;

    public FirstViev() {
        setMargin(true);
        setSpacing(true);
        initView();
    }

    private void initView() {
        firstMenu = new TextField("Witaj na stronie naszego banku\nWybier usługę:");
        calculator = new Button("Kalkulator kredytowy");
        clientFromDB = new Button("Pokaż wiersze z bazy danych <3 ");
        clientFromDB.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.CLIENTS_VIEW);
            }
        });
        calculator.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.KALKULATOR_VIEW);
            }
        });
        offers = new Button("Oferty dla klienta");
        offers.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.OFERTY_VIEW);
            }
        });

        addComponent(firstMenu);
        addComponent(calculator);
        addComponent(offers);
        addComponent(clientFromDB);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Profesionalnie ojebiemy Cie z kasy");
    }
}
