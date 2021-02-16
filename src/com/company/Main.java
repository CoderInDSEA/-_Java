package com.company;


import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        ReturningValue returnValueMethod = new ReturningValue();
        Scanner input = new Scanner(System.in);
        String command_copy ;
        char [] command_out ;
        System.out.println("Enter command : " );
        command_copy = input.nextLine();
        char [] command = new char[command_copy.length()];
        for (int i = 0; i < command_copy.length(); i++){
            command[i] = command_copy.charAt(i);
        }
         returnValueMethod.CommandIdentifier(command);

        System.out.println(command_copy);
        System.out.println("Error in algorithm = " + returnValueMethod.fail);
        System.out.println(returnValueMethod.value);
        System.out.println(Arrays.toString(returnValueMethod.Parameters));

    }
}