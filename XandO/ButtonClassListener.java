package com.company.XandO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ButtonClassListener implements ActionListener {
    private final JButton jButton;
    private int Number;
    private String str;

    public ButtonClassListener(JButton jButton, int Number, String str)
    {
        this.jButton = jButton;
        this.Number = Number;
        this.str = str;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (jButton.getText().equals("")) {
//            Font BigFontTR = new Font("TimesRoman", Font.BOLD, 64);
//            jButton.setFont(BigFontTR);
//            jButton.setText(jButton.getActionCommand());
            try {
                sendMessage(Number + str, "255.255.255.255", 9087);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
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
