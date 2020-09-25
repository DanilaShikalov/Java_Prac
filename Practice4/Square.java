package com.company.Practice4;

class Square extends Shape {
    protected double side = 5;
    Square()
    {

    }
    Square(double side)
    {
        this.side = side;
    }
    Square(double side, String color, boolean filled)
    {
        super(color, filled);
        this.side = side;
    }
    public void SetSide(double a)
    {
        side = a;
    }

    @Override
    public double GetArea() {
        return side*side;
    }

    @Override
    public double GetPerimeter() {
        return 4*side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
