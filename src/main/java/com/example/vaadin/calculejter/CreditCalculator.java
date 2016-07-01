package com.example.vaadin.calculejter;

import org.springframework.context.annotation.Scope;

import com.example.vaadin.ViewNames;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;

/**
 * Created by pkaczmar on 2016-05-26.
 */
@SpringView(name = ViewNames.KALKULATOR_VIEW)
@Scope("prototype")
public class CreditCalculator extends VerticalLayout implements View {

    // TODO dostęp private :)
    Button out;
    TextArea textCash;
    TextArea textPercent;
    TextArea textTime;
    Button calculate;
    TextField textEquals;

    public CreditCalculator() {
        setMargin(true);
        setSpacing(true);
        initView();
    }

    private void initView() {
        out = new Button("Cofnij");
        out.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getUI().getNavigator().navigateTo(ViewNames.MAINVIEW_VIEW);
            }
        });
        textCash = new TextArea("Podaj kwotę pożyczki");
        textPercent = new TextArea("Podaj procent");
        textTime = new TextArea("Podaj liczbę miesięcy");
        textEquals = new TextField("");
        calculate = new Button("Oblicz");
        calculate.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event2) {
                //TODO parsowanie na double tak jak w kalkulatorze stopni celsjusza - do metody :) Tu się robi bałagan :)
                double money = calculateCredit(Double.parseDouble(textCash.getValue()), Integer.parseInt(textTime.getValue()), Double.parseDouble(textPercent.getValue()));
                if (money!=-1)
                    textEquals.setValue(Double.toString(money));
                else
                    textEquals.setValue("Podałeś złe wartości");
            }
        });
        addComponent(out);
        addComponent(textCash);
        addComponent(textTime);
        addComponent(textPercent);
        addComponent(calculate);
        addComponent(textEquals);
    }

    //TODO stworzyć klasę prezentera i tam wkleić tę metodę :)
    public double calculateCredit(double cash, int month, double percent) {

        // TODO po każdym znaku spacja      if( (cash <= 0) || ... itd.
        if((cash<=0)||(0>month)||(13<month)||(percent<0)){
            // TODO - może lepiej rzucić wyjątkiem np. BadValuesException który stworzysz a w messege wpiszesz powód :)
            return -1;
        }
        // TODO może tak chciałeś ale co z miesiącem 0 ? jest jakiś specjalny ? :D
        // TODO ten else nie jest potrzebny - jak wejdzie w pierwszego if'a to masz return i wyjdzie z metody :)
        else if (month > 1) {
            cash += cash * percent / 100;
            month--;
            return calculateCredit(cash, month, percent);
        }

        // TODO niepotrzebny else    jak wyżej
        else return cash + cash * percent / 100;

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Witaj w kalkulatorze kredytowym");
    }
}
