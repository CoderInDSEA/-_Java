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
        char [] message ;
        int redMask   = 0b1111100000000000;
        int greenMask = 0b0000011111100000;
        int blueMask  = 0b0000000000011111;

        boolean Why = true;
        while (Why) {
            gui.DrawComponent();
            Parameters = gui.SetPar();
            ColorString = gui.SetColor();
            message = gui.SetMessage();
            int colorAsInteger = Integer.parseInt(ColorString, 16); // convert the Hex value to int
            byte colorByte = (byte)colorAsInteger;
            byte R = (byte) (((colorByte & 0xF800) >>11)<<3); // keep only red bits
            byte G = (byte)(((colorByte & 0x7E0) >> 5) <<2); // keep only green bits
            byte B = (byte)((colorByte & 0x1F )<< 3); // keep only blue bits
            int r = (int)(R & 255);
            int g = (int)(G & 255);
            int b = (int)(B & 255);
            System.out.println(r  + " " + g  + " " + b );

            Color color = new Color(r,g,b);

            switch (Parameters[0]) {
                case 0:
                    gui.Clear(gui.getGraphics(), color);
                    break;
                case 1:
                    gui.drawPixel(gui.getGraphics(), color);
                    break;
                case 2:
                    gui.drawLine(gui.getGraphics(), color);
                    break;
                case 3:
                    gui.drawRectangle(gui.getGraphics(), color);
                    break;
                case 4:
                    gui.fillRectangle(gui.getGraphics(), color);
                    break;
                case 5:
                    gui.drawEllipse(gui.getGraphics(), color);
                    break;
                case 6:
                    gui.fillEllipse(gui.getGraphics(), color);
                    break;
                case 7:
                    gui.drawChars(gui.getGraphics(), color, message);
                    break;
                default:
                    System.out.println("Fail command");
                    Why = false;
                    break;
            }
        }
    }

}
