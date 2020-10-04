package com.company.Practice7_8;

import java.util.Random;

public class Manager implements EmployeePosition {
    private Random random = new Random();
    private int Money = 0;

    public int Polza() {
        Money = random.nextInt(140000 - 115000) + 115000;
        return Money;
    }
    

    @Override
    public double calcSalary(double ZP) {
        return ZP + Money * 0.05;
    }

    @Override
    public String getJobTitle() {
        return "Manager";
    }
}
