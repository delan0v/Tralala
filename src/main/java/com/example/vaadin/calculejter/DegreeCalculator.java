package com.example.vaadin.calculejter;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

/**
 * Created by Błażej on 30.06.2016.
 */
@Component
public class DegreeCalculator {

    @NumberFormat(pattern = "###.##")
    private Double temperature;

    public String celciusToFahrenheit(String celcius) {
        try {
            temperature = (Double.parseDouble(celcius) * 1.8) + 32;
            return (String.valueOf(temperature));
        } catch (NumberFormatException e) {
            return ("Ustawiłeś złe dane");
        } catch (Exception e) {
            return ("Coś sie zjebało");
        }
    }
    public String fafrenheitToCelcius(String fahrenheit) {
        try {
            temperature = (Double.parseDouble(fahrenheit) - 32) / 1.8;
            return (String.valueOf(temperature));
        } catch (NumberFormatException e) {
            return ("Ustawiłeś złe dane");
        } catch (Exception e) {
            return ("Coś się zjebało");
        }
    }
}
