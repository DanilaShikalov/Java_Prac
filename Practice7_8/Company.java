package com.company.Practice7_8;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private double Summa = 0;
    private ArrayList<Employee> employeeList = new ArrayList<>();


    public void hire(Employee employee) {
        employeeList.add(employee);
    }


    public void fire(int i) {
        employeeList.remove(i);
        getIncome();
    }


    public double getIncome() {
        this.Summa = 0;
        for (Employee emp : employeeList) {
            if (emp.GetWorkPlace() instanceof Manager) {
                Summa = Summa + ((Manager) emp.GetWorkPlace()).Polza();
            }
        }
        return Summa;
    }

    List<Employee> getTopSalaryStaff(int count) {
        ArrayList<Employee> employees = employeeList;
        Employee t;
        for (int i = 0; i < employees.size() - 1; i++)
            for (int j = i + 1; j < employees.size(); j++) {
                if (employees.get(i).GetWorkPlace().calcSalary(employees.get(i).getZP()) < employees.get(j).GetWorkPlace().calcSalary(employees.get(j).getZP())) {
                    t = employees.get(j);
                    employees.set(j, employees.get(i));
                    employees.set(i, t);
                }
            }
        return employees.subList(0, count);
    }

    List<Employee> getLowestSalaryStaff(int count) {
        ArrayList<Employee> employees = employeeList;
        Employee t;
        for (int i = 0; i < employees.size() - 1; i++)
            for (int j = i + 1; j < employees.size(); j++) {
                if (employees.get(i).GetWorkPlace().calcSalary(employees.get(i).getZP()) > employees.get(j).GetWorkPlace().calcSalary(employees.get(j).getZP())) {
                    t = employees.get(j);
                    employees.set(j, employees.get(i));
                    employees.set(i, t);
                }
            }
        return employees.subList(0, count);
    }

    public int getListSize() {
        return employeeList.size();
    }

    public void hireAll(ArrayList<Employee> listEmployee) {
        employeeList.addAll(listEmployee);
    }

    public void fire(Employee employee) {
        employeeList.remove(employee);
    }
}
