package com.company.Practice4;

public class Circle extends Shape {
    protected double Radius = 25;
    public Circle()
    {
    }
    Circle(double radius)
    {
        this.Radius = radius;
    }
    Circle(double radius, String color, boolean filled)
    {
        super(color, filled);
        this.Radius = radius;
    }
    public double GetRadius()
    {
        return Radius;
    }
    public void SetRadius(double a)
    {
        Radius = a;
    }

    @Override
    public double GetArea() {
        return 3.14*3.14*Radius;
    }

    @Override
    public double GetPerimeter() {
        return 2*3.14*Radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "Radius=" + Radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
