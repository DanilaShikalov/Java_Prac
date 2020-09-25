package com.company.Practice3;

import java.util.Scanner;

public class Book {
    Scanner in = new Scanner(System.in);
    private int Year;
    private String Name;
    private String Name1;
    public void SetYear()
    {
        System.out.println("Enter Year");
        int a = in.nextInt();
        this.Year = a;
    }

    public void setName() {

        System.out.println("Enter Name");
        String a = in.nextLine();
        this.Name = a;
    }

    public void setName1() {
        System.out.println("Enter author");
        String a = in.nextLine();
        this.Name1 = a;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Year=" + Year +
                ", Name='" + Name + '\'' +
                ", Name1='" + Name1 + '\'' +
                '}';
    }

    public int GetYear()
    {
        return Year;
    }
    public String GetName()
    {
        return Name;
    }
    public String GetName1()
    {
        return Name1;
    }
}
