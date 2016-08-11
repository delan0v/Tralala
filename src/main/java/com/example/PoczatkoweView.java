package com.example;

import com.example.vaadin.other.bmiCalculator.BmiCalculatorView;
import com.example.vaadin.other.OtherView;
import com.example.vaadin.other.temperatureCalculator.CelFahrCalcuatorView;
import com.example.vaadin.client.ClientsAccount;
import com.example.vaadin.indyvidual.IndividualAccountView;
import com.example.vaadin.client.NewClientView;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.vaadin.ViewNames;
import com.example.vaadin.calculator.CreditCalculatorView;
import com.example.vaadin.client.DataBaseClientsView;
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
    private CreditCalculatorView creditCalculatorView;
    @Autowired
    private DataBaseClientsView clientsView;
    @Autowired
    private ContoOfferts contoOfferts;
    @Autowired
    private ClientsAccount clientsAccount;
    @Autowired
    private NewClientView newClientView;
    @Autowired
    private IndividualAccountView individualAccountView;
    @Autowired
    private CelFahrCalcuatorView celFahrCalc;
    @Autowired
    private OtherView otherView;
    @Autowired
    private BmiCalculatorView bmiCalculatorView;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        getPage().setTitle("Bank Rolski S.A.");

        navigator = new Navigator(this, this);
        navigator.addView(ViewNames.MAINVIEW_VIEW, firstViev);
        navigator.addView(ViewNames.KALKULATOR_VIEW, creditCalculatorView);
        navigator.addView(ViewNames.CLIENTS_VIEW, clientsView);
        navigator.addView(ViewNames.OFERTY_VIEW, contoOfferts);
        navigator.addView(ViewNames.ACCOUNT,clientsAccount);
        navigator.addView(ViewNames.NEW_ACCOUNT, newClientView);
        navigator.addView(ViewNames.INDIVIDUAL_ACCOUNT, individualAccountView);
        navigator.addView(ViewNames.CELCIUSTOFAHRENHEIT_VIEV, celFahrCalc);
        navigator.addView(ViewNames.DIFFERENT_ACTION,otherView);
        navigator.addView(ViewNames.BMI_CALCULATOR,bmiCalculatorView);

    }

}
