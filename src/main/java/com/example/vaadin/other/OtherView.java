package com.example.vaadin.other;

import com.example.vaadin.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

/**
 * Created by Błażej on 08.08.2016.
 */
@SpringView(name = ViewNames.DIFFERENT_ACTION)
@Scope("prototype")
public class OtherView extends VerticalLayout implements View {

    private Button out;
    private Button temperatureCalculator;
    private HorizontalLayout horizontalLayout;

    public OtherView(){
        setMargin(true);
        setSpacing(true);
    }

    @PostConstruct
    private void InitView(){

        horizontalLayout = new HorizontalLayout();

        out = new Button("Cofnij");
        out.setWidth("125");
        out.setHeight("30");
        out.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.MAINVIEW_VIEW);
            }
        });

        temperatureCalculator = new Button("Kalkulator temperatur");
        temperatureCalculator.addClickListener(new Button.ClickListener(){
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.CELCIUSTOFAHRENHEIT_VIEV );
            }
        });

        addComponent(out);
        addComponent(horizontalLayout);
        horizontalLayout.addComponent(temperatureCalculator);

        setComponentAlignment(out, Alignment.TOP_LEFT);
        setComponentAlignment(horizontalLayout,Alignment.TOP_CENTER);
        horizontalLayout.setComponentAlignment(temperatureCalculator,Alignment.TOP_CENTER);
    }





    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
