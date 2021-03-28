package com.company;

import java.util.Arrays;

public class CommandParser {
    boolean ErrorCommand;
    public int[] ParametersReturn = {0};
    public String ColorReturn;

    private CommandParser(boolean fail, int[] Parameters, String ColorReturn) {
        this.ErrorCommand = fail;
        this.ParametersReturn = Parameters;
        this.ColorReturn = ColorReturn;
    }

    CommandParser() {

    }

    public boolean RetBoolean(char[] command) {
        boolean fail;
        CommandIdentifier(command);
        fail = this.ErrorCommand;
        return fail;
    }

    public int[] RetParameters(char[] command) {
        int[] Parameters;
        CommandIdentifier(command);
        Parameters = ParametersReturn.clone();
        return Parameters;
    }

    public String RetColor(char[] command) {
        String ColorReturn;
        CommandIdentifier(command);
        ColorReturn = this.ColorReturn;
        return ColorReturn;
    }

    boolean  CharacterCheck(char[] command) {
        char[] characterCheck = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', '#', '_', '@', '\u0000'};
        int failChecker = 0, iterationCounter = 0;
        for (int counterCheckCommand = 0; counterCheckCommand < command.length; counterCheckCommand++) {
            failChecker=0;
            for (int counterChecker = 0; counterChecker < characterCheck.length; counterChecker++) {
                if (command[counterCheckCommand] == characterCheck[counterChecker]) {
                    failChecker++;
                    break;
                }

            }
            if (failChecker == 0) {
                return true;
            }
        }
        return false ;
    }


    CommandParser CommandIdentifier (char [] command ) {

        //Separators
        char startString = '#';
        char endString = '@';
        char delimiterString = '_';

        //Command component
        char[] firstParCommand = {'0', '1', '2', '3', '4', '5', '6'};
        char[] CheckParameters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] limitationChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};


        //Command helper
        char first_Cmd;
        char[] color = {' '};
        String parameterColor = "",
                parameterX = "", parameterY = "",
                parameterX1 = "", parameterY1 = "",
                parameterW = "", parameterH = "",
                parameterRadX = "", parameterRadY = "";
        int counterCommand = 0, // counter for full command
                counterLimitation = 0,
                counterCmd = 0,
                CounterFailColor = 0,
                counterIndexParameters = 0,
                countParameters = 1,
                startParameter;
        boolean FailChecker = false;


        //Size Array
        color = new char[4];

        //Character Check
        FailChecker = CharacterCheck(command);
        if (FailChecker == true) {
            System.out.println(String.format("You made a mistake in the command"));
            ErrorCommand = true;
            return new CommandParser(ErrorCommand, ParametersReturn, ColorReturn);
        } else {
            //Algorithm
            if (command[counterCommand] == startString) {
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

                                    for (int CopyColor = counterCommand; CopyColor < command.length; CopyColor++) {
                                        if (command[CopyColor] == endString) {
                                            counterCommand++;
                                            break;
                                        }
                                        color[counterCmd] = command[CopyColor];
                                        counterCmd++;
                                        counterCommand++;

                                    }
                                    //Limitation of color text and Outputting the parsed command to the screen
                                    for (int CountToCount = 0; CountToCount < 4; ++CountToCount) {
                                        for (int CountLimit = 0; CountLimit <= limitationChar.length; CountLimit++) {
                                            if (color[CountToCount] == limitationChar[CountLimit]) {
                                                counterLimitation++;
                                                if (counterLimitation >= 4) {
                                                    parameterColor = String.valueOf(color);
                                                    ErrorCommand = false;
                                                    ParametersReturn = new int[countParameters];
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(String.valueOf(first_Cmd));
                                                    ColorReturn = String.valueOf(color);
                                                    System.out.println((String.format("Draw pixel - color - %s", parameterColor)));
                                                    return new CommandParser(ErrorCommand, ParametersReturn, ColorReturn);
                                                } else {
                                                    break;
                                                }
                                            } else {
                                                CounterFailColor++;
                                            }
                                            if (CounterFailColor == limitationChar.length) {
                                                return new CommandParser(true, ParametersReturn, ColorReturn);
                                            }
                                        }
                                        CounterFailColor = 0;
                                    }
                                    //DrawPixel
                                case '1':
                                    //Copy first Parameter
                                    startParameter = counterCommand;
                                    for (int counterFirstPar = counterCommand; counterFirstPar < command.length; counterFirstPar++) {
                                        if (command[counterFirstPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterX = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    //Copy second Parameter
                                    startParameter = counterCommand;
                                    for (int counterSecondPar = counterCommand; counterSecondPar < command.length; counterSecondPar++) {
                                        if (command[counterSecondPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterY = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    //Copy Color
                                    for (int CopyColor = counterCommand; CopyColor < command.length; CopyColor++) {
                                        if (command[CopyColor] == endString) {
                                            counterCommand++;
                                            break;
                                        }
                                        color[counterCmd] = command[CopyColor];
                                        counterCmd++;
                                        counterCommand++;

                                    }
                                    //Limitation of color text and Outputting the parsed command to the screen
                                    for (int CountToCount = 0; CountToCount < 4; ++CountToCount) {
                                        for (int CountLimit = 0; CountLimit <= limitationChar.length; CountLimit++) {
                                            if (color[CountToCount] == limitationChar[CountLimit]) {
                                                counterLimitation++;
                                                if (counterLimitation >= 4) {
                                                    parameterColor = String.valueOf(color);
                                                    ErrorCommand = false;
                                                    ParametersReturn = new int[countParameters];
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(String.valueOf(first_Cmd));
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterX);
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterY);
                                                    ColorReturn = String.valueOf(color);
                                                    System.out.println((String.format("Draw pixel - first parameter - %s ," +
                                                            " second parameter - %s , color - %s", parameterX, parameterY, parameterColor)));
                                                    return new CommandParser(ErrorCommand, ParametersReturn, ColorReturn);
                                                } else {
                                                    break;
                                                }
                                            } else {
                                                CounterFailColor++;
                                            }
                                            if (CounterFailColor == limitationChar.length) {
                                                return new CommandParser(true, ParametersReturn, ColorReturn);
                                            }
                                        }
                                        CounterFailColor = 0;
                                    }
                                    //Draw line
                                case '2':
                                    //Copy first Parameter
                                    startParameter = counterCommand;
                                    for (int counterFirstPar = counterCommand; counterFirstPar < command.length; counterFirstPar++) {
                                        if (command[counterFirstPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterX = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                        startParameter = counterCommand;
                                    }
                                    //Copy second Parameter
                                    for (int counterSecondPar = counterCommand; counterSecondPar < command.length; counterSecondPar++) {
                                        if (command[counterSecondPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterY = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                        startParameter = counterCommand;
                                    }
                                    //Copy third Parameter
                                    for (int counterThirdPar = counterCommand; counterThirdPar < command.length; counterThirdPar++) {
                                        if (command[counterThirdPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterX1 = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                        startParameter = counterCommand;
                                    }
                                    //Copy fourth Parameter
                                    for (int counterFourthPar = counterCommand; counterFourthPar < command.length; counterFourthPar++) {
                                        if (command[counterFourthPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterY1 = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    //Copy Color
                                    for (int CopyColor = counterCommand; CopyColor < command.length; CopyColor++) {
                                        if (command[CopyColor] == endString) {
                                            counterCommand++;
                                            break;
                                        }
                                        color[counterCmd] = command[CopyColor];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    //Limitation of color text and Outputting the parsed command to the screen
                                    for (int CountToCount = 0; CountToCount < 4; ++CountToCount) {
                                        for (int CountLimit = 0; CountLimit <= limitationChar.length; CountLimit++) {
                                            if (color[CountToCount] == limitationChar[CountLimit]) {
                                                counterLimitation++;
                                                if (counterLimitation >= 4) {
                                                    parameterColor = String.valueOf(color);
                                                    ErrorCommand = false;
                                                    ParametersReturn = new int[countParameters];
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(String.valueOf(first_Cmd));
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterX);
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterY);
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterX1);
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterY1);
                                                    ColorReturn = String.valueOf(color);
                                                    System.out.println((String.format("Draw line - first parameter X - %s , " +
                                                            "second parameter Y - %s , " +
                                                            "third parameter X1 - %s , " +
                                                            "fourth parameter Y1 - %s , " +
                                                            "color - %s", parameterX, parameterY, parameterX1, parameterY1, parameterColor)));
                                                    return new CommandParser(ErrorCommand, ParametersReturn, ColorReturn);
                                                } else {
                                                    break;
                                                }
                                            } else {
                                                CounterFailColor++;
                                            }
                                            if (CounterFailColor == limitationChar.length) {
                                                return new CommandParser(true, ParametersReturn, ColorReturn);
                                            }
                                        }
                                        CounterFailColor = 0;
                                    }
                                    //Draw Rectangle
                                case '3':
                                    startParameter = counterCommand;
                                    for (int counterFirstPar = counterCommand; counterFirstPar < command.length; counterFirstPar++) {
                                        if (command[counterFirstPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterX = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                        startParameter = counterCommand;
                                    }
                                    for (int counterSecondPar = counterCommand; counterSecondPar < command.length; counterSecondPar++) {
                                        if (command[counterSecondPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterY = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                        startParameter = counterCommand;
                                    }
                                    for (int counterThirdPar = counterCommand; counterThirdPar < command.length; counterThirdPar++) {
                                        if (command[counterThirdPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterW = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                        startParameter = counterCommand;
                                    }
                                    for (int counterFourthPar = counterCommand; counterFourthPar < command.length; counterFourthPar++) {
                                        if (command[counterFourthPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterH = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int CopyColor = counterCommand; CopyColor < command.length; CopyColor++) {
                                        if (command[CopyColor] == endString) {
                                            counterCommand++;
                                            break;
                                        }
                                        color[counterCmd] = command[CopyColor];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    for (int CountToCount = 0; CountToCount < 4; ++CountToCount) {
                                        for (int CountLimit = 0; CountLimit <= limitationChar.length; CountLimit++) {
                                            if (color[CountToCount] == limitationChar[CountLimit]) {
                                                counterLimitation++;
                                                if (counterLimitation >= 4) {
                                                    parameterColor = String.valueOf(color);
                                                    ErrorCommand = false;
                                                    ParametersReturn = new int[countParameters];
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(String.valueOf(first_Cmd));
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterX);
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterY);
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterW);
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterH);
                                                    ColorReturn = String.valueOf(color);
                                                    System.out.println((String.format("Draw Rectangle - first parameter X - %s , " +
                                                            "second parameter Y - %s , " +
                                                            "third parameter W - %s , " +
                                                            "fourth parameter H - %s , " +
                                                            "color - %s", parameterX, parameterY, parameterW, parameterH, parameterColor)));
                                                    return new CommandParser(ErrorCommand, ParametersReturn, ColorReturn);
                                                } else {
                                                    break;
                                                }
                                            } else {
                                                CounterFailColor++;
                                            }
                                            if (CounterFailColor == limitationChar.length) {
                                                return new CommandParser(true, ParametersReturn, ColorReturn);
                                            }
                                        }
                                        CounterFailColor = 0;
                                    }
                                    //Fill Rectangle
                                case '4':
                                    startParameter = counterCommand;
                                    for (int counterFirstPar = counterCommand; counterFirstPar < command.length; counterFirstPar++) {
                                        if (command[counterFirstPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterX = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                        startParameter = counterCommand;
                                    }
                                    for (int counterSecondPar = counterCommand; counterSecondPar < command.length; counterSecondPar++) {
                                        if (command[counterSecondPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterY = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                        startParameter = counterCommand;
                                    }
                                    for (int counterThirdPar = counterCommand; counterThirdPar < command.length; counterThirdPar++) {
                                        if (command[counterThirdPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterW = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                        startParameter = counterCommand;
                                    }
                                    for (int counterFourthPar = counterCommand; counterFourthPar < command.length; counterFourthPar++) {
                                        if (command[counterFourthPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterH = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int CopyColor = counterCommand; CopyColor < command.length; CopyColor++) {
                                        if (command[CopyColor] == endString) {
                                            counterCommand++;
                                            break;
                                        }
                                        color[counterCmd] = command[CopyColor];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    for (int CountToCount = 0; CountToCount < 4; ++CountToCount) {
                                        for (int CountLimit = 0; CountLimit <= limitationChar.length; CountLimit++) {
                                            if (color[CountToCount] == limitationChar[CountLimit]) {
                                                counterLimitation++;
                                                if (counterLimitation >= 4) {
                                                    parameterColor = String.valueOf(color);
                                                    ErrorCommand = false;
                                                    ParametersReturn = new int[countParameters];
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(String.valueOf(first_Cmd));
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterX);
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterY);
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterW);
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterH);
                                                    ColorReturn = String.valueOf(color);
                                                    System.out.println((String.format("Fill Rectangle - first parameter X - %s , " +
                                                            "second parameter Y - %s , " +
                                                            "third parameter W - %s , " +
                                                            "fourth parameter H - %s , " +
                                                            "color - %s", parameterX, parameterY, parameterW, parameterH, parameterColor)));
                                                    return new CommandParser(ErrorCommand, ParametersReturn, ColorReturn);
                                                } else {
                                                    break;
                                                }
                                            } else {
                                                CounterFailColor++;
                                            }
                                            if (CounterFailColor == limitationChar.length) {
                                                return new CommandParser(true, ParametersReturn, ColorReturn);
                                            }
                                        }
                                        CounterFailColor = 0;
                                    }
                                    //Draw Ellipse
                                case '5':
                                    startParameter = counterCommand;
                                    for (int counterFirstPar = counterCommand; counterFirstPar < command.length; counterFirstPar++) {
                                        if (command[counterFirstPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterX = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;

                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                        startParameter = counterCommand;
                                    }
                                    for (int counterSecondPar = counterCommand; counterSecondPar < command.length; counterSecondPar++) {
                                        if (command[counterSecondPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterY = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                        startParameter = counterCommand;
                                    }
                                    for (int counterThirdPar = counterCommand; counterThirdPar < command.length; counterThirdPar++) {
                                        if (command[counterThirdPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterRadX = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                        startParameter = counterCommand;
                                    }
                                    for (int counterFourthPar = counterCommand; counterFourthPar < command.length; counterFourthPar++) {
                                        if (command[counterFourthPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterRadY = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int CopyColor = counterCommand; CopyColor < command.length; CopyColor++) {
                                        if (command[CopyColor] == endString) {
                                            counterCommand++;
                                            break;
                                        }
                                        color[counterCmd] = command[CopyColor];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    for (int CountToCount = 0; CountToCount < 4; ++CountToCount) {
                                        for (int CountLimit = 0; CountLimit <= limitationChar.length; CountLimit++) {
                                            if (color[CountToCount] == limitationChar[CountLimit]) {
                                                counterLimitation++;
                                                if (counterLimitation >= 4) {
                                                    parameterColor = String.valueOf(color);
                                                    ErrorCommand = false;
                                                    ParametersReturn = new int[countParameters];
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(String.valueOf(first_Cmd));
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterX);
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterY);
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterRadX);
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterRadY);
                                                    ColorReturn = String.valueOf(color);
                                                    System.out.println((String.format("Draw Ellipse - first parameter X - %s , " +
                                                            "second parameter Y - %s , " +
                                                            "third parameter Radius X - %s , " +
                                                            "fourth parameter Radius Y  - %s , " +
                                                            "color - %s", parameterX, parameterY, parameterRadX, parameterRadY, parameterColor)));
                                                    return new CommandParser(ErrorCommand, ParametersReturn, ColorReturn);
                                                } else {
                                                    break;
                                                }
                                            } else {
                                                CounterFailColor++;
                                            }
                                            if (CounterFailColor == limitationChar.length) {
                                                return new CommandParser(true, ParametersReturn, ColorReturn);
                                            }
                                        }
                                        CounterFailColor = 0;
                                    }
                                    //Fill Ellipse
                                case '6':
                                    startParameter = counterCommand;
                                    for (int counterFirstPar = counterCommand; counterFirstPar < command.length; counterFirstPar++) {
                                        if (command[counterFirstPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterX = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                        startParameter = counterCommand;
                                    }
                                    for (int counterSecondPar = counterCommand; counterSecondPar < command.length; counterSecondPar++) {
                                        if (command[counterSecondPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterY = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                        startParameter = counterCommand;
                                    }
                                    for (int counterThirdPar = counterCommand; counterThirdPar < command.length; counterThirdPar++) {
                                        if (command[counterThirdPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterRadX = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                        startParameter = counterCommand;
                                    }
                                    for (int counterFourthPar = counterCommand; counterFourthPar < command.length; counterFourthPar++) {
                                        if (command[counterFourthPar] == delimiterString) {
                                            counterCommand++;
                                            countParameters++;
                                            parameterRadY = String.valueOf(command, startParameter, counterCmd);
                                            break;
                                        }
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    if (counterCmd >= 2) {
                                        counterCmd = 0;
                                    }
                                    for (int CopyColor = counterCommand; CopyColor < command.length; CopyColor++) {
                                        if (command[CopyColor] == endString) {
                                            counterCommand++;
                                            break;
                                        }
                                        color[counterCmd] = command[CopyColor];
                                        counterCmd++;
                                        counterCommand++;
                                    }
                                    for (int CountToCount = 0; CountToCount < 4; ++CountToCount) {
                                        for (int CountLimit = 0; CountLimit <= limitationChar.length; CountLimit++) {
                                            if (color[CountToCount] == limitationChar[CountLimit]) {
                                                counterLimitation++;
                                                if (counterLimitation >= 4) {
                                                    parameterColor = String.valueOf(color);
                                                    ErrorCommand = false;
                                                    ParametersReturn = new int[countParameters];
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(String.valueOf(first_Cmd));
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterX);
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterY);
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterRadX);
                                                    counterIndexParameters++;
                                                    ParametersReturn[counterIndexParameters] = Integer.parseInt(parameterRadY);
                                                    ColorReturn = String.valueOf(color);
                                                    System.out.println((String.format("Fill Ellipse - first parameter X - %s , " +
                                                            "second parameter Y - %s , " +
                                                            "third parameter Radius X - %s , " +
                                                            "fourth parameter Radius Y  - %s , " +
                                                            "color - %s", parameterX, parameterY, parameterRadX, parameterRadY, parameterColor)));
                                                    return new CommandParser(ErrorCommand, ParametersReturn, ColorReturn);
                                                } else {
                                                    break;
                                                }
                                            } else {
                                                CounterFailColor++;
                                            }
                                            if (CounterFailColor == limitationChar.length) {
                                                return new CommandParser(true, ParametersReturn, ColorReturn);
                                            }
                                        }
                                        CounterFailColor = 0;
                                    }
                                default:
                                    break;
                            }
                        } else {
                            return new CommandParser(true, ParametersReturn, ColorReturn);
                        }
                    }
                }
            } else {
                return new CommandParser(true, ParametersReturn, ColorReturn);
            }
            return new CommandParser(true, ParametersReturn, ColorReturn);
        }
    }
}
