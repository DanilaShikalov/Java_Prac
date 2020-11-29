package com.company.Practice23_24;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Start");
        httpServer httpServer = new httpServer();
        httpServer.getAll();
    }
}
