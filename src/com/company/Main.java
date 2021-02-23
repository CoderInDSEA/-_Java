package com.company;


import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.lang.String;

public class Main {
    public static void main(String[] args) throws IOException {
        CommandParser returnParametersMethod = new CommandParser();
        UDP_server udpServer = new UDP_server();
        udpServer.ServerUDP();
        /*Scanner input = new Scanner(System.in);
        String command_copy ;
        char [] command_out ;
        System.out.println("Enter command : " );
        command_copy = input.nextLine();
        char [] command = new char[command_copy.length()];
        for (int i = 0; i < command_copy.length(); i++){
            command[i] = command_copy.charAt(i);
        }
        System.out.println("Enter command : " );
        receivedData = input.nextLine();
        returnParametersMethod.CommandIdentifier(command);

        System.out.println(command_copy);
        System.out.println("Error in algorithm = " + returnParametersMethod.ErrorCommand);
        System.out.println(returnParametersMethod.ColorReturn);
        System.out.println(Arrays.toString(returnParametersMethod.ParametersReturn));*/

    }
}