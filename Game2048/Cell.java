package com.company.Game2048;

public class Cell {
    private int value;
    public Cell(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int a)
    {
        value = a;
    }
    public Cell multiply() {
        return new Cell(value * 2);
    }
}

