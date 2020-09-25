package com.company.Practice4;

public abstract class Shape {
    protected String color = "black";
    protected boolean filled = true;
    Shape(){}
    Shape(String color, boolean filled)
    {
        this.filled = filled;
        this.color = color;
    }

    public String GetColor()
    {
        return color;
    }
    public void SetColor(String a)
    {
        color = a;
    }
    public boolean isFilled()
    {
        return filled;
    }
    public void SetFilled(boolean a)
    {
        filled = a;
    }
    public abstract double GetArea();
    public abstract double GetPerimeter();
    public abstract String toString();
}
