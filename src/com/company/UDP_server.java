package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.*;
import java.util.Scanner;
import java.lang.String;

public class UDP_server {
    public final static int SERVICE_PORT = 50001;

    public static void ServerUDP() throws IOException {
        try {
            CommandParser commandParser = new CommandParser();
            // Create a new DatagramSocket instance to receive responses from the client
            DatagramSocket serverSocket = new DatagramSocket(SERVICE_PORT);
            Scanner input = new Scanner(System.in);
      /* Create buffers to store data sent and received.
       They temporarily store data in case of communication delays */
            byte[] receivingDataBuffer = new byte[1024];
            byte[] sendingDataBuffer = new byte[1024];

            // Instantiate a UDP packet to store client data using a buffer for received data
            DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
            System.out.println("Waiting for a client to connect...");

            // Get the data from the client and store it in the inputPacket
            serverSocket.receive(inputPacket);

            String receivedData = new String(inputPacket.getData());
            char [] command = new char[receivedData.length()];
            for (int i = 0; i < receivedData.length(); i++){
                command[i] = receivedData.charAt(i);
            }
            commandParser.CommandIdentifier(command);
            System.out.println("Error in algorithm = " + commandParser.ErrorCommand);
            System.out.println(commandParser.ColorReturn);
            System.out.println(Arrays.toString(commandParser.ParametersReturn));
            System.out.println("Sent from the client: " + receivedData);

            /*
             * Convert the data sent by the client to uppercase,
             * Convert them to bytes
             * and save to the appropriate buffer. */
            sendingDataBuffer = receivedData.toUpperCase().getBytes();

            //Get the client's IP address and port
            InetAddress senderAddress = inputPacket.getAddress();
            int senderPort = inputPacket.getPort();

            // Create a new UDP data packet to send to the client
            DatagramPacket outputPacket = new DatagramPacket(
                    sendingDataBuffer, sendingDataBuffer.length,
                    senderAddress, senderPort
            );

            // Send the package to the client
            serverSocket.send(outputPacket);
            // Close the socket connection
            serverSocket.close();
        } catch (
                SocketException e) {
            e.printStackTrace();
        }
    }
}
