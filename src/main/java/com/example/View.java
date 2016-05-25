package com.example;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Błażej on 23.05.2016.
 */
@Theme("valo")
@SpringUI
public class View extends UI {
    protected static final String MAINVIEW = "main";
    Navigator navigator;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout verticalLayout = new VerticalLayout();
        MenuBar menuBar = new MenuBar();
        verticalLayout.addComponent(menuBar);
        MenuBar.MenuItem firstPage = menuBar.addItem("First page", null);
        MenuBar.MenuItem secondPage = menuBar.addItem("Second page", null);

        setContent(verticalLayout);

        getPage().setTitle("My navigation");
        navigator = new Navigator(this, this);
        // navigator.addView("",new StartView());
        // navigator.addView(MAINVIEW,new MainView());
    }

}
