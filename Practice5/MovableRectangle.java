package com.company.Practice5;

public class MovableRectangle implements Movable {
    private MovablePoint P1;
    private MovablePoint P2;

    MovableRectangle(MovablePoint P1, MovablePoint P2)
    {
        this.P1 = P1;
        this.P2 = P2;
    }

    public MovablePoint getP1() {
        return P1;
    }

    public MovablePoint getP2() {
        return P2;
    }

    public int GetLength()
    {
        return Math.abs(P1.getX() - P2.getX());
    }
    public int GetWidth()
    {
        return Math.abs(P1.getY() - P2.getY());
    }
    public void SetLength(int Length)
    {
        P1.setX(0);
        P2.setX(Length);
    }
    public void SetWidth(int Width)
    {
        P1.setY(0);
        P2.setY(Width);
    }
    @Override
    public void moveDown() {
        P1.moveDown();
        P2.moveDown();
    }

    @Override
    public void moveLeft() {
        P1.moveLeft();
        P2.moveLeft();
    }

    @Override
    public void moveRight() {
        P1.moveRight();
        P1.moveRight();
    }

    @Override
    public void moveUp() {
        P1.moveUp();
        P2.moveUp();
    }
}
