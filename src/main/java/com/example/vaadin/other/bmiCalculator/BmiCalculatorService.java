package com.example.vaadin.other.bmiCalculator;

import com.example.util.DoubleEquals;


/**
 * Created by Błażej on 11.08.2016.
 */
public class BmiCalculatorService {

    double bmi;
    public String calculateBmi(String height, String weigth){
        try {
           bmi = (Double.parseDouble(weigth) / Math.pow(Double.parseDouble(height)/100.00,2));
            if(bmi<10){
                return "Lecisz sobie w kulki";
            } else if (10 <= bmi && bmi < 16.0) {
                return "Twoje BMI wynosi " + DoubleEquals.convertFromDouble(bmi) + ". Możesz włamać się do czołgu przez lufę";
            } else if (16.0 < bmi && bmi < 17.0) {
                return "Twoje BMI wynosi " + DoubleEquals.convertFromDouble(bmi) + ". Chorujesz na anoreksję!";
            } else if (17.0 < bmi && bmi < 18.5) {
                return "Twoje BMI wynosi " + DoubleEquals.convertFromDouble(bmi) + ". Masz niedowagę";
            } else if (18.5 <=bmi && bmi < 25.0) {
                return "Twoje BMI wynosi " + DoubleEquals.convertFromDouble(bmi) + ". Gratuluję, twoja waga jest prawidłowa";
            } else if (25.0 <= bmi && bmi < 30.0) {
                return "Twoje BMI wynosi " + DoubleEquals.convertFromDouble(bmi) + ". Masz nadwagę";
            } else if (30.0 <= bmi && bmi < 35.0) {
                return "Twoje BMI wynosi " + DoubleEquals.convertFromDouble(bmi) + ". Uważaj! Masz I stopień otyłości!";
            } else if (35.0 <= bmi && bmi < 40) {
                return "Twoje BMI wynosi " + DoubleEquals.convertFromDouble(bmi) + ". Przestań wpieprzać pączki!!";
            } else {
                return "Twoje BMI wynosi " + DoubleEquals.convertFromDouble(bmi) + ". Sytuacja jest krytyczna!!";
            }
        }
        catch(IllegalArgumentException e){
            return "Podałeś złe wartośći";
        }
        catch(Exception e){
            return "Coś się popsuło";
        }
    }
}
