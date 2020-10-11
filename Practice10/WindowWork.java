package com.company.Practice10;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.Random;

public class WindowWork  {
    private final Random random = new Random();
    public void Start()
    {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setResizable(true);
        jFrame.setSize(500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jFrame.add(jPanel);
        JButton jButton = new JButton("+");
        JButton jButton1 = new JButton("-");
        JButton jButton2 = new JButton("*");
        JButton jButton3 = new JButton("/");
        jButton.setBounds(50,100,50,50);
        jButton1.setBounds(150,100,50,50);
        jButton2.setBounds(250,100,50,50);
        jButton3.setBounds(350,100,50,50);
        JTextField jTextField = new JTextField();
        JTextField jTextField1 = new JTextField();
        jTextField.setBounds(175,50,100,20);
        jTextField1.setBounds(175,180,100,20);
        JLabel jLabel = new JLabel();
        jLabel.setText("");
        jLabel.setBounds(175, 300, 1000, 20);
        jPanel.add(jLabel);
        jPanel.add(jTextField);
        jPanel.add(jTextField1);
        jPanel.add(jButton);
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    double a = Double.parseDouble(jTextField.getText());
                    double b = Double.parseDouble(jTextField1.getText());
                    double scale = Math.pow(10, 4);
                    jLabel.setText("Результат: " + String.valueOf((Math.round((a + b) * scale))/scale));
                    jTextField.setText("");
                    jTextField1.setText("");
                }
                catch (Exception ex)
                {
                    jLabel.setText("Введите корректные данные");
                }
            }
        });
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    double a = Double.parseDouble(jTextField.getText());
                    double b = Double.parseDouble(jTextField1.getText());
                    double scale = Math.pow(10, 4);
                    jLabel.setText("Результат: " + String.valueOf((Math.round((a - b) * scale))/scale));
                    jTextField.setText("");
                    jTextField1.setText("");
                }
                catch (Exception ex)
                {
                    jLabel.setText("Введите корректные данные");
                }
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    double a = Double.parseDouble(jTextField.getText());
                    double b = Double.parseDouble(jTextField1.getText());
                    double scale = Math.pow(10, 4);
                    jLabel.setText("Результат: " + String.valueOf((Math.round((a * b) * scale))/scale));
                    jTextField.setText("");
                    jTextField1.setText("");
                }
                catch (Exception ex)
                {
                    jLabel.setText("Введите корректные данные");
                }
            }
        });
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(jTextField.getText());
                    double b = Double.parseDouble(jTextField1.getText());
                    double scale = Math.pow(10, 4);
                    if (b == 0) jLabel.setText("Введите корректные данные");
                    else {
                        jLabel.setText("Результат: " + String.valueOf((Math.round((a / b) * scale)) / scale));
                        jTextField.setText("");
                        jTextField1.setText("");
                    }
                }
                catch (Exception ex)
                {
                    jLabel.setText("Введите корректные данные");
                }
                }
        });
    }
}
