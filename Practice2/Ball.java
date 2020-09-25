package com.company.Practice2;

public class Ball {
    private double R;
    private double S;
    public void SetR(double R)
    {
        this.R = R;
    }

    public void SetS(double S)
    {
        this.S = S;
    }

    @Override
    public String toString() {
        S = 4*3*R*R;
        return "Ball{" +
                "R=" + R +
                ", S=" + S +
                '}';
    }
}
