package com.example.vaadin.calculejter;

import com.example.vaadin.calculejter.exception.BadValuesException;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

/**
 * Created by Błażej on 01.07.2016.
 */
@Component
public class CalculatorPresenter {

    public Double calculateCredit(String cashString, String monthString, String percentString) throws BadValuesException {
        Double cash = Double.parseDouble(cashString);
        int month = Integer.parseInt(monthString);
        Double percent = Double.parseDouble(percentString);
        if ((cash <= 0) || (1 > month) || (13 < month) || (percent < 0)) {
            throw new BadValuesException();
        }
        if (month == 1){
            return cash + cash * percent / 100;

        }

        cash += cash * percent / 100;
        month--;
        return calculateCredit(String.valueOf(cash), String.valueOf(month), String.valueOf(percent));

    }
}
