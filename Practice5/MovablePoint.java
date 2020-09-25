package com.company.Practice5;

public class MovablePoint implements Movable {
    private int x;
    private int y;
    private int dx;
    private int dy;
    MovablePoint(){}
    MovablePoint(int x, int y, int dx, int dy)
    {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveUp() {
        this.y = this.y + dy;
    }

    public void moveDown() {
        this.y = this.y - dy;
    }

    public void moveLeft() {
        this.x = this.x - dx;
    }

    public void moveRight() {
        this.x = this.x + dx;
    }
}
