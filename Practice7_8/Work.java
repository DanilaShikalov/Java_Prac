package com.company.Practice7_8;

import java.util.List;

public class Work {
    private int money = 50000;
    private String name = "Danila";
    private String SurName = "Shikalov";
    private Company company = new Company();


    public static void main(String[] args) {
        new Work();
    }


    public Work() {
        for (int i = 0; i < 180; i++) {
            company.hire(new Employee(name, SurName, money, new Operator()));
        }
        for (int i = 0; i < 80; i++) {
            company.hire(new Employee(name, SurName, money, new Manager()));
        }
        for (int i = 0; i < 10; i++) {
            company.hire(new Employee(name, SurName, money, new TopManager(company)));
        }
        System.out.println("Доход: " + company.getIncome());
        List<Employee> list = company.getTopSalaryStaff(15);
        System.out.println("Топ-15 высоких зарплат");
        for (int i = 0; i < 15; i++) {
            System.out.println(String.valueOf((int) list.get(i).GetWorkPlace().calcSalary(list.get(i).getZP())) + "     " + list.get(i).GetWorkPlace().getJobTitle());
        }
        list = company.getLowestSalaryStaff(30);
        System.out.println("Топ-30 низких зарплат");
        for (int i = 0; i < 30; i++) {
            System.out.println(String.valueOf((int) list.get(i).GetWorkPlace().calcSalary(list.get(i).getZP())) + "     " + list.get(i).GetWorkPlace().getJobTitle());
        }
        for (int i = 0; i < company.getListSize(); i++) {
            company.fire(i);
        }
        System.out.println("Доход после увольнения: "+ company.getIncome());
        list = company.getTopSalaryStaff(15);
        System.out.println("Топ-15 высоких зарплат");
        for (int i = 0; i < 15; i++) {
            System.out.println(String.valueOf((int) list.get(i).GetWorkPlace().calcSalary(list.get(i).getZP())) + "     " + list.get(i).GetWorkPlace().getJobTitle());
        }
        list = company.getLowestSalaryStaff(30);
        System.out.println("Топ-30 низких зарплат");
        for (int i = 0; i < 30; i++) {
            System.out.println(String.valueOf((int) list.get(i).GetWorkPlace().calcSalary(list.get(i).getZP())) + "     " + list.get(i).GetWorkPlace().getJobTitle());
        }
    }
}
