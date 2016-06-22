package com.example.vaadin.calculejter;

import com.example.vaadin.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.context.annotation.Scope;

/**
 * Created by Błażej on 21.06.2016.
 */
@SpringView(name = ViewNames.CELCIUSTOFAHRENHEIT_VIEV)
@Scope("prototype")
public class CelFahrCalcuator extends VerticalLayout implements View {
    Button out;
    Button oblicz;
    TextArea celcius;
    TextArea fahrenheit;
    TextField equals;

    CelFahrCalcuator(){
        setSpacing(true);
        setMargin(true);
        initCalculator();

    }

    private void initCalculator(){
        out=new Button("Cofnij");
        out.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.MAINVIEW_VIEW);
            }
        });
        celcius=new TextArea("Podaj stopnie Celciusa");
        fahrenheit=new TextArea("Podaj stopnie Fahrenheita");
        equals=new TextField("");
        oblicz.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                if ((celcius.getValue().equals(""))&&((fahrenheit.getValue().equals("")))) equals.setValue("Ustaw wartości!");
                else if (celcius.getValue().equals("")) {
                    equals.setValue(String.valueOf(5/9*(Double.parseDouble(fahrenheit.getValue())-32)));
                    celcius.setValue("");
                    fahrenheit.setValue("");
                }
                else if (celcius.getValue().equals("")){
                    equals.setValue(String.valueOf(9/5*(Double.parseDouble(fahrenheit.getValue())+32)));
                    celcius.setValue("");
                    fahrenheit.setValue("");
                }
            }
        });
        addComponent(out);
        addComponent(celcius);
        addComponent(fahrenheit);
        addComponent(oblicz);
        addComponent(equals);
    }



    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Witaj w przeliczniku miar temperatury");
    }
}
