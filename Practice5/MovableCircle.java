package com.company.Practice5;


import com.company.Practice4.Circle;

public class MovableCircle extends Circle implements Movable {
    private MovablePoint Move;
    MovableCircle(MovablePoint Move)
    {
        this.Move = Move;
    }

    public int getX() {
        return Move.getX();
    }

    public int getY() {
        return Move.getY();
    }

    public void setX(int x)
    {
        Move.setX(x);
    }

    public void setY(int y)
    {
        Move.setY(y);
    }

    public void moveUp() {
        Move.moveUp();
    }


    public void moveDown() {
        Move.moveDown();
    }


    public void moveLeft() {
        Move.moveLeft();
    }


    public void moveRight() {
        Move.moveRight();
    }
}
