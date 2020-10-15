package com.company.Practice12;

import java.util.Random;

public class Main {
    private static Random r = new Random();
    private static Enum[] anEnum = Enum.values();
    public static void main(String[] args) {
        RandomColors("TTTTTTTTTT");
        SelectColor("TTTTTTTTTT", Enum.ANSI_CYAN);
    }

    public static void RandomColors(String s)
    {
        char[] result = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            System.out.print(anEnum[r.nextInt(anEnum.length)].getColor() + result[i]);
        }
        System.out.println();
    }

    public static void SelectColor(String s, Enum color)
    {
        System.out.println(color.getColor() + s);
    }
}
