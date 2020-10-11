package com.company.Practice9;

public class emploe2 implements Employee2 {
    private int day;

    public emploe2(int day) {
        this.day = day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "emploe2{" +
                "day=" + day +
                '}';
    }

    @Override
    public boolean BOOLEANSout(Employee employee) {
        return employee.getDate().getDayOfMonth() > this.day;
    }
}
