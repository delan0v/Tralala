package com.example.vaadin.other.bmiCalculator;

import com.example.util.DoubleEquals;


/**
 * Created by Błażej on 11.08.2016.
 */
public class BmiCalculatorService {

    public String calculateBmi(String height, String weigth){
        try {
            return DoubleEquals.convertFromDouble(Double.parseDouble(weigth) / Math.pow(Double.parseDouble(height),2.0));
        }
        catch(IllegalArgumentException e){
            return "Podałeś złe wartośći";
        }
        catch(Exception e){
            return "Coś się popsuło";
        }
    }
}
