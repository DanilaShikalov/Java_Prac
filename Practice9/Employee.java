package com.company.Practice9;

import java.time.LocalDate;

public class Employee {
    private String Name;
    private String surname;
    private LocalDate date;
    private String city;
    private String number;
    private int ZP;

    public Employee(String Name, String surname, LocalDate date, String city, String number, int ZP) {
        this.Name = Name;
        this.surname = surname;
        this.date = date;
        this.city = city;
        this.number = number;
        this.ZP = ZP;
    }

    public Employee() {
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate  getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getZP() {
        return ZP;
    }

    public void setZP(int ZP) {
        this.ZP = ZP;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Name='" + Name + '\'' +
                ", surname='" + surname + '\'' +
                ", date=" + date +
                ", city='" + city + '\'' +
                ", number='" + number + '\'' +
                ", ZP=" + ZP +
                '}';
    }
}
