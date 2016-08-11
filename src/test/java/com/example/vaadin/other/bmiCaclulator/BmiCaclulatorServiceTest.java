package com.example.vaadin.other.bmiCaclulator;

import com.example.vaadin.other.bmiCalculator.BmiCalculatorService;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Błażej on 11.08.2016.
 */
public class BmiCaclulatorServiceTest {

    private BmiCalculatorService bmiCalculatorService = new BmiCalculatorService();

    @Test
    private void BmiCaclulatorServiceTest(){

        Assert.assertEquals("23,46",bmiCalculatorService.calculateBmi("180","76"));
    }
}
