package com.company.Game2048;

import java.util.ArrayList;

public class Massiv {
    ArrayList<Integer> Summa = new ArrayList<>();
    ArrayList<Integer> Simbols = new ArrayList<>();
    public void SummaAdd(int value)
    {
        Summa.add(value);
    }

    public void SimbolsAdd(int value)
    {
        Simbols.add(value);
    }

    public int getSimbols(int i)
    {
        return Simbols.get(i);
    }

    public void SimbolsPrint()
    {
        for (int i = 0; i < Simbols.size(); i++)
        {
            System.out.print(Simbols.get(i) + " ");
        }
        System.out.println();
    }

    public int GetSumma()
    {
        int s = 0;
        for (int i = 0; i < Summa.size(); i++)
        {
            s = s + Summa.get(i);
        }
        return s;
    }
}
