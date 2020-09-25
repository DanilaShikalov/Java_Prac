package com.company.Practice6;

import java.util.ArrayList;

public class Massiv {
    private int a;
    private ArrayList<Integer> objects = new ArrayList<>();
    Massiv(){}
    public void AddObject(int x, int y)
    {
        objects.add(x + y);
    }
    public int GetObject(int i)
    {
        return objects.get(i);
    }
    public int GetA()
    {
        return a;
    }
    public void SetA(int a)
    {
        this.a = a;
    }
    public int GetLength()
    {
        return objects.size();
    }
}
