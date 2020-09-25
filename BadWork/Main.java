package com.company.BadWork;

import java.util.Scanner;

public class Main {
//Доп задача 1
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.print(Test(N));
    }

    public static int Test(int N) {
        int temp = 0;
        for (int i = N / 5; i >= 0; i--)
        {
            for (int j = (N - i * 5) / 3; j >= 0; j--)
            {
                for (int k = N - j * 3 - i * 5; k >= 0; k--)
                {
                    if (i * 5 + j * 3 + k == N)
                        temp++;
                }
            }
        }
        return temp;
    }
}
