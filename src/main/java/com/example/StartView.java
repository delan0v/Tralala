package com.example;

import com.vaadin.ui.Button;

/**
 * Created by Błażej on 25.05.2016.
 */
public class StartView extends View {

    Button button = new Button("Go to main View",
            new Button.ClickListener() {
                public void buttonClick(Button.ClickEvent event) {
                    navigator.navigateTo(MAINVIEW);
                }
            });

    public StartView() {
        setSizeFull();
    }

//jebac legie
}

