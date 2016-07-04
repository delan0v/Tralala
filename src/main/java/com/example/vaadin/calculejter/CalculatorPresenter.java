package com.example.vaadin.calculejter;

/**
 * Created by Błażej on 01.07.2016.
 */
class BadValuesException extends Exception{
    public BadValuesException(){

    }
}
public class CalculatorPresenter{

    public double calculateCredit(String cashString, String monthString, String percentString) throws BadValuesException {
        double cash=Double.parseDouble(cashString);
        int month=Integer.parseInt(monthString);
        double percent=Double.parseDouble(percentString);
            if ((cash <= 0) || (1 > month) || (13 < month) || (percent < 0)) {
                throw new BadValuesException();
            }
            if (month==1) return cash + cash * percent / 100;

            cash += cash * percent / 100;
            month--;
            return calculateCredit(String.valueOf(cash), String.valueOf(month), String.valueOf(percent));

    }
}
