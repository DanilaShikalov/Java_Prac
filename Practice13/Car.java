package com.company.Practice13;

public class Car {
    private int cost;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) throws NegEx, CostEx {
        if (cost < 0)
        {
            throw new NegEx();
        }
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cost=" + cost +
                '}';
    }
}