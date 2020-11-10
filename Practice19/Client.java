package com.company.Practice19;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name");
        String Name = in.nextLine();
        System.out.println("For exit enter /exit");
        while (true) {
            String message = in.nextLine();
            String s;
            if (message.equals("/exit"))
            {
                s = "exit";
                sendMessage(s,"25.34.229.206", 9087);
                break;
            }
            else s = Name + ": " + message;
            sendMessage(s,"25.34.229.206", 9087);
        }
    }

    public static void sendMessage(
            String message,
            String address,
            int port) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        byte[] data = message.getBytes();
        DatagramPacket packet = new DatagramPacket(
                data,
                0, data.length,
                InetAddress.getByName(address),
                port
        );
        socket.send(packet);
    }
}
