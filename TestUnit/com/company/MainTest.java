package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MainTest {
    private ReturningValue retValue;

    @Test
    //  1.1
    public void TestFirstCommandFirstParameter (){
        ReturningValue returningValue = new ReturningValue();
        char [] command = {'%','0','_','f','f','f','f','@'};
        boolean fail = false ;
        assertEquals(fail, returningValue.RetBoolean(command));
    }
    @Test
    //  1.2
    public void TestFirstCommandSecondParameter () {
        ReturningValue returningValue = new ReturningValue();
        char [] command = {'%','0','_','f','f','f','f','@'};
        int [] Parameters = {0};
        assertEquals(Parameters[0], returningValue.RetParameters(command));
    }
    @Test
    //  1.3
    public void TestFirstCommandThirdParameter () {
        ReturningValue returningValue = new ReturningValue();
        char [] command = {'%','0','_','f','f','f','f','@'};
        String ColorReturn = "ffff";
        assertEquals(ColorReturn, returningValue.RetColor(command));
    }

}