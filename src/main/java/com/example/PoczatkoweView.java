package com.example;

import com.example.calculejter.CreditCalculator;
import com.example.firstViev.FirstViev;
import com.example.offers.ContoOfferts;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

/**
 * Created by Błażej on 23.05.2016.
 */
@Theme("valo")
@SpringUI
public class PoczatkoweView extends UI {
    public static final String KALKULATOR = "Kalkulator_kredytowy";
    public static final String MAINVIEW = "Menu_glowne";
    public static final String OFERTY = "Oferty";
    private Navigator navigator;


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        getPage().setTitle("JeBaDło Bank S.A.");
        navigator = new Navigator(this, this);
        navigator.addView(MAINVIEW, new FirstViev());
        navigator.addView(KALKULATOR, new CreditCalculator());
        navigator.addView(OFERTY, new ContoOfferts());
    }

}
