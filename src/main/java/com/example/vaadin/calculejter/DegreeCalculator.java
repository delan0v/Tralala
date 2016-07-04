package com.example.vaadin.calculejter;

import org.springframework.stereotype.Component;

/**
 * Created by Błażej on 30.06.2016.
 */

@Component
public class DegreeCalculator{


    public String celciusToFahrenheit(String celcius) {
        try{

            return String.format(String.valueOf((Double.parseDouble(celcius) * 1.8) + 32));
        }
        catch (NumberFormatException e){
            return("Ustawiłeś złe dane");
        }
        catch (Exception e){
            return ("Coś sie zjebało");
        }
    }

    public String fafrenheitToCelcius(String fahrenheit){
        try {

            return String.format(String.valueOf((Double.parseDouble(fahrenheit) - 32) / 1.8));
        }
        catch (NumberFormatException e){
            return("Ustawiłeś złe dane");
        }
        catch (Exception e){
            return ("Coś się zjebało");
        }
    }
}
