package com.company.Practice4;

class Rectangle extends Shape {
    protected double width = 3;
    protected double length = 4;
    Rectangle()
    {

    }
    Rectangle(double width, double length)
    {
        this.length = length;
        this.width = width;
    }
    Rectangle(double width, double length, String color, boolean filled)
    {
        super(color, filled);
        this.filled = filled;
        this.length = length;
        this.width = width;
    }
    public double GetWidth()
    {
        return width;
    }
    public void SetWidth(double a)
    {
        width = a;
    }
    public double GetLength()
    {
        return length;
    }
    public void SetLength(double a)
    {
        length = a;
    }
    @Override
    public double GetArea() {
        return length*width;
    }

    @Override
    public double GetPerimeter() {
        return 2*(length+width);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
