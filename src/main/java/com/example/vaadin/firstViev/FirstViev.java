package com.example.vaadin.firstViev;

import com.example.util.version.SystemVersion;
import com.vaadin.ui.*;
import org.springframework.context.annotation.Scope;
import com.example.vaadin.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import javax.annotation.PostConstruct;


@SpringView(name = ViewNames.MAINVIEW_VIEW)
@Scope("prototype")
public class FirstViev extends VerticalLayout implements View {

    private Button calculator;
    private Button offers;
    private Button clientFromDB;
    private Button clientAcc;
    private Button celciusFahrenheit;
    private TextField firstMenu;
    private TextField version;

    public FirstViev() {
        setMargin(true);
        setSpacing(true);
    }

    @PostConstruct
    private void initView() {

        version = new TextField();
        version.setValue("Wersja: "+SystemVersion.getSystemVersion());
        version.setWidth("120");
        version.setHeight("30");

        firstMenu = new TextField();
        firstMenu.setValue("Wybierz usługę:");
        firstMenu.setWidth("140");
        firstMenu.setHeight("30");
        firstMenu.addStyleName("mystle");// gówno się zmienia a nie styl styl

        clientAcc = new Button("Twoje konto");
        clientAcc.setWidth("200");
        clientAcc.setHeight("30");
        clientAcc.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.ACCOUNT);
            }
        });

        clientFromDB = new Button("Baza danych");
        clientFromDB.setWidth("200");
        clientFromDB.setHeight("30");
        clientFromDB.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.CLIENTS_VIEW);
            }
        });

        calculator = new Button("Kalkulator kredytowy");
        calculator.setWidth("200");
        calculator.setHeight("30");
        calculator.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.KALKULATOR_VIEW);
            }
        });

        offers = new Button("Oferty dla klienta");
        offers.setWidth("200");
        offers.setHeight("30");
        offers.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.OFERTY_VIEW);
            }
        });

        celciusFahrenheit = new Button("Temperatura");
        celciusFahrenheit.setWidth("200");
        celciusFahrenheit.setHeight("30");
        celciusFahrenheit.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.CELCIUSTOFAHRENHEIT_VIEV);
        }
        });

        addComponent(firstMenu);
        addComponent(clientAcc);
        addComponent(offers);
        addComponent(calculator);
        addComponent(clientFromDB);
        addComponent(celciusFahrenheit);
        addComponent(version);

        setComponentAlignment(firstMenu, Alignment.MIDDLE_CENTER);
        setComponentAlignment(clientAcc, Alignment.MIDDLE_CENTER);
        setComponentAlignment(offers, Alignment.MIDDLE_CENTER);
        setComponentAlignment(calculator, Alignment.MIDDLE_CENTER);
        setComponentAlignment(clientFromDB, Alignment.MIDDLE_CENTER);
        setComponentAlignment(celciusFahrenheit, Alignment.MIDDLE_CENTER);
        setComponentAlignment(celciusFahrenheit,Alignment.MIDDLE_CENTER);
        setComponentAlignment(version,Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Profesionalnie ojebiemy Cie z kasy");
    }
}
