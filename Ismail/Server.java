package com.company.Ismail;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> ports = new ArrayList<>();
        DatagramSocket socket = new DatagramSocket(9087);
        byte[] buffer = new byte[2024];
        DatagramPacket packet = new DatagramPacket(
                buffer,
                0,
                buffer.length);
        System.out.println("listening on 9087");
        while (true) {
            socket.receive(packet);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("history.txt"), true)));
            writer.write(new String(packet.getData()));
            writer.close();
            System.out.println(packet.getAddress());
            System.out.println(packet.getPort());
            if(!ports.contains(packet.getPort()))
                ports.add(packet.getPort());
            String message = new String(buffer, 0, packet.getLength());
            System.out.println(message);
            for(int t: ports)
                sendMessage(message, "255.255.255.255", t);
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
