package com.company.Ismail;

import java.io.IOException;
import java.net.*;
import java.util.Date;
import java.util.Scanner;

public class Client {
    static StringBuilder incomingMessages = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        DatagramSocket socket = new DatagramSocket();
        socket.send(new DatagramPacket(new byte[0], 0, InetAddress.getByName("255.255.255.255"), 9087));
        Thread write = new Thread(() ->
        {
            while(true)
            {
                StringBuilder messageBuilder = new StringBuilder();
                messageBuilder.append(new Date().toString() + " | " + username + ": ");
                String messageContent = new Scanner(System.in).nextLine();
                messageBuilder.append(messageContent);
                String message = messageBuilder.toString();
                byte[] data = message.getBytes();

                DatagramPacket packetToSend = null;
                try {
                    packetToSend = new DatagramPacket(
                            data,
                            0,
                            data.length, InetAddress.getByName("255.255.255.255"), 9087);
                    socket.send(packetToSend);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });

        Thread output = new Thread(() ->
        {

            byte[] data = new byte[2048];
            DatagramPacket packetToReceive = new DatagramPacket(
                    data,
                    0,
                    data.length
            );
            while(true)
            {
                try {
                    socket.receive(packetToReceive);
                    System.out.println(new String(packetToReceive.getData(), 0, packetToReceive.getLength()));
                    incomingMessages.append(new String(packetToReceive.getData(), 0, packetToReceive.getLength()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        write.start();
        output.start();
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
        byte[] buffer = new byte[2024];
        DatagramPacket packetToReceive = new DatagramPacket(
                buffer,
                0,
                buffer.length);
        socket.receive(packetToReceive);
        System.out.println(new String(packetToReceive.getData(), 0, packetToReceive.getLength()));
    }
}