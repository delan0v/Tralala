package com.example;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

/**
 * Created by Błażej on 23.05.2016.
 */
@Theme("valo")
@SpringUI
public class View extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setMargin(true);
        verticalLayout.setSpacing(true);

        TextField textField = new TextField("Podaj swoje imię:", ":)");
        Button button = new Button("Powiedz cześć ");
        button.addClickListener((Button.ClickListener) clickEvent -> {
            Notification.show("Cześć " + textField.getValue());
        });

        verticalLayout.addComponent(textField);
        verticalLayout.addComponent(button);

        setContent(verticalLayout);
    }
}
