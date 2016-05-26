package com.example.firstViev;

import com.example.PoczatkoweView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by pkaczmar on 2016-05-26.
 */
public class FirstViev extends VerticalLayout implements View {
    Button calculator;
    Button offers;
    TextField firstMenu;

    public FirstViev() {
        setMargin(true);
        setSpacing(true);
        initView();
    }

    private void initView() {
        firstMenu = new TextField("Witaj na stronie naszego banku\nWybier usługę:");
        calculator = new Button("Kalkulator kredytowy");
        calculator.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(PoczatkoweView.KALKULATOR);
            }
        });
        offers = new Button("Oferty dla klienta");
        offers.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(PoczatkoweView.OFERTY);
            }
        });

        addComponent(firstMenu);
        addComponent(calculator);
        addComponent(offers);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Profesionalnie ojebiemy Cie z kasy");
    }
}
