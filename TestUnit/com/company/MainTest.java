package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    private CommandParser retValue;
    Object [] CommandParameters (){
        Object [] TestParameters  = new Object [2];
        TestParameters [1] = "ffff";
        return TestParameters;
    }
    Object [] CommandReturn  (){
        Object [] ReturnParameters  = new Object [2];
        ReturnParameters [1] = "ffff";
        return ReturnParameters;
    }
    @Test
    //  1 test success
    public void TestFirstCommand () {
        Object [] ParametersTest = CommandParameters();
        Object [] ParametersReturn = CommandReturn();
        CommandParser returningValue = new CommandParser();
        char [] commandTestFirstCommand = {'%','0','_','f','f','f','f','@'};
        ParametersTest [0] = new int[]{0};
        ParametersTest[1] = "ffff";
        ParametersReturn [0] =  returningValue.RetParameters(commandTestFirstCommand);
        ParametersReturn [1] = returningValue.RetColor(commandTestFirstCommand);
        assertEquals(ParametersTest , ParametersReturn);
    }
    @Test
    //  1 test error
    public void TestFirstCommandError () {
        Object [] ParametersTest = CommandParameters();
        Object [] ParametersReturn = CommandReturn();
        CommandParser returningValue = new CommandParser();
        char [] commandTestFirstCommandError = {'%','0','_','f','f','f','f','@'};
        ParametersTest [0] = new int[]{0};
        ParametersTest[1] = "faff";
        ParametersReturn [0] =  returningValue.RetParameters(commandTestFirstCommandError);
        ParametersReturn [1] = returningValue.RetColor(commandTestFirstCommandError);
        assertNotEquals(ParametersTest , ParametersReturn);
    }
    @Test
    //  2 test success
    public void TestSecondCommand () {
        Object [] ParametersTest = CommandParameters();
        Object [] ParametersReturn = CommandReturn();
        CommandParser returningValue = new CommandParser();
        char [] commandTestSecondCommand = {'%','1','_','1','0','0','_','1','0','0','_','f','f','f','f','@'};
        ParametersTest [0] = new int[]{1,100,100};
        ParametersTest[1] = "ffff";
        ParametersReturn [0] =  returningValue.RetParameters(commandTestSecondCommand);
        ParametersReturn [1] = returningValue.RetColor(commandTestSecondCommand);
        assertEquals(ParametersTest , ParametersReturn);
    }
    @Test
    //  2 test error
    public void TestSecondCommandError () {
        Object [] ParametersTest = CommandParameters();
        Object [] ParametersReturn = CommandReturn();
        CommandParser returningValue = new CommandParser();
        char [] commandTestSecondCommandError = {'%','1','_','1','0','0','_','1','0','0','_','f','f','f','f','@'};
        ParametersTest [0] = new int[]{1,100,100};
        ParametersTest[1] = "ffff";
        ParametersReturn [0] =  returningValue.RetParameters(commandTestSecondCommandError);
        ParametersReturn [1] = returningValue.RetColor(commandTestSecondCommandError);
        assertNotEquals(ParametersTest , ParametersReturn);
    }
    @Test
    //  3 test success
    public void TestThirdCommand () {
        Object [] ParametersTest = CommandParameters();
        Object [] ParametersReturn = CommandReturn();
        CommandParser returningValue = new CommandParser();
        char [] commandTestThirdCommand = {'%','2','_','1','0','0','_','1','0','0','_','2','0','0','_','1','0','0','_','f','f','f','f','@'};
        ParametersTest [0] = new int[]{2, 100, 100, 200, 100};
        ParametersTest[1] = "ffff";
        ParametersReturn [0] =  returningValue.RetParameters(commandTestThirdCommand);
        ParametersReturn [1] = returningValue.RetColor(commandTestThirdCommand);
        assertEquals(ParametersTest , ParametersReturn);
    }
    @Test
    //  3 test error
    public void TestThirdCommandError () {
        Object [] ParametersTest = CommandParameters();
        Object [] ParametersReturn = CommandReturn();
        CommandParser returningValue = new CommandParser();
        char [] commandTestThirdCommandError = {'%','2','_','1','0','0','_','1','0','0','_','2','0','0','_','1','0','0','_','f','f','f','f','@'};
        ParametersTest [0] = new int[]{2, 100, 100, 100, 100};
        ParametersTest[1] = "ffff";
        ParametersReturn [0] =  returningValue.RetParameters(commandTestThirdCommandError);
        ParametersReturn [1] = returningValue.RetColor(commandTestThirdCommandError);
        assertNotEquals(ParametersTest , ParametersReturn);
    }
    @Test
    //  4 test success
    public void TestFourthCommand () {
        Object [] ParametersTest = CommandParameters();
        Object [] ParametersReturn = CommandReturn();
        CommandParser returningValue = new CommandParser();
        char [] commandTestFourthCommand = {'%','3','_','1','0','0','_','1','0','0','_','2','0','_','1','0','_','f','f','f','f','@'};
        ParametersTest [0] = new int[]{3, 100, 100, 20, 10};
        ParametersTest[1] = "ffff";
        ParametersReturn [0] =  returningValue.RetParameters(commandTestFourthCommand);
        ParametersReturn [1] = returningValue.RetColor(commandTestFourthCommand);
        assertEquals(ParametersTest , ParametersReturn);
    }
    @Test
    //  4 test error
    public void TestFourthCommandError () {
        Object [] ParametersTest = CommandParameters();
        Object [] ParametersReturn = CommandReturn();
        CommandParser returningValue = new CommandParser();
        char [] commandTestFourthCommandError= {'%','3','_','1','0','0','_','1','0','0','_','2','0','_','1','0','_','f','f','f','f','@'};
        ParametersTest [0] = new int[]{3, 100, 100, 100, 10};
        ParametersTest[1] = "ffff";
        ParametersReturn [0] =  returningValue.RetParameters(commandTestFourthCommandError);
        ParametersReturn [1] = returningValue.RetColor(commandTestFourthCommandError);
        assertNotEquals(ParametersTest , ParametersReturn);
    }
    @Test
    //  5 test success
    public void TestFiveCommand () {
        Object [] ParametersTest = CommandParameters();
        Object [] ParametersReturn = CommandReturn();
        CommandParser returningValue = new CommandParser();
        char [] commandTestFiveCommand = {'%','4','_','1','0','0','_','1','0','0','_','2','0','_','1','0','_','f','f','f','f','@'};
        ParametersTest [0] = new int[]{4, 100, 100, 20, 10};
        ParametersTest[1] = "ffff";
        ParametersReturn [0] =  returningValue.RetParameters(commandTestFiveCommand);
        ParametersReturn [1] = returningValue.RetColor(commandTestFiveCommand);
        assertEquals(ParametersTest , ParametersReturn);
    }
    @Test
    //  5 test error
    public void TestFiveCommandError () {
        Object [] ParametersTest = CommandParameters();
        Object [] ParametersReturn = CommandReturn();
        CommandParser returningValue = new CommandParser();
        char [] commandTestFourthCommandError= {'%','4','_','1','0','0','_','1','0','0','_','2','0','_','1','0','_','f','f','f','f','@'};
        ParametersTest [0] = new int[]{4, 100, 100, 20, 10};
        ParametersTest[1] = "fffa";
        ParametersReturn [0] =  returningValue.RetParameters(commandTestFourthCommandError);
        ParametersReturn [1] = returningValue.RetColor(commandTestFourthCommandError);
        assertNotEquals(ParametersTest , ParametersReturn);

    }
    @Test
    //  6 test success
    public void TestSixCommand () {
        Object [] ParametersTest = CommandParameters();
        Object [] ParametersReturn = CommandReturn();
        CommandParser returningValue = new CommandParser();
        char [] commandTestFiveCommand = {'%','5','_','1','0','0','_','1','0','0','_','5','0','_','1','0','_','f','f','f','f','@'};
        ParametersTest [0] = new int[]{5, 100, 100, 50, 10};
        ParametersTest[1] = "ffff";
        ParametersReturn [0] =  returningValue.RetParameters(commandTestFiveCommand);
        ParametersReturn [1] = returningValue.RetColor(commandTestFiveCommand);
        assertEquals(ParametersTest , ParametersReturn);
    }
    @Test
    //  6 test error
    public void TestSixCommandError () {
        Object[] ParametersTest = CommandParameters();
        Object[] ParametersReturn = CommandReturn();
        CommandParser returningValue = new CommandParser();
        char[] commandTestFourthCommandError = {'%', '5', '_', '1', '0', '0', '_', '1', '0', '0', '_', '5', '0', '_', '1', '0', '_', 'f', 'f', 'f', 'f', '@'};
        ParametersTest[0] = new int[]{5, 100, 100, 50, 10};
        ParametersTest[1] = "fffa";
        ParametersReturn[0] = returningValue.RetParameters(commandTestFourthCommandError);
        ParametersReturn[1] = returningValue.RetColor(commandTestFourthCommandError);
        assertNotEquals(ParametersTest, ParametersReturn);
    }
    @Test
    //  7 test success
    public void TestSevenCommand () {
        Object [] ParametersTest = CommandParameters();
        Object [] ParametersReturn = CommandReturn();
        CommandParser returningValue = new CommandParser();
        char [] commandTestFiveCommand = {'%','6','_','1','0','0','_','1','0','0','_','5','0','_','1','0','_','f','f','f','f','@'};
        ParametersTest [0] = new int[]{6, 100, 100, 50, 10};
        ParametersTest[1] = "ffff";
        ParametersReturn [0] =  returningValue.RetParameters(commandTestFiveCommand);
        ParametersReturn [1] = returningValue.RetColor(commandTestFiveCommand);
        assertEquals(ParametersTest , ParametersReturn);
    }
    @Test
    //  7 test error
    public void TestSevenCommandError () {
        Object[] ParametersTest = CommandParameters();
        Object[] ParametersReturn = CommandReturn();
        CommandParser returningValue = new CommandParser();
        char[] commandTestFourthCommandError = {'%', '6', '_', '1', '0', '0', '_', '1', '0', '0', '_', '5', '0', '_', '1', '0', '_', 'f', 'f', 'f', 'f', '@'};
        ParametersTest[0] = new int[]{5, 100, 100, 100, 10};
        ParametersTest[1] = "ffff";
        ParametersReturn[0] = returningValue.RetParameters(commandTestFourthCommandError);
        ParametersReturn[1] = returningValue.RetColor(commandTestFourthCommandError);
        assertNotEquals(ParametersTest, ParametersReturn);
    }


}