package com.example.vaadin.other.temperatureCalculator;

import com.example.util.DoubleEquals;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

/**
 * Created by Błażej on 30.06.2016.
 */
@Component
public class DegreeCalculator {

    public String celciusToFahrenheit(String celcius) {
        try {
            return DoubleEquals.convertFromDouble((Double.parseDouble(celcius) * 1.8) + 32);
        } catch (NumberFormatException e) {
            return ("Ustawiłeś złe dane");
        } catch (Exception e) {
            return ("Coś sie popsuło");
        }
    }
    public String fahrenheitToCelcius(String fahrenheit) {
        try {
            return DoubleEquals.convertFromDouble((Double.parseDouble(fahrenheit) - 32) / 1.8);
        } catch (NumberFormatException e) {
            return ("Ustawiłeś złe dane");
        } catch (Exception e) {
            return ("Coś się popsuło");
        }
    }
}
