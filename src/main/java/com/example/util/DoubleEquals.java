package com.example.util;

/**
 * Created by Błażej on 16.07.2016.
 */
public class  DoubleEquals {;

    public static String convertFromString(String numberString){
        double numberDouble=Double.parseDouble(numberString);
        numberDouble=numberDouble-(numberDouble%0.01);
        return String.valueOf(numberDouble);
    }
    public static double convertFromDouble(Double numberDouble){
         return numberDouble-(numberDouble%0.01);
    }
}
