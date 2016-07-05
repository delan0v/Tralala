package com.example.vaadin.calculejter;

import com.example.vaadin.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * Created by Błażej on 21.06.2016.
 */
@SpringView(name = ViewNames.CELCIUSTOFAHRENHEIT_VIEV)
@Scope("prototype")
public class CelFahrCalcuator extends VerticalLayout implements View {
    Button out;
    Button obliczFahrenheity;
    Button obliczCelciusze;
    TextArea number;
    TextField equals;

    @Autowired
     DegreeCalculator calculate;

    CelFahrCalcuator(){
        setSpacing(true);
        setMargin(true);
        initCalculator();

    }

    private void initCalculator(){
        out=new Button("Cofnij");
        out.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                number.setValue("");
                equals.setValue("");
                getUI().getNavigator().navigateTo(ViewNames.MAINVIEW_VIEW);
            }
        });
        number=new TextArea("Podaj wartość");
        equals=new TextField("");
        obliczFahrenheity=new Button("Z Celciuszy na Fahrenheity");
        obliczCelciusze=new Button ("Z Fahrenheitów na Celciusze");
        obliczFahrenheity.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {

                equals.setValue(calculate.celciusToFahrenheit(number.getValue()));
            }
        }
        );
        obliczCelciusze.addClickListener(new Button.ClickListener()  {
            public void buttonClick(Button.ClickEvent event) {
                calculate=new DegreeCalculator();
                equals.setValue(calculate.fafrenheitToCelcius(number.getValue()));
            }
        });
        addComponent(out);
        addComponent(number);
        addComponent(obliczCelciusze);
        addComponent(obliczFahrenheity);
        addComponent(equals);
    }



    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Witaj w przeliczniku miar temperatury");
    }
}
