package com.example.tabelka;

import com.example.PoczatkoweView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by pkaczmar on 2016-05-26.
 */
public class TabelkaView extends VerticalLayout implements View {

    public TabelkaView() {
        setMargin(true);
        setSpacing(true);
        initView();
    }

    private void initView() {
        TextArea textArea = new TextArea("");
        TextArea textArea1 = new TextArea("sdaasd");
        Button button = new Button("Do innego widoku");

        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(PoczatkoweView.MAINVIEW);
            }
        });

        addComponent(textArea);
        addComponent(textArea1);
        addComponent(button);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("JESTEś w TabelkaView.java");
    }
}
