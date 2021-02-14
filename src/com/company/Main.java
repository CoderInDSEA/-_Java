package com.company;


import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.lang.String;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String command_copy ;
        char [] command_out ;
        System.out.println("Enter command : " );
        command_copy = input.nextLine();
        char [] command = new char[command_copy.length()];
        for (int i = 0; i < command_copy.length(); i++){
            command[i] = command_copy.charAt(i);
        }
        command_out = CommandIdentifier(command);
        System.out.println(command_copy);
        System.out.println(command_out);
    }
    public static char [] CommandIdentifier (char [] command ) {
        //indicators
        char [] ReturnFail = {'F'} ;
        char [] ReturnFail1 = {'F','1'};
        char [] ReturnFail2 = {'F','2'};
        char [] ReturnFail3 = {'F','3'};
        char [] Success  = {'S','u','c','c','e','s','s'};
        String  SuccessTest = "Success" ;

        //Separators
        char startString = '%';
        char endString = '@';
        char delimiterString = '_';

        //Command component
        char [] firstParCommand = {'0', '1', '2','3', '4', '5', '6'};
        String [] limitation = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
        String limitationString = "1234567890abcdef";
        char [] limitationChar = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        //Command helper
        char first_Cmd;
        char [] firstParameter = {' '} , secondParameter = {' '} , thirdParameter = {' '} , fourthParameter = {' '} , color = {' '} ;
        String [] firstPar = {""} ;
        String parameterColor , parameterX, parameterY, parameterX1, parameterY1, parameterW, parameterH , parameterRadX , parameterRadY;
        int  counterCommand = 0, counterLimitation = 0 , counterCmd = 0 , CounterFailColor = 0 ;

        //Array size
        color = new char [4];
        firstParameter = new char[3];
        secondParameter = new char[3];
        thirdParameter = new char[3];
        fourthParameter = new char[3];

        //Algorithm
        if (command[0] == startString ) {
            counterCommand++;//1
            for (int j = 0; j < firstParCommand.length; j++) {

                if (command[counterCommand] == firstParCommand[j]) {
                    counterCommand++;//2
                    first_Cmd = firstParCommand[j];
                    if (command[counterCommand] == delimiterString) {
                        counterCommand++;//3
                            switch (first_Cmd) {
                                //Clear
                                case '0':
                                    //Copy Color
                                    for (int CopyColor = counterCommand ; CopyColor < command.length; CopyColor++) {
                                        if (command [CopyColor] == endString) {
                                            counterCommand++;
                                            break;
                                        }
                                        color [counterCmd] = command[CopyColor];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    //Limitation of color text and Outputting the parsed command to the screen
                                    for (int CountToCount = 0 ; CountToCount < 4 ; ++CountToCount) {
                                        for (int CountLimit = 0; CountLimit <= limitationChar.length; CountLimit++) {
                                            if (color[CountToCount] == limitationChar[CountLimit]) {
                                                counterLimitation++;
                                                if (counterLimitation >= 4) {
                                                    parameterColor = String.valueOf(color) ;
                                                    System.out.println((String.format("Clear - color - %s", parameterColor)));
                                                    return Success ;
                                                } else {
                                                    break;
                                                }
                                            }
                                            else  {
                                                CounterFailColor++;
                                            }
                                            if (CounterFailColor == limitationChar.length) {
                                                return ReturnFail3;
                                            }
                                        }
                                        CounterFailColor = 0;
                                    }
                                //DrawPixel
                                case '1':
                                    //Copy first Parameter
                                    for (int counterFirstPar = counterCommand; counterFirstPar < command.length; counterFirstPar++) {
                                        if (command[counterFirstPar] == delimiterString)
                                        {
                                            counterCommand++;
                                         break;
                                        }
                                        firstParameter[counterCmd] =  command[counterFirstPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    //Copy second Parameter
                                    for (int counterSecondPar = counterCommand; counterSecondPar < command.length; counterSecondPar++) {
                                        if (command[counterSecondPar] == delimiterString) {
                                            counterCommand++;
                                            break;
                                        }
                                        secondParameter[counterCmd] = command[counterSecondPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    //Copy Color
                                    for (int CopyColor = counterCommand ; CopyColor < command.length; CopyColor++) {
                                        if (command [CopyColor] == endString) {
                                            counterCommand++;
                                            break;
                                        }
                                        color [counterCmd] = command[CopyColor];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    //Limitation of color text and Outputting the parsed command to the screen
                                    for (int CountToCount = 0 ; CountToCount < 4 ; ++CountToCount) {
                                        for (int CountLimit = 0; CountLimit <= limitationChar.length; CountLimit++) {
                                            if (color[CountToCount] == limitationChar[CountLimit]) {
                                                counterLimitation++;
                                                if (counterLimitation >= 4) {
                                                    parameterX = String.valueOf(firstParameter);
                                                    parameterY = String.valueOf(secondParameter);
                                                    parameterColor = String.valueOf(color) ;
                                                    System.out.println((String.format("Draw pixel - first parameter - %s ," +
                                                            " second parameter - %s , color - %s", parameterX, parameterY, parameterColor)));
                                                    return Success;
                                                } else {
                                                    break;
                                                }
                                            }
                                            else  {
                                                CounterFailColor++;
                                            }
                                            if (CounterFailColor == limitationChar.length) {
                                                return ReturnFail3;
                                            }
                                        }
                                        CounterFailColor = 0;
                                    }
                                //Draw line
                                case '2':
                                    //Copy first Parameter
                                    for (int counterFirstPar = counterCommand; counterFirstPar < command.length; counterFirstPar++) {
                                        if (command[counterFirstPar] == delimiterString)
                                        {
                                            counterCommand++;
                                            break;
                                        }
                                        firstParameter[counterCmd] =  command[counterFirstPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    //Copy second Parameter
                                    for (int counterSecondPar = counterCommand; counterSecondPar < command.length; counterSecondPar++) {
                                        if (command[counterSecondPar] == delimiterString) {
                                            counterCommand++;
                                            break;
                                        }
                                        secondParameter[counterCmd] = command[counterSecondPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    //Copy third Parameter
                                    for (int counterThirdPar = counterCommand; counterThirdPar < command.length; counterThirdPar++) {
                                        if (command[counterThirdPar] == delimiterString) {
                                            counterCommand++;
                                            break;
                                        }
                                        thirdParameter[counterCmd] = command[counterThirdPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >=2) {
                                        counterCmd = 0;
                                    }
                                    //Copy fourth Parameter
                                    for (int counterFourthPar = counterCommand; counterFourthPar < command.length; counterFourthPar++) {
                                        if (command[counterFourthPar] == delimiterString) {
                                            counterCommand++;
                                            break;
                                        }
                                        fourthParameter[counterCmd] = command[counterFourthPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    //Copy Color
                                    for (int CopyColor = counterCommand ; CopyColor < command.length; CopyColor++) {
                                        if (command [CopyColor] == endString) {
                                            counterCommand++;
                                            break;
                                        }
                                        color [counterCmd] = command[CopyColor];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    //Limitation of color text and Outputting the parsed command to the screen
                                    for (int CountToCount = 0 ; CountToCount < 4 ; ++CountToCount) {
                                        for (int CountLimit = 0; CountLimit <= limitationChar.length; CountLimit++) {
                                            if (color[CountToCount] == limitationChar[CountLimit]) {
                                                counterLimitation++;
                                                if (counterLimitation >= 4) {
                                                    parameterX = String.valueOf(firstParameter);
                                                    parameterY = String.valueOf(secondParameter);
                                                    parameterW = String.valueOf(thirdParameter);
                                                    parameterH = String.valueOf(fourthParameter);
                                                    parameterColor = String.valueOf(color) ;
                                                    System.out.println((String.format("Draw line - first parameter X - %s , " +
                                                            "second parameter Y - %s , " +
                                                            "third parameter X1 - %s , " +
                                                            "fourth parameter Y1 - %s , " +
                                                            "color - %s", parameterX, parameterY, parameterW, parameterH, parameterColor)));
                                                    return Success;
                                                } else {
                                                    break;
                                                }
                                            }
                                            else  {
                                                CounterFailColor++;
                                            }
                                            if (CounterFailColor == limitationChar.length) {
                                                return ReturnFail3;
                                            }
                                        }
                                        CounterFailColor = 0;
                                    }
                                //Draw Rectangle
                                case '3':
                                    for (int counterFirstPar = counterCommand; counterFirstPar < command.length; counterFirstPar++) {
                                        if (command[counterFirstPar] == delimiterString)
                                        {
                                            counterCommand++;
                                            break;
                                        }
                                        firstParameter[counterCmd] =  command[counterFirstPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int counterSecondPar = counterCommand; counterSecondPar < command.length; counterSecondPar++) {
                                        if (command[counterSecondPar] == delimiterString) {
                                            counterCommand++;
                                            break;
                                        }
                                        secondParameter[counterCmd] = command[counterSecondPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int counterThirdPar = counterCommand; counterThirdPar < command.length; counterThirdPar++) {
                                        if (command[counterThirdPar] == delimiterString) {
                                            counterCommand++;
                                            break;
                                        }
                                        thirdParameter[counterCmd] = command[counterThirdPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int counterFourthPar = counterCommand; counterFourthPar < command.length; counterFourthPar++) {
                                        if (command[counterFourthPar] == delimiterString) {
                                            counterCommand++;
                                            break;
                                        }
                                        fourthParameter[counterCmd] = command[counterFourthPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int CopyColor = counterCommand ; CopyColor < command.length; CopyColor++) {
                                        if (command [CopyColor] == endString) {
                                            counterCommand++;
                                            break;
                                        }
                                        color [counterCmd] = command[CopyColor];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    for (int CountToCount = 0 ; CountToCount < 4 ; ++CountToCount) {
                                        for (int CountLimit = 0; CountLimit <= limitationChar.length; CountLimit++) {
                                            if (color[CountToCount] == limitationChar[CountLimit]) {
                                                counterLimitation++;
                                                if (counterLimitation >= 4) {
                                                    parameterX = String.valueOf(firstParameter);
                                                    parameterY = String.valueOf(secondParameter);
                                                    parameterW = String.valueOf(thirdParameter);
                                                    parameterH = String.valueOf(fourthParameter);
                                                    parameterColor = String.valueOf(color) ;
                                                    System.out.println((String.format("Draw Rectangle - first parameter X - %s , " +
                                                            "second parameter Y - %s , " +
                                                            "third parameter W - %s , " +
                                                            "fourth parameter H - %s , " +
                                                            "color - %s", parameterX, parameterY, parameterW, parameterH, parameterColor)));
                                                    return Success;
                                                } else {
                                                    break;
                                                }
                                            }
                                            else  {
                                                CounterFailColor++;
                                            }
                                            if (CounterFailColor == limitationChar.length) {
                                                return ReturnFail3;
                                            }
                                        }
                                        CounterFailColor = 0;
                                    }
                                //Fill Rectangle
                                case '4':
                                    for (int counterFirstPar = counterCommand; counterFirstPar < command.length; counterFirstPar++) {
                                        if (command[counterFirstPar] == delimiterString)
                                        {
                                            counterCommand++;
                                            break;
                                        }
                                        firstParameter[counterCmd] =  command[counterFirstPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int counterSecondPar = counterCommand; counterSecondPar < command.length; counterSecondPar++) {
                                        if (command[counterSecondPar] == delimiterString) {
                                            counterCommand++;
                                            break;
                                        }
                                        secondParameter[counterCmd] = command[counterSecondPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int counterThirdPar = counterCommand; counterThirdPar < command.length; counterThirdPar++) {
                                        if (command[counterThirdPar] == delimiterString) {
                                            counterCommand++;
                                            break;
                                        }
                                        thirdParameter[counterCmd] = command[counterThirdPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int counterFourthPar = counterCommand; counterFourthPar < command.length; counterFourthPar++) {
                                        if (command[counterFourthPar] == delimiterString) {
                                            counterCommand++;
                                            break;
                                        }
                                        fourthParameter[counterCmd] = command[counterFourthPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int CopyColor = counterCommand ; CopyColor < command.length; CopyColor++) {
                                        if (command [CopyColor] == endString) {
                                            counterCommand++;
                                            break;
                                        }
                                        color [counterCmd] = command[CopyColor];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    for (int CountToCount = 0 ; CountToCount < 4 ; ++CountToCount) {
                                        for (int CountLimit = 0; CountLimit <= limitationChar.length; CountLimit++) {
                                            if (color[CountToCount] == limitationChar[CountLimit]) {
                                                counterLimitation++;
                                                if (counterLimitation >= 4) {
                                                    parameterX = String.valueOf(firstParameter);
                                                    parameterY = String.valueOf(secondParameter);
                                                    parameterW = String.valueOf(thirdParameter);
                                                    parameterH = String.valueOf(fourthParameter);
                                                    parameterColor = String.valueOf(color) ;
                                                    System.out.println((String.format("Fill Rectangle - first parameter X - %s , " +
                                                            "second parameter Y - %s , " +
                                                            "third parameter W - %s , " +
                                                            "fourth parameter H - %s , " +
                                                            "color - %s", parameterX, parameterY, parameterW, parameterH, parameterColor)));
                                                    return Success;
                                                } else {
                                                    break;
                                                }
                                            }
                                            else  {
                                                CounterFailColor++;
                                            }
                                            if (CounterFailColor == limitationChar.length) {
                                                return ReturnFail3;
                                            }
                                        }
                                        CounterFailColor = 0;
                                    }
                                //Draw Ellipse
                                case '5':
                                    for (int counterFirstPar = counterCommand; counterFirstPar < command.length; counterFirstPar++) {
                                        if (command[counterFirstPar] == delimiterString)
                                        {
                                            counterCommand++;
                                            break;
                                        }
                                        firstParameter[counterCmd] =  command[counterFirstPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int counterSecondPar = counterCommand; counterSecondPar < command.length; counterSecondPar++) {
                                        if (command[counterSecondPar] == delimiterString) {
                                            counterCommand++;
                                            break;
                                        }
                                        secondParameter[counterCmd] = command[counterSecondPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int counterThirdPar = counterCommand; counterThirdPar < command.length; counterThirdPar++) {
                                        if (command[counterThirdPar] == delimiterString) {
                                            counterCommand++;
                                            break;
                                        }
                                        thirdParameter[counterCmd] = command[counterThirdPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int counterFourthPar = counterCommand; counterFourthPar < command.length; counterFourthPar++) {
                                        if (command[counterFourthPar] == delimiterString) {
                                            counterCommand++;
                                            break;
                                        }
                                        fourthParameter[counterCmd] = command[counterFourthPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int CopyColor = counterCommand ; CopyColor < command.length; CopyColor++) {
                                        if (command [CopyColor] == endString) {
                                            counterCommand++;
                                            break;
                                        }
                                        color [counterCmd] = command[CopyColor];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    for (int CountToCount = 0 ; CountToCount < 4 ; ++CountToCount) {
                                        for (int CountLimit = 0; CountLimit <= limitationChar.length; CountLimit++) {
                                            if (color[CountToCount] == limitationChar[CountLimit]) {
                                                counterLimitation++;
                                                if (counterLimitation >= 4) {
                                                    parameterX = String.valueOf(firstParameter);
                                                    parameterY = String.valueOf(secondParameter);
                                                    parameterRadX = String.valueOf(thirdParameter);
                                                    parameterRadY = String.valueOf(fourthParameter);
                                                    parameterColor = String.valueOf(color) ;
                                                    System.out.println((String.format("Draw Ellipse - first parameter X - %s , " +
                                                            "second parameter Y - %s , " +
                                                            "third parameter Radius X - %s , " +
                                                            "fourth parameter Radius Y  - %s , " +
                                                            "color - %s", parameterX, parameterY, parameterRadX, parameterRadY, parameterColor)));
                                                    return Success;
                                                } else {
                                                    break;
                                                }
                                            }
                                            else  {
                                                CounterFailColor++;
                                            }
                                            if (CounterFailColor == limitationChar.length) {
                                                return ReturnFail3;
                                            }
                                        }
                                        CounterFailColor = 0;
                                    }
                                //Fill Ellipse
                                case '6':
                                    for (int counterFirstPar = counterCommand; counterFirstPar < command.length; counterFirstPar++) {
                                        if (command[counterFirstPar] == delimiterString)
                                        {
                                            counterCommand++;
                                            break;
                                        }
                                        firstParameter[counterCmd] =  command[counterFirstPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int counterSecondPar = counterCommand; counterSecondPar < command.length; counterSecondPar++) {
                                        if (command[counterSecondPar] == delimiterString) {
                                            counterCommand++;
                                            break;
                                        }
                                        secondParameter[counterCmd] = command[counterSecondPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int counterThirdPar = counterCommand; counterThirdPar < command.length; counterThirdPar++) {
                                        if (command[counterThirdPar] == delimiterString) {
                                            counterCommand++;
                                            break;
                                        }
                                        thirdParameter[counterCmd] = command[counterThirdPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int counterFourthPar = counterCommand; counterFourthPar < command.length; counterFourthPar++) {
                                        if (command[counterFourthPar] == delimiterString) {
                                            counterCommand++;
                                            break;
                                        }
                                        fourthParameter[counterCmd] = command[counterFourthPar];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if(counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int CopyColor = counterCommand ; CopyColor < command.length; CopyColor++) {
                                        if (command [CopyColor] == endString) {
                                            counterCommand++;
                                            break;
                                        }
                                        color [counterCmd] = command[CopyColor];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    for (int CountToCount = 0 ; CountToCount < 4 ; ++CountToCount) {
                                        for (int CountLimit = 0; CountLimit <= limitationChar.length; CountLimit++) {
                                            if (color[CountToCount] == limitationChar[CountLimit]) {
                                                counterLimitation++;
                                                if (counterLimitation >= 4) {
                                                    parameterX = String.valueOf(firstParameter);
                                                    parameterY = String.valueOf(secondParameter);
                                                    parameterRadX = String.valueOf(thirdParameter);
                                                    parameterRadY = String.valueOf(fourthParameter);
                                                    parameterColor = String.valueOf(color) ;
                                                    System.out.println((String.format("Fill Ellipse - first parameter X - %s , " +
                                                            "second parameter Y - %s , " +
                                                            "third parameter Radius X - %s , " +
                                                            "fourth parameter Radius Y  - %s , " +
                                                            "color - %s", parameterX, parameterY, parameterRadX, parameterRadY, parameterColor)));
                                                    return Success;
                                                } else {
                                                    break;
                                                }
                                            }
                                            else  {
                                                CounterFailColor++;
                                            }
                                            if (CounterFailColor == limitationChar.length) {
                                                return ReturnFail3;
                                            }
                                        }
                                        CounterFailColor = 0;
                                    }
                                default:
                                    break;
                            }
                    }
                    else
                        return ReturnFail2;
                }
            }
        }
        else
            return ReturnFail1;
        return ReturnFail;
    }
}