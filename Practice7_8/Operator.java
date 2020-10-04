package com.company.Practice7_8;

public class Operator implements EmployeePosition {


    @Override
    public double calcSalary(double ZP) {
        return ZP;
    }

    @Override
    public String getJobTitle() {
        return "Operator";
    }
}
