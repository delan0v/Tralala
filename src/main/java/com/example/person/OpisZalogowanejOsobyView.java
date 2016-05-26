package com.example.person;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by pkaczmar on 2016-05-26.
 */
public class OpisZalogowanejOsobyView extends VerticalLayout implements View {

    public OpisZalogowanejOsobyView() {
        setMargin(true);
        setSpacing(true);
        initView();
    }

    private void initView() {
        Button textArea = new Button("jsdajdsajksdajkl");
        Button textArea1 = new Button("sdaasd");

        addComponent(textArea);
        addComponent(textArea1);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("JESTEś w OpisZalogowanejOsobyView.java");
    }
}
