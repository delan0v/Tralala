package com.example.vaadin.firstViev;

import com.example.vaadin.calculejter.CelFahrCalcuator;
import com.vaadin.ui.*;
import org.springframework.context.annotation.Scope;

import com.example.vaadin.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;

@SpringView(name = ViewNames.MAINVIEW_VIEW)
@Scope("prototype")
public class FirstViev extends VerticalLayout implements View {

    private Button calculator;
    private Button offers;
    private Button clientFromDB;
    private Button clientAcc;
    private Label firstMenu;
    private Button celciusFahrenheit;

    public FirstViev() {
        setMargin(true);
        setSpacing(true);
        initView();
    }

    private void initView() {
        firstMenu = new Label();
        calculator = new Button("Kalkulator kredytowy");
        clientFromDB = new Button("Baza danych");
        clientAcc = new Button("Twoje konto");
        clientAcc.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.ACCOUNT);
            }
        });
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
        celciusFahrenheit = new Button("Temperatura");
        celciusFahrenheit.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.CELCIUSTOFAHRENHEIT_VIEV);
        }
        });
        firstMenu.setValue("Witaj na stronie naszego banku\nWybierz usługę:");

        addComponent(firstMenu);
        addComponent(clientAcc);
        addComponent(offers);
        addComponent(calculator);
        addComponent(clientFromDB);
        addComponent(celciusFahrenheit);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Profesionalnie ojebiemy Cie z kasy");
    }
}
