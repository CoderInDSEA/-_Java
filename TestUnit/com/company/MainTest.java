package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void TestCommandFirst (){
        Main commandTest = new Main();
        char [] command = {'%','0','_','f','f','f','f','@' };
        char [] Success  = {'S','u','c','c','e','s','s'};
        //char [] commandFirst = commandTest.CommandIdentifier(command);
       //assertEquals(Success, commandFirst);
    }

}