package com.company.Practice7_8;

public class Employee {
    private String Name;
    private String Surname;
    private double ZP;
    private EmployeePosition WorkPlace;

    public Employee(String name, String Surname, int ZP, EmployeePosition WorkPlace) {
        this.Name = name;
        this.Surname = Surname;
        this.ZP = ZP;
        this.WorkPlace = WorkPlace;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public double getZP() {
        return ZP;
    }

    public void setZP(double ZP) {
        this.ZP = ZP;
    }

    public EmployeePosition GetWorkPlace() {
        return WorkPlace;
    }

    public void setPosition(EmployeePosition WorkPlace) {
        this.WorkPlace = WorkPlace;
    }
}
