package com.company.Practice2;

public class Shape {
    private String S;
    public void Form(String s)
    {
        this.S = s;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "S='" + S + '\'' +
                '}';
    }
}
