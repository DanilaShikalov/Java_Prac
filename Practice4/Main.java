package com.company.Practice4;

public class Main {

    public static void main(String[] args) {
        Rectangle G = new Rectangle();
        System.out.println(G.GetArea() + G.GetLength() + G.GetPerimeter());
        Square H = new Square(4);
        System.out.println(H.toString() + H.GetPerimeter());
    }
}
