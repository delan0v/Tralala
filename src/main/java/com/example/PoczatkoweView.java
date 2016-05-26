package com.example;

import com.example.person.OpisZalogowanejOsobyView;
import com.example.tabelka.TabelkaView;
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

    public static final String MAINVIEW = "opis";

    private Navigator navigator;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        getPage().setTitle("My navigation");

        navigator = new Navigator(this, this);

        navigator.addView("", new TabelkaView());
        navigator.addView(MAINVIEW, new OpisZalogowanejOsobyView());
    }

}
