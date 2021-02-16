package com.company;

public class ReturningValue {
    boolean fail ;
    public int [] Parameters = {0};
    public String value;
    public ReturningValue (boolean fail, int [] index , String value ) {
        this.fail = fail;
        this.Parameters = index;
        this.value = value;
    }
    ReturningValue () {

    }
    ReturningValue CommandIdentifier (char [] command ) {

        //Separators
        char startString = '%';
        char endString = '@';
        char delimiterString = '_';

        //Command component
        char [] firstParCommand = {'0', '1', '2','3', '4', '5', '6'};
        char [] limitationChar = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        //Command helper
        char first_Cmd;
        char [] color = {' '} ;
        String parameterColor = "" ,
                parameterX = "", parameterY = "",
                parameterX1 = "", parameterY1 = "",
                parameterW = "", parameterH = "",
                parameterRadX = "" , parameterRadY = "";
        int  counterCommand = 0, // counter for full command
                counterLimitation = 0 ,
                counterCmd = 0 ,
                CounterFailColor = 0 ,
                counterIndexParameters = 0,
                countParameters = 1,
                startParameter;

        //Size Array
        color = new char [4];

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
                                                value = String.valueOf(color);
                                                fail = false;
                                                System.out.println((String.format("Clear - color - %s", parameterColor)));
                                                return new ReturningValue (fail,Parameters, value);
                                            } else {
                                                break;
                                            }
                                        }
                                        else  {
                                            CounterFailColor++;
                                        }
                                        if (CounterFailColor == limitationChar.length) {
                                            //returnValue.value = String.valueOf(ReturnFail3);
                                            fail = false;
                                             return new ReturningValue (fail , Parameters, value)  ;
                                        }
                                    }
                                    CounterFailColor = 0;
                                }
                                //DrawPixel
                            case '1':
                                //Copy first Parameter
                                startParameter = counterCommand;
                                for (int counterFirstPar = counterCommand; counterFirstPar < command.length; counterFirstPar++) {
                                    if (command[counterFirstPar] == delimiterString)
                                    {
                                        counterCommand++;
                                        countParameters++;
                                        parameterX = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >= 2) {
                                    counterCmd = 0;
                                }
                                //Copy second Parameter
                                startParameter = counterCommand;
                                for (int counterSecondPar = counterCommand; counterSecondPar < command.length; counterSecondPar++) {
                                    if (command[counterSecondPar] == delimiterString) {
                                        counterCommand++;
                                        countParameters++;
                                        parameterY = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
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
                                                parameterColor = String.valueOf(color) ;
                                                fail = false;
                                                Parameters = new int[countParameters];
                                                Parameters[counterIndexParameters] = Integer.parseInt(String.valueOf(first_Cmd));
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterX);
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterY);
                                                value = String.valueOf(color);
                                                System.out.println((String.format("Draw pixel - first parameter - %s ," +
                                                        " second parameter - %s , color - %s", parameterX, parameterY, parameterColor)));
                                                return new ReturningValue (fail,Parameters, value)  ;
                                            } else {
                                                break;
                                            }
                                        }
                                        else  {
                                            CounterFailColor++;
                                        }
                                        if (CounterFailColor == limitationChar.length) {
                                            return new ReturningValue (true, Parameters, value)  ;
                                        }
                                    }
                                    CounterFailColor = 0;
                                }
                                //Draw line
                            case '2':
                                //Copy first Parameter
                                startParameter = counterCommand;
                                for (int counterFirstPar = counterCommand; counterFirstPar < command.length; counterFirstPar++) {
                                    if (command[counterFirstPar] == delimiterString)
                                    {
                                        counterCommand++;
                                        countParameters++;
                                        parameterX = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >= 2) {
                                    counterCmd = 0;
                                    startParameter = counterCommand;
                                }
                                //Copy second Parameter
                                for (int counterSecondPar = counterCommand; counterSecondPar < command.length; counterSecondPar++) {
                                    if (command[counterSecondPar] == delimiterString) {
                                        counterCommand++;
                                        countParameters++;
                                        parameterY = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >= 2) {
                                    counterCmd = 0;
                                    startParameter = counterCommand;
                                }
                                //Copy third Parameter
                                for (int counterThirdPar = counterCommand; counterThirdPar < command.length; counterThirdPar++) {
                                    if (command[counterThirdPar] == delimiterString) {
                                        counterCommand++;
                                        countParameters++;
                                        parameterX1 = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >=2) {
                                    counterCmd = 0;
                                    startParameter = counterCommand;
                                }
                                //Copy fourth Parameter
                                for (int counterFourthPar = counterCommand; counterFourthPar < command.length; counterFourthPar++) {
                                    if (command[counterFourthPar] == delimiterString) {
                                        counterCommand++;
                                        countParameters++;
                                        parameterY1 = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
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
                                                parameterColor = String.valueOf(color) ;
                                                fail = false;
                                                Parameters = new int[countParameters];
                                                Parameters[counterIndexParameters] = Integer.parseInt(String.valueOf(color));
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterX);
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterY);
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterX1);
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterY1);
                                                value = String.valueOf(color);
                                                System.out.println((String.format("Draw line - first parameter X - %s , " +
                                                        "second parameter Y - %s , " +
                                                        "third parameter X1 - %s , " +
                                                        "fourth parameter Y1 - %s , " +
                                                        "color - %s", parameterX, parameterY, parameterX1, parameterY1, parameterColor)));
                                                return new ReturningValue (fail, Parameters, value)  ;
                                            } else {
                                                break;
                                            }
                                        }
                                        else  {
                                            CounterFailColor++;
                                        }
                                        if (CounterFailColor == limitationChar.length) {
                                            return new ReturningValue (true , Parameters, value)  ;
                                        }
                                    }
                                    CounterFailColor = 0;
                                }
                                //Draw Rectangle
                            case '3':
                                startParameter = counterCommand;
                                for (int counterFirstPar = counterCommand; counterFirstPar < command.length; counterFirstPar++) {
                                    if (command[counterFirstPar] == delimiterString)
                                    {
                                        counterCommand++;
                                        countParameters++;
                                        parameterX = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >=2) {
                                    counterCmd = 0;
                                    startParameter = counterCommand;
                                }
                                for (int counterSecondPar = counterCommand; counterSecondPar < command.length; counterSecondPar++) {
                                    if (command[counterSecondPar] == delimiterString) {
                                        counterCommand++;
                                        countParameters++;
                                        parameterY = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >=2) {
                                    counterCmd = 0;
                                    startParameter = counterCommand;
                                }
                                for (int counterThirdPar = counterCommand; counterThirdPar < command.length; counterThirdPar++) {
                                    if (command[counterThirdPar] == delimiterString) {
                                        counterCommand++;
                                        countParameters++;
                                        parameterW = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >=2) {
                                    counterCmd = 0;
                                    startParameter = counterCommand;
                                }
                                for (int counterFourthPar = counterCommand; counterFourthPar < command.length; counterFourthPar++) {
                                    if (command[counterFourthPar] == delimiterString) {
                                        counterCommand++;
                                        countParameters++;
                                        parameterH = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >=2) {
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
                                                parameterColor = String.valueOf(color) ;
                                                fail = false;
                                                Parameters = new int[countParameters];
                                                Parameters[counterIndexParameters] = Integer.parseInt(String.valueOf(first_Cmd));
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterX);
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterY);
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterW);
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterH);
                                                value = String.valueOf(color);
                                                System.out.println((String.format("Draw Rectangle - first parameter X - %s , " +
                                                        "second parameter Y - %s , " +
                                                        "third parameter W - %s , " +
                                                        "fourth parameter H - %s , " +
                                                        "color - %s", parameterX, parameterY, parameterW, parameterH, parameterColor)));
                                                return new ReturningValue (fail, Parameters, value)  ;
                                            } else {
                                                break;
                                            }
                                        }
                                        else  {
                                            CounterFailColor++;
                                        }
                                        if (CounterFailColor == limitationChar.length) {
                                            return new ReturningValue (true,Parameters, value)  ;
                                        }
                                    }
                                    CounterFailColor = 0;
                                }
                                //Fill Rectangle
                            case '4':
                                startParameter = counterCommand;
                                for (int counterFirstPar = counterCommand; counterFirstPar < command.length; counterFirstPar++) {
                                    if (command[counterFirstPar] == delimiterString)
                                    {
                                        counterCommand++;
                                        countParameters++;
                                        parameterX = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >=2) {
                                    counterCmd = 0;
                                    startParameter = counterCommand;
                                }
                                for (int counterSecondPar = counterCommand; counterSecondPar < command.length; counterSecondPar++) {
                                    if (command[counterSecondPar] == delimiterString) {
                                        counterCommand++;
                                        countParameters++;
                                        parameterY = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >=2) {
                                    counterCmd = 0;
                                    startParameter = counterCommand;
                                }
                                for (int counterThirdPar = counterCommand; counterThirdPar < command.length; counterThirdPar++) {
                                    if (command[counterThirdPar] == delimiterString) {
                                        counterCommand++;
                                        countParameters++;
                                        parameterW = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >=2) {
                                    counterCmd = 0;
                                    startParameter = counterCommand;
                                }
                                for (int counterFourthPar = counterCommand; counterFourthPar < command.length; counterFourthPar++) {
                                    if (command[counterFourthPar] == delimiterString) {
                                        counterCommand++;
                                        countParameters++;
                                        parameterH = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >=2) {
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
                                                parameterColor = String.valueOf(color) ;
                                                fail = false;
                                                Parameters = new int[countParameters];
                                                Parameters[counterIndexParameters] = Integer.parseInt(String.valueOf(first_Cmd));
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterX);
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterY);
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterW);
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterH);
                                                value = String.valueOf(color);
                                                System.out.println((String.format("Fill Rectangle - first parameter X - %s , " +
                                                        "second parameter Y - %s , " +
                                                        "third parameter W - %s , " +
                                                        "fourth parameter H - %s , " +
                                                        "color - %s", parameterX, parameterY, parameterW, parameterH, parameterColor)));
                                                return new ReturningValue (fail,Parameters, value)  ;
                                            } else {
                                                break;
                                            }
                                        }
                                        else  {
                                            CounterFailColor++;
                                        }
                                        if (CounterFailColor == limitationChar.length) {
                                            return new ReturningValue (true, Parameters, value)  ;
                                        }
                                    }
                                    CounterFailColor = 0;
                                }
                                //Draw Ellipse
                            case '5':
                                startParameter = counterCommand;
                                for (int counterFirstPar = counterCommand; counterFirstPar < command.length; counterFirstPar++) {
                                    if (command[counterFirstPar] == delimiterString)
                                    {
                                        counterCommand++;
                                        countParameters++;
                                        parameterX = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;

                                }
                                if(counterCmd >=2) {
                                    counterCmd = 0;
                                    startParameter = counterCommand;
                                }
                                for (int counterSecondPar = counterCommand; counterSecondPar < command.length; counterSecondPar++) {
                                    if (command[counterSecondPar] == delimiterString) {
                                        counterCommand++;
                                        countParameters++;
                                        parameterY = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >=2) {
                                    counterCmd = 0;
                                    startParameter = counterCommand;
                                }
                                for (int counterThirdPar = counterCommand; counterThirdPar < command.length; counterThirdPar++) {
                                    if (command[counterThirdPar] == delimiterString) {
                                        counterCommand++;
                                        countParameters++;
                                        parameterRadX = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >=2) {
                                    counterCmd = 0;
                                    startParameter = counterCommand;
                                }
                                for (int counterFourthPar = counterCommand; counterFourthPar < command.length; counterFourthPar++) {
                                    if (command[counterFourthPar] == delimiterString) {
                                        counterCommand++;
                                        countParameters++;
                                        parameterRadY = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >=2) {
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
                                                parameterColor = String.valueOf(color) ;
                                                fail = false;
                                                Parameters = new int[countParameters];
                                                Parameters[counterIndexParameters] = Integer.parseInt(String.valueOf(first_Cmd));
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterX);
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterY);
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterRadX);
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterRadY);
                                                value = String.valueOf(color);
                                                System.out.println((String.format("Draw Ellipse - first parameter X - %s , " +
                                                        "second parameter Y - %s , " +
                                                        "third parameter Radius X - %s , " +
                                                        "fourth parameter Radius Y  - %s , " +
                                                        "color - %s", parameterX, parameterY, parameterRadX, parameterRadY, parameterColor)));
                                                return new ReturningValue (fail ,Parameters, value)  ;
                                            } else {
                                                break;
                                            }
                                        }
                                        else  {
                                            CounterFailColor++;
                                        }
                                        if (CounterFailColor == limitationChar.length) {
                                            return new ReturningValue (true  ,Parameters, value)  ;
                                        }
                                    }
                                    CounterFailColor = 0;
                                }
                                //Fill Ellipse
                            case '6':
                                startParameter = counterCommand;
                                for (int counterFirstPar = counterCommand; counterFirstPar < command.length; counterFirstPar++) {
                                    if (command[counterFirstPar] == delimiterString)
                                    {
                                        counterCommand++;
                                        countParameters++;
                                        parameterX = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >=2) {
                                    counterCmd = 0;
                                    startParameter = counterCommand;
                                }
                                for (int counterSecondPar = counterCommand; counterSecondPar < command.length; counterSecondPar++) {
                                    if (command[counterSecondPar] == delimiterString) {
                                        counterCommand++;
                                        countParameters++;
                                        parameterY = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >=2) {
                                    counterCmd = 0;
                                    startParameter = counterCommand;
                                }
                                for (int counterThirdPar = counterCommand; counterThirdPar < command.length; counterThirdPar++) {
                                    if (command[counterThirdPar] == delimiterString) {
                                        counterCommand++;
                                        countParameters++;
                                        parameterRadX = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >=2) {
                                    counterCmd = 0;
                                    startParameter = counterCommand;
                                }
                                for (int counterFourthPar = counterCommand; counterFourthPar < command.length; counterFourthPar++) {
                                    if (command[counterFourthPar] == delimiterString) {
                                        counterCommand++;
                                        countParameters++;
                                        parameterRadY = String.valueOf(command,startParameter, counterCmd );
                                        break;
                                    }
                                    counterCmd++;
                                    counterCommand++;
                                }
                                if(counterCmd >=2) {
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
                                                parameterColor = String.valueOf(color) ;
                                                fail = false;
                                                Parameters = new int[countParameters];
                                                Parameters[counterIndexParameters] = Integer.parseInt(String.valueOf(first_Cmd));
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterX);
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterY);
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterRadX);
                                                counterIndexParameters++;
                                                Parameters[counterIndexParameters] = Integer.parseInt(parameterRadY);
                                                value = String.valueOf(color);
                                                System.out.println((String.format("Fill Ellipse - first parameter X - %s , " +
                                                        "second parameter Y - %s , " +
                                                        "third parameter Radius X - %s , " +
                                                        "fourth parameter Radius Y  - %s , " +
                                                        "color - %s", parameterX, parameterY, parameterRadX, parameterRadY, parameterColor)));
                                                return new ReturningValue (fail,Parameters, value)  ;
                                            } else {
                                                break;
                                            }
                                        }
                                        else  {
                                            CounterFailColor++;
                                        }
                                        if (CounterFailColor == limitationChar.length) {
                                            return new ReturningValue (true, Parameters, value)  ;
                                        }
                                    }
                                    CounterFailColor = 0;
                                }
                            default:
                                break;
                        }
                    }
                    else {
                        return new ReturningValue (true ,Parameters, value)  ;
                    }
                }
            }
        }
        else {
            return new ReturningValue (true ,Parameters, value)  ;
        }
        return new ReturningValue (true,Parameters, value)  ;
    }
}
