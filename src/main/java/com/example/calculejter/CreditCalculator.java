package com.example.calculejter;

import com.example.PoczatkoweView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

/**
 * Created by pkaczmar on 2016-05-26.
 */
public class CreditCalculator extends VerticalLayout implements View {
    Button out;
    TextArea textCash;
    TextArea textPercent;
    TextArea textTime;
    Button calculate;
    TextField textEquals;

    public CreditCalculator() {
        setMargin(true);
        setSpacing(true);
        initView();
    }

    private void initView() {
        out = new Button("Cofnij");
        out.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(PoczatkoweView.MAINVIEW);
            }
        });
        textCash = new TextArea("Podaj kwotę pożyczki");
        textPercent = new TextArea("Podaj procent");
        textTime = new TextArea("Podaj liczbę miesięcy");
        textEquals = new TextField("");
        calculate = new Button("Oblicz");
        addComponent(out);
        addComponent(textCash);
        addComponent(textTime);
        addComponent(textPercent);
        addComponent(calculate);
        addComponent(textEquals);
        calculate.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event2) {
                double money = calculateCredit(Double.parseDouble(textCash.getValue()), Integer.parseInt(textTime.getValue()), Double.parseDouble(textPercent.getValue()));
                textEquals.setValue(Double.toString(money));
            }
        });
    }

    public double calculateCredit(double cash, int month, double percent) {
        if (month > 0)
            return cash + cash * percent / 100;
        else {
            cash += cash * percent / 100;
            month--;
            return calculateCredit(cash, month, percent);
        }
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Witaj w kalkulatorze kredytowym");
    }
}
