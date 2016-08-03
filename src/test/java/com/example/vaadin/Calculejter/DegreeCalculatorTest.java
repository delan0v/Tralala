package com.example.vaadin.Calculejter;

import com.example.vaadin.calculejter.DegreeCalculator;
import com.example.vaadin.calculejter.exception.BadValuesException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Błażej on 03.08.2016.
 */
public class DegreeCalculatorTest {

    private static DegreeCalculator degreeCalculator = new DegreeCalculator();

    @Test
    public void temperatureCalculatorTest() throws BadValuesException {

        Assert.assertEquals("212,00",degreeCalculator.celciusToFahrenheit("100"));
        Assert.assertEquals("32,00",degreeCalculator.celciusToFahrenheit("0"));
        Assert.assertEquals("-148,00",degreeCalculator.celciusToFahrenheit("-100"));

        Assert.assertEquals("37,78",degreeCalculator.fahrenheitToCelcius("100"));
        Assert.assertEquals("-17,78",degreeCalculator.fahrenheitToCelcius("0"));
        Assert.assertEquals("-73,33",degreeCalculator.fahrenheitToCelcius("-100"));
    }
}
