package com.company.Practice9;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> list = new ArrayList<>();

    public void handleEmployees(Employee1 employee1, Employee2 employee2){
        int t = 0;
        for (Employee employee: list) {
            if (employee2.BOOLEANSout(employee)) {
                employee1.Sout(employee, t);
                t++;
            }
        }
    }

    public void ClearAll()
    {
        list.clear();
    }

    public void hire(Employee employee) {
        list.add(employee);
    }

    public void hireAll(ArrayList<Employee> list1) {
        list.addAll(list1);
    }

    public void fire(Employee employee) {
        list.remove(employee);
    }

    public void fire(int i) {
        list.remove(i);
    }

}
