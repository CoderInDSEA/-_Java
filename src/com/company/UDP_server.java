package com.company;
import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.http.WebSocket;
import java.util.*;
import java.lang.String;
import java.util.List;
import javax.swing.event.ChangeListener;
 class GUI extends JFrame {
    private int[] ParametersReturn = {0};
     private JFrame frame;
    private String ColorReturn;
    private boolean Fail;
    char [] command;
    public int [] SetPar() {
        return ParametersReturn;
    }
     public String SetColor() {
         return ColorReturn;
     }
    public void DrawComponent () throws IOException {
        UDP_server udpServer = new UDP_server();
        CommandParser commandParser = new CommandParser();
        command = udpServer.ServerUDP();
        ParametersReturn = commandParser.RetParameters(command);
        ColorReturn = commandParser.RetColor(command);
        Fail= commandParser.RetBoolean(command);
        System.out.println("Error in algorithm = " + Fail);
        System.out.println(ColorReturn);
        System.out.println(Arrays.toString(ParametersReturn));
    }
    public GUI()  throws IOException {
        frame = new JFrame("Frame Display Test");
        setSize(600, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }
    public void paint(Graphics g) {
        if (ColorReturn != null) {

            int redMask   = 0b1111100000000000;
            int greenMask = 0b0000011111100000;
            int blueMask  = 0b0000000000011111;
            String colorFull = "0x" + ColorReturn;
            //byte[] byteArrray = colorFull.getBytes();
            //int  [] ColorRGB888 = GUI.RGB565ToRGB888(byteArrray);
            int ColorRGB565 =  Integer.parseInt(ColorReturn.substring(0,ColorReturn.length()), 16);
            int ColorRGB888 = RGB565ToRGB888(ColorRGB565);
            Color color = new Color (ColorRGB888);
            /*
            //RGB565
            int R = (ColorRGB565 & redMask) >> 11; // keep only red bits
            int G = (ColorRGB565 & greenMask) >> 5; // keep only green bits
            int B = ColorRGB565 & blueMask; // keep only blue bits
            Color color = new Color (R,G,B);*/
            //int ColorRGB565 =  Integer.parseInt(ColorBuffer.substring(2,ColorBuffer.length()), 16);

            //
            // int R = (ColorRGB565 & redMask) >> 11; // keep only red bits
            //int G = (ColorRGB565 & greenMask) >> 5; // keep only green bits
            //int B = ColorRGB565 & blueMask; // keep only blue bits
           // Color color = new Color(ColorRGB888 [0], ColorRGB888 [1], ColorRGB888 [2]);
            switch (this.ParametersReturn[0]) {


                case 0:
                    g.setColor(color);
                    g.clearRect(0, 0, 600, 600);
                    break;
                case 1:
                    g.setColor(color);
                    g.drawOval(this.ParametersReturn[1], this.ParametersReturn[2], 1, 1);
                    break;
                case 2:
                    g.setColor(color);
                    g.drawLine(ParametersReturn[1], ParametersReturn[2], ParametersReturn[3], ParametersReturn[4]);
                    break;
                case 3:
                    g.setColor(color);
                    g.drawRect(ParametersReturn[1], ParametersReturn[2], ParametersReturn[3], ParametersReturn[4]);
                    break;
                case 4:
                    g.setColor(color);
                    g.fillRect(ParametersReturn[1], ParametersReturn[2], ParametersReturn[3], ParametersReturn[4]);
                    break;
                case 5:
                    g.setColor(color);
                    g.drawOval(ParametersReturn[1], ParametersReturn[2], ParametersReturn[3], ParametersReturn[4]);
                    break;
                case 6:
                    g.setColor(color);
                    g.fillOval(ParametersReturn[1], ParametersReturn[2], ParametersReturn[3], ParametersReturn[4]);
                    break;
                default:
                    g.setColor(color);
                    System.out.println("Please back to client");
                    break;
            }
        }

    }
     static int RGB565ToRGB888(int data) {
         final int b = (((data) & 0x001F) << 3) & 0xFF;
         final int g = (((data) & 0x07E0) >>> 3) & 0xFF;
         final int r = (((data) & 0xF800) >>> 8) & 0xFF;
         // return RGBA
         return 0x000000ff | (r << 24) | (g << 16) | (b << 8);
     }
    public void Clear (Graphics g, Color color)
     {

         g.setColor (color);
         g.clearRect(0,0,600,600);
     }

    public void drawPixel (Graphics g, Color color)
    {
        g.clearRect(0,0,600,600);
        g.setColor(color);
        g.drawOval (ParametersReturn[1],ParametersReturn[2],1,1);
    }
    public void drawLine (Graphics g, Color color)
    {
        g.clearRect(0,0,600,600);
        g.setColor(color);
        g.drawLine (ParametersReturn[1],ParametersReturn[2],ParametersReturn[3],ParametersReturn[4] );
    }
    public void drawRectangle (Graphics g, Color color)
    {
        g.clearRect(0,0,600,600);
        g.setColor(color);
        g.drawRect (ParametersReturn[1],ParametersReturn[2],ParametersReturn[3],ParametersReturn[4] );
    }
    public void fillRectangle (Graphics g, Color color)
    {
        g.clearRect(0,0,600,600);
        g.setColor(color);
        g.fillRect (ParametersReturn[1],ParametersReturn[2],ParametersReturn[3],ParametersReturn[4]);
    }
    public void drawEllipse (Graphics g, Color color)
    {
        g.clearRect(0,0,600,600);
        g.setColor(color);
        g.drawOval (ParametersReturn[1],ParametersReturn[2],ParametersReturn[3],ParametersReturn[4] );
    }
    public void fillEllipse (Graphics g, Color color)
    {
        g.clearRect(0,0,600,600);
        g.setColor(color);
        g.fillOval (ParametersReturn[1],ParametersReturn[2],ParametersReturn[3],ParametersReturn[4]);
    }
 }

public class UDP_server {
    //Port
    public final static int SERVICE_PORT = 50001;
    char [] Fail = {'f','a','i','l'};
    public  char [] ServerUDP() throws IOException {
        try {
            CommandParser commandParser = new CommandParser();
            DatagramSocket serverSocket = new DatagramSocket(SERVICE_PORT);
            byte[] receivingDataBuffer = new byte [1024];
            DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
            System.out.println("Waiting for a client to connect...");
            serverSocket.receive(inputPacket);
            String receivedData = new String(inputPacket.getData());
            for (int CounterByte = 0 ; CounterByte <= receivingDataBuffer.length ; CounterByte++) {
                if (Byte.toUnsignedInt(receivingDataBuffer[CounterByte])== 0 )
                    break;
            }
            String commandOld, commandNew, commandString ;
            char [] command = new char [receivedData.length()] ;
            char startString = '%' , endString = '@';
            for (int i = 0; i < receivedData.length(); i++){
                command[i] = receivedData.charAt(i);
                if (command[i]==endString) { break;}
            }
            commandString = String.valueOf(command) ;
            System.out.println("Sent from the client: " + receivedData);
            byte[] sendingDataBuffer = new byte[receivingDataBuffer.length];
            sendingDataBuffer = receivedData.toUpperCase().getBytes();
            InetAddress senderAddress = inputPacket.getAddress();
            int senderPort = inputPacket.getPort();
            DatagramPacket outputPacket = new DatagramPacket(
                    sendingDataBuffer, sendingDataBuffer.length,
                    senderAddress, senderPort
            );
            serverSocket.send(outputPacket);
            serverSocket.close();
            return command;
        } catch (
                SocketException e) {
            e.printStackTrace();
        }
        return Fail;
    }

}

