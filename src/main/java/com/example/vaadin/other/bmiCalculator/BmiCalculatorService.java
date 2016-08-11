package com.example.vaadin.other.bmiCalculator;

import com.example.util.DoubleEquals;


/**
 * Created by Błażej on 11.08.2016.
 */
public class BmiCalculatorService {

    public String calculateBmi(String weigth, String height){
        try {
            return DoubleEquals.convertFromDouble(Double.parseDouble(weigth) / Math.pow(Double.parseDouble(height)/100,2));
        }
        catch(IllegalArgumentException e){
            return "Podałeś złe wartośći";
        }
        catch(Exception e){
            return "Coś się popsuło";
        }
    }
}
