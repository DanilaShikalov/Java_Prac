package com.company.Practice19;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
    public static void main(String[] args) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Path path = Paths.get("").toAbsolutePath();
        FileWriter writer = new FileWriter(path + "\\src\\com\\company\\Practice19\\history.txt");
        DatagramSocket socket = new DatagramSocket(9087);
        byte[] buffer = new byte[2024];
        DatagramPacket packet = new DatagramPacket(
                buffer,
                0,
                buffer.length);
        System.out.println("THE BEST CHAT IN THE WORLD");
        while (true) {
            socket.receive(packet);
            Date date = new Date();
            String message = new String(buffer, 0, packet.getLength());
            if (message.equals("exit"))
            {
                System.out.println("Конец чата, запись истории...");
                break;
            }
            System.out.println(dateFormat.format(date) + " | " + message);
            writer.write(dateFormat.format(date) + " | " + message);
            writer.append('\n');
            writer.flush();
        }
    }
}
