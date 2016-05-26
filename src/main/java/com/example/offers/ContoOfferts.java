package com.example.offers;

import com.example.PoczatkoweView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Błażej on 27.05.2016.
 */
public class ContoOfferts extends VerticalLayout implements View {
    Button out;

    public ContoOfferts() {
        setSpacing(true);
        setMargin(true);
        initViev();
    }

    private void initViev() {
        out = new Button("Cofnij");
        out.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(PoczatkoweView.MAINVIEW);
            }
        });
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Oto nasze najnowsze oferty");
    }
}
