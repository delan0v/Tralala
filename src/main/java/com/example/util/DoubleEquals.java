package com.example.util;

import java.text.DecimalFormat;

/**
 * Created by Błażej on 16.07.2016.
 */
public class  DoubleEquals {
    /**
     * Metody oddające format dwóch liczb po przecinku
     */
    public static DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public static String convertFromString(String numberString){

        return convertFromDouble(Double.parseDouble(numberString));
    }
    public static String convertFromDouble(Double numberDouble){
        return decimalFormat.format(numberDouble);
    }
}
