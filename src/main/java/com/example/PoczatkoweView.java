package com.example;

import com.example.vaadin.calculejter.CelFahrCalcuator;
import com.example.vaadin.client.ClientsAccount;
import com.example.vaadin.client.IndividualAccount;
import com.example.vaadin.client.NewClient;
import com.vaadin.navigator.View;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.vaadin.ViewNames;
import com.example.vaadin.calculejter.CreditCalculator;
import com.example.vaadin.client.ClientsView;
import com.example.vaadin.firstViev.FirstViev;
import com.example.vaadin.offers.ContoOfferts;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@Theme("valo")
@SpringUI
public class PoczatkoweView extends UI {

    Navigator navigator;
    @Autowired
    private FirstViev firstViev;
    @Autowired
    private CreditCalculator creditCalculator;
    @Autowired
    private ClientsView clientsView;
    @Autowired
    private ContoOfferts contoOfferts;
    @Autowired
    private ClientsAccount clientsAccount;
    @Autowired
    private NewClient newClient;
    @Autowired
    private IndividualAccount individualAccount;
    @Autowired
    private CelFahrCalcuator celFahrCalc;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        getPage().setTitle("JeBaDło Bank S.A.");

        navigator = new Navigator(this, this);
        navigator.addView(ViewNames.MAINVIEW_VIEW, firstViev);
        navigator.addView(ViewNames.KALKULATOR_VIEW, creditCalculator);
        navigator.addView(ViewNames.CLIENTS_VIEW, clientsView);
        navigator.addView(ViewNames.OFERTY_VIEW, contoOfferts);
        navigator.addView(ViewNames.ACCOUNT,clientsAccount);
        navigator.addView(ViewNames.NEW_ACCOUNT,newClient);
        navigator.addView(ViewNames.INDIVIDUAL_ACCOUNT, individualAccount);
        navigator.addView(ViewNames.CELCIUSTOFAHRENHEIT_VIEV, celFahrCalc);
    }

}
