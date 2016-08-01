package com.example.vaadin.calculejter;

import com.example.vaadin.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

/**
 * Created by Błażej on 21.06.2016.
 */
@SpringView(name = ViewNames.CELCIUSTOFAHRENHEIT_VIEV)
@Scope("prototype")
public class CelFahrCalcuatorView extends VerticalLayout implements View {

    private Button out;
    private Button obliczFahrenheity;
    private Button obliczCelciusze;
    private TextField number;
    private TextField equals;
    private HorizontalLayout horizontalLayout;

    @Autowired
    DegreeCalculator calculate;

    CelFahrCalcuatorView(){
        setSpacing(true);
        setMargin(true);
    }

    @PostConstruct
    private void initCalculator(){
        horizontalLayout=new HorizontalLayout();

        out = new Button("Cofnij");
        out.setWidth("125");
        out.setHeight("30");
        out.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                number.setValue("");
                equals.setValue("");
                getUI().getNavigator().navigateTo(ViewNames.MAINVIEW_VIEW);
            }
        });

        number = new TextField("Podaj wartość");
        number.setWidth("125");
        number.setHeight("30");

        equals=new TextField("Wynik");
        equals.setWidth("125");
        equals.setHeight("30");

        obliczFahrenheity = new Button("Z Celciuszy na Fahrenheity");
        obliczFahrenheity.setWidth("250");
        obliczFahrenheity.setHeight("30");
        obliczFahrenheity.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {

                equals.setValue(calculate.celciusToFahrenheit(number.getValue()));
            }
        }
        );

        obliczCelciusze = new Button ("Z Fahrenheitów na Celciusze");
        obliczCelciusze.setWidth("250");
        obliczCelciusze.setHeight("30");
        obliczCelciusze.addClickListener(new Button.ClickListener()  {
            public void buttonClick(Button.ClickEvent event) {
                equals.setValue(calculate.fahrenheitToCelcius(number.getValue()));
            }
        });

        addComponent(out);
        addComponent(horizontalLayout);
        addComponent(obliczCelciusze);
        addComponent(obliczFahrenheity);

        horizontalLayout.addComponent(number);
        horizontalLayout.addComponent(equals);

        setComponentAlignment(out,Alignment.MIDDLE_LEFT);
        setComponentAlignment(horizontalLayout,Alignment.MIDDLE_CENTER);
        setComponentAlignment(obliczCelciusze,Alignment.MIDDLE_CENTER);
        setComponentAlignment(obliczFahrenheity,Alignment.MIDDLE_CENTER);

        horizontalLayout.setComponentAlignment(number,Alignment.MIDDLE_CENTER);
        horizontalLayout.setComponentAlignment(equals,Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Witaj w przeliczniku miar temperatury");
    }
}
