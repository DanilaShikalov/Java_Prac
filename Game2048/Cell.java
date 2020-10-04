package com.company.Game2048;

public class Cell {
    private int value;
    private Massiv winner;
    public Cell(int value) {
        this.value = value;
    }
    public void SetWinner(Massiv winner)
    {
        this.winner = winner;
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

