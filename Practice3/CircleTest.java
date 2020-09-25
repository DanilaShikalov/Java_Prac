package com.company.Practice3;

import java.util.Scanner;

public class CircleTest {
    public static void main(String[] args) {
        Circle Test = new Circle();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 1 if you want to enter information, else enter 2");
        int A = in.nextInt();
        if (A == 1)
        {
            System.out.println("Enter Radius");
            int Radius = in.nextInt();
            Test.SetR(Radius);
        }
        System.out.println("Information: \nRadius: " + Test.GetR() + "\nSquare: " + Test.GetS() + "\nC: " + Test.GetC() + "\nDiameter: " + Test.GetD());
    }
}
