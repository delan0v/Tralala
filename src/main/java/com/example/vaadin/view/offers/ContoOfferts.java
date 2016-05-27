package com.example.vaadin.view.offers;

import com.example.vaadin.view.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = ViewNames.OFERTY_VIEW)
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
                getUI().getNavigator().navigateTo(ViewNames.MAINVIEW_VIEW);
            }
        });
        addComponent(out);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Oto nasze najnowsze oferty");
    }
}
