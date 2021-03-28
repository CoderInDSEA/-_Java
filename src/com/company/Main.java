package com.company;


import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) throws IOException {
        CommandParser returnParametersMethod = new CommandParser();
        UDP_server udpServer = new UDP_server();
        GUI gui = new GUI();
        gui.setVisible(true);
        int[] Parameters;
        String ColorString;
        int redMask   = 0b1111100000000000;
        int greenMask = 0b0000011111100000;
        int blueMask  = 0b0000000000011111;

        String color1 = "0xFFE0";
        int colorAsInteger = Integer.parseInt(color1.substring(2,color1.length()), 16); // convert the Hex value to int

        int R1 = (colorAsInteger & redMask) >> 11; // keep only red bits
        int G1 = (colorAsInteger & greenMask) >> 5; // keep only green bits
        int B1 = colorAsInteger & blueMask; // keep only blue bits

        System.out.println(R1 + " " + G1 + " " + B1);
        boolean Why = true;
        while (Why) {

            gui.DrawComponent();
            Parameters = gui.SetPar();
            ColorString = gui.SetColor();
            //String colorFull = "0x" + ColorString;
            //byte[] byteArrray = colorFull.getBytes();
            //int  [] ColorRGB888 = GUI.RGB565ToRGB888(byteArrray);

            int ColorRGB565 =  Integer.parseInt(ColorString.substring(0,ColorString.length()), 16);

            //
           // int R = (ColorRGB565 & redMask) >> 11; // keep only red bits
            //int G = (ColorRGB565 & greenMask) >> 5; // keep only green bits
            //int B = ColorRGB565 & blueMask; // keep only blue bits
            int R = (ColorRGB565 & redMask) >> 11; // keep only red bits
            int G = (ColorRGB565 & greenMask) >> 5; // keep only green bits
            int B = ColorRGB565 & blueMask; // keep only blue bits
            Color color = new Color (R,G,B);
            System.out.println(R + " " + G + " " + B);
            switch (Parameters[0]) {
                case 0:
                    gui.Clear(gui.getGraphics(),color);
                    break;
                case 1:
                    gui.drawPixel(gui.getGraphics(),color);
                    break;
                case 2:
                    gui.drawLine(gui.getGraphics(),color);
                    break;
                case 3:
                    gui.drawRectangle(gui.getGraphics(),color);
                    break;
                case 4:
                    gui.fillRectangle(gui.getGraphics(),color);
                    break;
                case 5:
                    gui.drawEllipse(gui.getGraphics(),color);
                    break;
                case 6:
                    gui.fillEllipse(gui.getGraphics(),color);
                    break;
                default:
                    System.out.println("Fail command");
                    Why = false;
                    break;
            }
            //udpServer.ServerUDP();

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

}
