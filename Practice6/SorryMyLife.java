package com.company.Practice6;

import java.util.Scanner;

public class SorryMyLife {
    private Scanner in = new Scanner(System.in);
    private Massiv[][] array;
    SorryMyLife(int N)
    {
        array = new Massiv[N][N];
    }
    public void F(int N)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                array[i][j] = new Massiv();
                array[i][j].SetA(in.nextInt());
            }
        }
    }
    public void Summa(int N)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if ((i == 0) && (j == 0)) {
                    if ((j + 1) != N) {
                        array[i][j + 1].AddObject(array[i][j].GetA(), array[i][j + 1].GetA());
                    }
                    if ((i + 1) != N) {
                        array[i + 1][j].AddObject(array[i][j].GetA(), array[i + 1][j].GetA());
                    }
                }
                else {
                    if ((j + 1) != N) {
                        for (int k = 0; k < array[i][j].GetLength(); k++) {
                            array[i][j + 1].AddObject(array[i][j].GetObject(k), array[i][j + 1].GetA());
                        }
                    }
                    if ((i + 1) != N) {
                        for (int k = 0; k < array[i][j].GetLength(); k++) {
                            array[i + 1][j].AddObject(array[i][j].GetObject(k), array[i + 1][j].GetA());
                        }
                    }
                }
            }
        }
    }
    public void Exit(int N)
    {
        int Q = 0;
        for (int i = 0; i < array[N - 1][N - 1].GetLength(); i++)
        {
            System.out.println(array[N - 1][N - 1].GetObject(i));
            if (Q < array[N - 1][N - 1].GetObject(i))
            {
                Q = array[N - 1][N - 1].GetObject(i);
            }
        }
        System.out.println("Answer: " + Q);
    }
}
