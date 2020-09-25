package com.company.Practice3;

import java.util.Scanner;

public class Hand {
    private int Length;

    public int getLength() {
        return Length;
    }

    public void setLength(int length) {
        Length = length;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "Length=" + Length +
                '}';
    }
}
