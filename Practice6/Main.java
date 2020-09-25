package com.company.Practice6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        SorryMyLife Fun = new SorryMyLife(N);
        Fun.F(N);
        Fun.Summa(N);
        Fun.Exit(N);
    }
}
