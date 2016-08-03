package com.example.vaadin.Calculejter;

import com.example.vaadin.calculejter.CalculatorPresenter;
import com.example.vaadin.calculejter.DegreeCalculator;
import com.example.vaadin.calculejter.exception.BadValuesException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Błażej on 31.07.2016.
 */
public class CreditCalculatorTest {

    private static CalculatorPresenter calculatorPresenter = new CalculatorPresenter();

    @Test
    public void creditCalculatorTest() throws BadValuesException {

        Assert.assertEquals("100,00",calculatorPresenter.calculateCredit("100","2","0"));
        Assert.assertEquals("110,25",calculatorPresenter.calculateCredit("100","2","5"));

        Assert.assertTrue(creditTestException("-100","2","5"));
        Assert.assertTrue(creditTestException("100","-2","5"));
        Assert.assertTrue(creditTestException("100","22","5"));
        Assert.assertTrue(creditTestException("100","2","-5"));
    }
    public boolean creditTestException(String a,String b,String c){
        try {
            calculatorPresenter.calculateCredit(a,b,c);
        } catch (BadValuesException e) {
            return true;
        }
        return false;
    }
}
