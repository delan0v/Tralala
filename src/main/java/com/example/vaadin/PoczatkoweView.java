package com.example;

import com.example.vaadin.view.ViewNames;
import com.example.vaadin.view.calculejter.CreditCalculator;
import com.example.vaadin.view.client.ClientsView;
import com.example.vaadin.view.firstViev.FirstViev;
import com.example.vaadin.view.offers.ContoOfferts;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@Theme("valo")
@SpringUI
public class PoczatkoweView extends UI {

    Navigator navigator;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        getPage().setTitle("JeBaDło Bank S.A.");

        navigator = new Navigator(this, this);
        navigator.addView(ViewNames.MAINVIEW_VIEW, new FirstViev());
        navigator.addView(ViewNames.KALKULATOR_VIEW, new CreditCalculator());
        navigator.addView(ViewNames.CLIENTS_VIEW, new ClientsView());
        navigator.addView(ViewNames.OFERTY_VIEW, new ContoOfferts());
    }

}
