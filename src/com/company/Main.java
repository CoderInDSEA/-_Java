package com.company;


import java.util.*;
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
        //for (int i = 0 ; i < 2 ; i++) {
        System.out.println(command_copy);
        System.out.println(command);
        //}
        // input.close () ;
    }
    public static char [] CommandIdentifier (char [] command ) {
        char [] ReturnFail = {'G'} ;
        char [] ReturnFail1 = {'G','1'};
        char startString = '%';
        char endString = '@';
        char delimiterString = '_';
        char [] firstParCommand = {'0', '1', '2','3', '4', '5', '6'};
        char first_Cmd, second_Cmd, third_Cmd, color ;
        char [] limitation = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        char command_copy [] = {' '};
        char outline [] ;
        for (int copy = 0; copy < command.length; copy++) {
            command_copy[copy] = command[copy];
        }
        if (command[0] == '%') {

            for (int j = 0; j < firstParCommand.length; j++) {

                if (command[1] == firstParCommand[j]) {
                    first_Cmd = firstParCommand[j];
                    if (command[2] == delimiterString) {
                        switch (first_Cmd) {
                            case '0':
                                for (int length_c = 3; length_c < command.length; length_c++) {
                                    for (int symbols = 0 ; symbols < limitation[0] ; symbols++ )
                                        if (command_copy[length_c] == limitation[symbols] ) {
                                            //System.out.println((String.format("Clear - %s , Color - %s", first_Cmd, color)));

                                            //outline[0] = first_Cmd;
                                            //outline[1]= color;

                                            //return outline;
                                        } else {
                                            break;
                                        }
                                }
                                break;
                            default :
                                break;
                                /*case 1:
                                 for (int ) {
                                 }
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:*/
                        }
                    }
                    else {

                        return ReturnFail1;
                    }


                }

            }

        }
        else {

            return ReturnFail1;
        }
        return ReturnFail;
    }
}