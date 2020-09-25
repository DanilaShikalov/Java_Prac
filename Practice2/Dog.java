package com.company.Practice2;

public class Dog {
    private String Name;
    private int Age;
    public Dog(){}
    public Dog(String Name, int Age) {
        this.Name = Name;
        this.Age = Age;
    }
    public void SetName(String Name)
    {
        this.Name = Name;
    }
    public void SetAge(int Age)
    {
        this.Age = Age;
    }
    public String GetName()
    {
        return Name;
    }
    public int GetAge()
    {
        return Age;
    }
    @Override
    public String toString() {
        return "Dog{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                '}';
    }
}
