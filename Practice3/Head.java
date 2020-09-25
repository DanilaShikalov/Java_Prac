package com.company.Practice3;

import java.util.Scanner;

public class Head {
    private int IQ;

    public int getIQ() {
        return IQ;
    }

    public void setIQ(int IQ) {
        this.IQ = IQ;
    }

    @Override
    public String toString() {
        return "Head{" +
                "IQ=" + IQ +
                '}';
    }
}
