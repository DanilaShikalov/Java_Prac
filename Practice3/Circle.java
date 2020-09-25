package com.company.Practice3;

public class Circle {
    private int Radius = 10;
    private int Diameter;
    private int C;
    private int Square;
    public void SetR(int a)
    {
        Radius = a;
    }
    public int GetR()
    {
        return Radius;
    }
    public int GetD()
    {
        return Radius*2;
    }
    public int GetC()
    {
        return 2*3*Radius;
    }
    public int GetS()
    {
        return 3*Radius*Radius;
    }
}
