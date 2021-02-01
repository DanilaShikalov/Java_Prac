package com.company.XandO;

import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

public class XandOs {
    public static void main(String[] args) throws SocketException {
        JFrame jFrame = new JFrame("Крестики и нолики");
        jFrame.setVisible(true);
        jFrame.setResizable(true);
        jFrame.setSize(500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(3,3));
        String str = "X";
        JButton[] arrayButton = new JButton[9];
        for (int i = 0; i < arrayButton.length; i++)
        {
            arrayButton[i] = new JButton("");
            arrayButton[i].setActionCommand("X");
            ButtonClassListener buttonClassListener = new ButtonClassListener(arrayButton[i], i, "X");
            arrayButton[i].addActionListener(buttonClassListener);
            jPanel.add(arrayButton[i]);
        }
        jFrame.add(jPanel);
        DatagramSocket socket = new DatagramSocket(9087);
        byte[] buffer = new byte[2024];
        DatagramPacket packet = new DatagramPacket(
                buffer,
                0,
                buffer.length);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        socket.receive(packet);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String message = new String(buffer, 0, packet.getLength());
                    int number = Integer.parseInt(message.substring(0,1));
                    String symbol = message.substring(1,2);
                    //arrayButton[number].setText(symbol);
                    Font BigFontTR = new Font("TimesRoman", Font.BOLD, 64);
                    arrayButton[number].setFont(BigFontTR);
                    arrayButton[number].setText(symbol);
                }
            }
        });
        thread.start();
        for (;;)
        {
            int q = 0;
//            for (int i = 0; i < arrayButton.length; i++)
//            {
//                if (!arrayButton[i].getText().equals(""))
//                {
//                    q++;
//                }
//            }
//            if(q % 2 == 1)
//            {
//                for (int i = 0; i < arrayButton.length; i++)
//                {
//                    arrayButton[i].setActionCommand("O");
//                }
//            }
//            else {
//                for (int i = 0; i < arrayButton.length; i++)
//                {
//                    arrayButton[i].setActionCommand("X");
//                }
//            }
            if (arrayButton[0].getText().equals("X") && arrayButton[1].getText().equals("X") && arrayButton[2].getText().equals("X"))
            {
                System.out.println("X is winner");
                break;
            }
            if (arrayButton[3].getText().equals("X") && arrayButton[4].getText().equals("X") && arrayButton[5].getText().equals("X"))
            {
                System.out.println("X is winner");
                break;
            }
            if (arrayButton[6].getText().equals("X") && arrayButton[7].getText().equals("X") && arrayButton[8].getText().equals("X"))
            {
                System.out.println("X is winner");
                break;
            }
            if (arrayButton[0].getText().equals("X") && arrayButton[4].getText().equals("X") && arrayButton[8].getText().equals("X"))
            {
                System.out.println("X is winner");
                break;
            }
            if (arrayButton[2].getText().equals("X") && arrayButton[4].getText().equals("X") && arrayButton[6].getText().equals("X"))
            {
                System.out.println("X is winner");
                break;
            }
            if (arrayButton[0].getText().equals("X") && arrayButton[3].getText().equals("X") && arrayButton[6].getText().equals("X"))
            {
                System.out.println("X is winner");
                break;
            }
            if (arrayButton[1].getText().equals("X") && arrayButton[4].getText().equals("X") && arrayButton[7].getText().equals("X"))
            {
                System.out.println("X is winner");
                break;
            }
            if (arrayButton[2].getText().equals("X") && arrayButton[5].getText().equals("X") && arrayButton[8].getText().equals("X"))
            {
                System.out.println("X is winner");
                break;
            }
            if (arrayButton[0].getText().equals("O") && arrayButton[1].getText().equals("O") && arrayButton[2].getText().equals("O"))
            {
                System.out.println("O is winner");
                break;
            }
            if (arrayButton[3].getText().equals("O") && arrayButton[4].getText().equals("O") && arrayButton[5].getText().equals("O"))
            {
                System.out.println("O is winner");
                break;
            }
            if (arrayButton[6].getText().equals("O") && arrayButton[7].getText().equals("O") && arrayButton[8].getText().equals("O"))
            {
                System.out.println("O is winner");
                break;
            }
            if (arrayButton[0].getText().equals("O") && arrayButton[3].getText().equals("O") && arrayButton[6].getText().equals("O"))
            {
                System.out.println("O is winner");
                break;
            }
            if (arrayButton[1].getText().equals("O") && arrayButton[4].getText().equals("O") && arrayButton[7].getText().equals("O"))
            {
                System.out.println("O is winner");
                break;
            }
            if (arrayButton[2].getText().equals("O") && arrayButton[5].getText().equals("O") && arrayButton[8].getText().equals("O"))
            {
                System.out.println("O is winner");
                break;
            }
            if (arrayButton[0].getText().equals("O") && arrayButton[4].getText().equals("O") && arrayButton[8].getText().equals("O"))
            {
                System.out.println("O is winner");
                break;
            }
            if (arrayButton[2].getText().equals("O") && arrayButton[4].getText().equals("O") && arrayButton[6].getText().equals("O"))
            {
                System.out.println("O is winner");
                break;
            }
            q = 0;
        }
    }
}

