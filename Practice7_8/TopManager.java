package com.company.Practice7_8;

public class TopManager implements EmployeePosition {
    Company company;

    public TopManager(Company company) {
        this.company = company;
    }


    @Override
    public double calcSalary(double ZP) {
        double t = 0;
        if (company.getIncome() >= 10000000)
        {
            t = ZP * 1.5;
        }
        return ZP + t;
    }

    @Override
    public String getJobTitle() {
        return "TopManager";
    }
}
