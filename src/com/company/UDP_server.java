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

            int colorAsInteger = Integer.parseInt(ColorReturn, 16); // convert the Hex value to int
            byte colorByte = (byte)colorAsInteger;
            byte R = (byte) (((colorByte & 0xF800) >>11)<<3); // keep only red bits
            byte G = (byte)(((colorByte & 0x7E0) >> 5) <<2); // keep only green bits
            byte B = (byte)((colorByte & 0x1F )<< 3); // keep only blue bits
            int red = (int)(R & 255);
            int green = (int)(G & 255);
            int blue = (int)(B & 255);
            System.out.println(red  + " " + green  + " " + blue );

            Color color = new Color(red,green,blue);
            switch (this.ParametersReturn[0]) {


                case 0:
                    g.setColor(color);
                    g.fillRect(0, 0, 600, 600);
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
     public static int[] convertRgb888To565(int[] rgb888) {
         int max;
         int[] rgb565;

         max = rgb888.length;
         rgb565 = new int[max];
         for (int i = 0; i < max; i++) {
             rgb565[i] = RGB565ToRGB888(rgb888[i]);
         }
         return rgb565;
     }
     int[] wordToRGB(byte[] word){
         int c = (word[0] << 8) | (word[1]);
         //RGB565
         int r = (c >> (6+5)) & 0x01F;
         int g = (c >> 5) & 0x03F;
         int b = (c) & 0x01F;
         //RGB888 - amplify
         r <<= 3;
         g <<= 2;
         b <<= 3;
         return new int[]{r,g,b};
     }
     byte[] colorToWord(int c){
         int r = (c >> 16) & 0xFF;
         int g = (c >> 8)  & 0xFF;
         int b =  c        & 0xFF;
         return new byte[]{(byte)((r&248)|g>>5),(byte)((g&28)<<3|b>>3)};
     }
     static int RGB565ToRGB888(int word) {
         /*final int RGB565_MASK_RED       = 0xF800;
         final int RGB565_MASK_GREEN     = 0x07E0;
         final int RGB565_MASK_BLUE      = 0x001F;

             int[] rgb24 = new int[3];
             rgb24[2] = (int)(word & RGB565_MASK_RED) >> 8;
             rgb24[1] =(int) (word & RGB565_MASK_GREEN) >> 3;
             rgb24[0] = (int)(word & RGB565_MASK_BLUE) << 3;
             return rgb24;*/
         return ((word & 0xf80000) << 8) | ((word & 0xfc00) << 5) | ((word & 0xf8) << 3);
     }
    public void Clear (Graphics g, Color color)
     {

         g.setColor (color);
         g.clearRect(0,0,600,600);
     }

    public void drawPixel (Graphics g, Color color)
    {
        //g.clearRect(0,0,600,600);
        g.setColor(color);
        g.drawOval (ParametersReturn[1],ParametersReturn[2],1,1);
    }
    public void drawLine (Graphics g, Color color)
    {
        //g.clearRect(0,0,600,600);
        g.setColor(color);
        g.drawLine (ParametersReturn[1],ParametersReturn[2],ParametersReturn[3],ParametersReturn[4] );
    }
    public void drawRectangle (Graphics g, Color color)
    {
        ///g.clearRect(0,0,600,600);
        g.setColor(color);
        g.drawRect (ParametersReturn[1],ParametersReturn[2],ParametersReturn[3],ParametersReturn[4] );
    }
    public void fillRectangle (Graphics g, Color color)
    {
        //g.clearRect(0,0,600,600);
        g.setColor(color);
        g.fillRect (ParametersReturn[1],ParametersReturn[2],ParametersReturn[3],ParametersReturn[4]);
    }
    public void drawEllipse (Graphics g, Color color)
    {
        //g.clearRect(0,0,600,600);
        g.setColor(color);
        g.drawOval (ParametersReturn[1],ParametersReturn[2],ParametersReturn[3],ParametersReturn[4] );
    }
    public void fillEllipse (Graphics g, Color color)
    {
        //g.clearRect(0,0,600,600);
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

