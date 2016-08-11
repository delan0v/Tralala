package com.example.vaadin.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import com.example.vaadin.ViewNames;
import com.example.util.exception.BadValuesException;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;

import javax.annotation.PostConstruct;

/**
 * Created by pkaczmar on 2016-05-26.
 */
@SpringView(name = ViewNames.KALKULATOR_VIEW)
@Scope("prototype")
public class CreditCalculatorView extends VerticalLayout implements View {

    private Button out;
    private TextField textCash;
    private TextField textPercent;
    private TextField textTime;
    private Button calculate;
    private TextField textEquals;
    private HorizontalLayout horizontalLayoutFirst;
    private HorizontalLayout horizontalLayoutSecond;

    @Autowired
    private CalculatorPresenter calculatorPresenter;

    public CreditCalculatorView() {
        setMargin(true);
        setSpacing(true);
    }

    @PostConstruct
    private void initView() {
        horizontalLayoutFirst = new HorizontalLayout();
        horizontalLayoutSecond = new HorizontalLayout();

        out = new Button("Cofnij");
        out.setWidth("125");
        out.setHeight("30");
        out.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.MAINVIEW_VIEW);
            }
        });


        textCash = new TextField("Podaj kwotę pożyczki");
        textCash.setWidth("150");
        textCash.setHeight("30");

        textPercent = new TextField("Podaj procent");
        textPercent.setWidth("150");
        textPercent.setHeight("30");

        textTime = new TextField("Podaj liczbę miesięcy");
        textTime.setWidth("150");
        textTime.setHeight("30");

        textEquals = new TextField();
        textEquals.setWidth("150");
        textEquals.setHeight("30");

        calculate = new Button("Oblicz");
        calculate.setWidth("300");
        calculate.setHeight("30");
        calculate.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event2) {
                try {
                    textEquals.setValue(calculatorPresenter.calculateCredit(textCash.getValue(), textTime.getValue(), textPercent.getValue()));
                } catch (BadValuesException e) {
                    textEquals.setValue("Podałeś złe wartości");
                }
            }
        });

        addComponent(out);
        addComponent(horizontalLayoutFirst);
        addComponent(horizontalLayoutSecond);

        horizontalLayoutFirst.addComponent(textCash);
        horizontalLayoutFirst.addComponent(textTime);
        horizontalLayoutFirst.addComponent(textPercent);
        horizontalLayoutSecond.addComponent(calculate);
        horizontalLayoutSecond.addComponent(textEquals);

        setComponentAlignment(out,Alignment.MIDDLE_LEFT);
        setComponentAlignment(horizontalLayoutFirst,Alignment.MIDDLE_CENTER);
        setComponentAlignment(horizontalLayoutSecond,Alignment.MIDDLE_CENTER);

        horizontalLayoutFirst.setComponentAlignment(textCash,Alignment.MIDDLE_CENTER);
        horizontalLayoutFirst.setComponentAlignment(textTime,Alignment.MIDDLE_CENTER);
        horizontalLayoutFirst.setComponentAlignment(textPercent,Alignment.MIDDLE_CENTER);

        horizontalLayoutSecond.setComponentAlignment(calculate,Alignment.MIDDLE_CENTER);
        horizontalLayoutSecond.setComponentAlignment(textEquals,Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Witaj w kalkulatorze kredytowym");
    }
}
