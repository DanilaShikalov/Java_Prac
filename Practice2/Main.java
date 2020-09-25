package com.company.Practice2;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);


        Shape Test = new Shape();
		System.out.println("Enter Shape");
		String S = in.nextLine();
		Test.Form(S);


	    Ball Test1 = new Ball();
	    System.out.println("Enter Radius");
	    double R = in.nextDouble();
	    Test1.SetR(R);


	    Book Test2 = new Book();
	    System.out.println("Enter Settings of Book");
		System.out.println("Enter Str");
	    int Str = in.nextInt();
		System.out.println("Enter Author");
		String Author1 = in.nextLine();
	    String Author = in.nextLine();
		System.out.println("Enter Name");
	    String Name = in.nextLine();
	    Test2.SetSettings(Str, Author, Name);


	    HouseDog Test3 = new HouseDog();
	    Dog a = new Dog();
	    Test3.DogHouse(a);
	    a.SetAge(1);
	    a.SetName("Pudel");
		System.out.println(Test.toString());
		System.out.println(Test1.toString());
		System.out.println(Test2.toString());
    }
}
