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
    public void bmiCaclulatorServiceTest(){

        Assert.assertEquals("Lecisz sobie w kulki",bmiCalculatorService.calculateBmi("25","200"));
        Assert.assertEquals("Twoje BMI wynosi 11,76. Możesz włamać się do czołgu przez lufę",bmiCalculatorService.calculateBmi("34","170"));
        Assert.assertEquals("Twoje BMI wynosi 16,66. Chorujesz na anoreksję!",bmiCalculatorService.calculateBmi("49.3","172"));
        Assert.assertEquals("Twoje BMI wynosi 17,25. Masz niedowagę",bmiCalculatorService.calculateBmi("50.0001","170.235"));
        Assert.assertEquals("Twoje BMI wynosi 23,46. Gratuluję, twoja waga jest prawidłowa",bmiCalculatorService.calculateBmi("76","179.99"));
        Assert.assertEquals("Twoje BMI wynosi 25,70. Masz nadwagę",bmiCalculatorService.calculateBmi("83.123","179.831"));
        Assert.assertEquals("Twoje BMI wynosi 30,62. Uważaj! Masz I stopień otyłości!",bmiCalculatorService.calculateBmi("89.0","170.5"));
        Assert.assertEquals("Twoje BMI wynosi 35,88. Przestań wpieprzać pączki!!",bmiCalculatorService.calculateBmi("109.89","175.0"));
        Assert.assertEquals("Twoje BMI wynosi 81,58. Sytuacja jest krytyczna!!",bmiCalculatorService.calculateBmi("276.11111","183.967"));
        Assert.assertEquals("Coś się popsuło",bmiCalculatorService.calculateBmi(null,null));
        Assert.assertEquals("Podałeś złe wartośći",bmiCalculatorService.calculateBmi("test","180"));
        Assert.assertEquals("Podałeś złe wartośći",bmiCalculatorService.calculateBmi("76","test"));

    }

}
