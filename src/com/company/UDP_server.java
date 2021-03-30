package com.company;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.*;
import java.lang.String;
 class GUI extends JFrame {
    private int[] ParametersReturn = {0};
     private JFrame frame;
    private String ColorReturn;
    private boolean Fail;
    char [] command, message;
    public int [] SetPar() {
        return ParametersReturn;
    }
     public String SetColor() {
         return ColorReturn;
     }
     public  char[] SetMessage() { return message;}
    public void DrawComponent () throws IOException {
        UDP_server udpServer = new UDP_server();
        CommandParser commandParser = new CommandParser();
        command = udpServer.ServerUDP();
        ParametersReturn = commandParser.RetParameters(command);
        ColorReturn = commandParser.RetColor(command);
        Fail= commandParser.RetBoolean(command);
        message = commandParser.RetMessage(command);
        System.out.println("Error in algorithm = " + Fail);
        System.out.println(ColorReturn);
        System.out.println(Arrays.toString(ParametersReturn));
        System.out.println(message);
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
                case 7:
                    g.setColor(color);
                    //g.fillOval(ParametersReturn[1], ParametersReturn[2], ParametersReturn[3], ParametersReturn[4]);
                    g.drawChars (message,ParametersReturn[3],1,ParametersReturn[1],ParametersReturn[2]);
                    break;
                default:
                    g.setColor(color);
                    System.out.println("Please back to client");
                    break;
            }
        }

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
     public void drawChars (Graphics g, Color color, char [] message)
     {
         g.setColor(color);
         g.drawChars (message,ParametersReturn[3], message.length, ParametersReturn[1],ParametersReturn[2]);
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

