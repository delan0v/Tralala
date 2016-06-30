package com.example.vaadin.calculejter;

/**
 * Created by Błażej on 30.06.2016.
 */
public class DegreeCalculator{
    double equals;
    public String CelciusToFahrenheit(String celcius) {
        try{
            equals = (Double.parseDouble(celcius) * 1.8) + 32;
            return String.valueOf(equals);
        }
        catch (Exception e){
            return("Ustawiłeś złe dane");
        }
    }
    public String FafrenheitToCelcius(String fahrenheit){
        try {
            equals = (Double.parseDouble(fahrenheit) - 32) / 1.8;
            return String.valueOf(equals);
        }
        catch(Exception e){
            return("Ustawiłeś złe dane");
        }
    }
}
