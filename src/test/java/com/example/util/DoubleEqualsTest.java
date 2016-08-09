package com.example.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Błażej on 09.08.2016.
 */
public class DoubleEqualsTest {

    @Test
    public void doubleEqualsTest(){
        Assert.assertEquals(432.23, DoubleEquals.convertFromDouble(432.234));
        Assert.assertEquals(432.23, DoubleEquals.convertFromDouble(432.239));
        Assert.assertEquals(432.23, DoubleEquals.convertFromString("432,234"));
        Assert.assertEquals(432.23, DoubleEquals.convertFromString("432.234"));
    }
}
