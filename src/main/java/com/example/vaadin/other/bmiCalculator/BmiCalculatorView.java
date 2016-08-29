package com.example.vaadin.other.bmiCalculator;

import com.example.vaadin.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

/**
 * Created by Błażej on 11.08.2016.
 */
@SpringView(name = ViewNames.BMI_CALCULATOR)
@Scope("prototype")
public class BmiCalculatorView extends VerticalLayout implements View {

    private TextField weight;
    private TextField heigth;
    private TextField equals;
    private Button out;
    private Button calculate;

    public BmiCalculatorView(){
        setMargin(true);
        setSpacing(true);
    }

    @PostConstruct
    private void initView(){

        BmiCalculatorService bmiCalculatorService = new BmiCalculatorService();
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        out = new Button("Cofnij");
        out.setWidth("125");
        out.setHeight("30");
        out.addClickListener((event -> {getUI().getNavigator().navigateTo(ViewNames.DIFFERENT_ACTION);}));

        weight = new TextField("Podaj swoją wysokość");
        weight.setHeight("30");
        weight.setWidth("200");

        heigth = new TextField("Podaj swoją wagę");
        heigth.setHeight("30");
        heigth.setWidth("200");

        equals = new TextField("Wynik");
        equals.setHeight("30");
        equals.setWidth("400");

        calculate = new Button("Oblicz");
        calculate.setHeight("30");
        calculate.setWidth("400");
        calculate.addClickListener((event -> {equals.setValue(bmiCalculatorService.calculateBmi(weight.getValue(),heigth.getValue()));
        }));

        addComponent(out);
        addComponent(horizontalLayout);
        addComponent(equals);
        addComponent(calculate);
        horizontalLayout.addComponent(weight);
        horizontalLayout.addComponent(heigth);

        setComponentAlignment(out,Alignment.TOP_LEFT);
        setComponentAlignment(horizontalLayout,Alignment.MIDDLE_CENTER);
        setComponentAlignment(equals,Alignment.MIDDLE_CENTER);
        setComponentAlignment(calculate,Alignment.MIDDLE_CENTER);

        horizontalLayout.setComponentAlignment(weight,Alignment.MIDDLE_CENTER);
        horizontalLayout.setComponentAlignment(heigth,Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        Notification.show("Witaj w kalkulatorze BMI");
    }
}
