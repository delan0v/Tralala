package com.example.vaadin.calculejter;

import org.springframework.context.annotation.Scope;

import com.example.vaadin.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;

/**
 * Created by pkaczmar on 2016-05-26.
 */
@SpringView(name = ViewNames.KALKULATOR_VIEW)
@Scope("prototype")
public class CreditCalculator extends VerticalLayout implements View {

    private Button out;
    private TextArea textCash;
    private TextArea textPercent;
    private TextArea textTime;
    private Button calculate;
    private TextField textEquals;
    private CalculatorPresenter calculatorPresenter;

    public CreditCalculator() {
        setMargin(true);
        setSpacing(true);
        initView();
    }

    private void initView() {
        calculatorPresenter=new CalculatorPresenter();
        out = new Button("Cofnij");
        out.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.MAINVIEW_VIEW);
            }
        });
        textCash = new TextArea("Podaj kwotę pożyczki");
        textPercent = new TextArea("Podaj procent");
        textTime = new TextArea("Podaj liczbę miesięcy");
        textEquals = new TextField("");
        calculate = new Button("Oblicz");
        calculate.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event2) {
                double money=0;
                try {
                    money = calculatorPresenter.calculateCredit(textCash.getValue(), textTime.getValue(), textPercent.getValue());
                }
                catch(BadValuesException e){
                    textEquals.setValue("Podałeś złe wartości");
                }
                    textEquals.setValue(Double.toString(money));

            }
        });
        addComponent(out);
        addComponent(textCash);
        addComponent(textTime);
        addComponent(textPercent);
        addComponent(calculate);
        addComponent(textEquals);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Witaj w kalkulatorze kredytowym");
    }
}
