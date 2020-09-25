package com.company.Practice5;

public class Main {

    public static void main(String[] args) {
        MovablePoint Test1 = new MovablePoint();
        MovableCircle Test2 = new MovableCircle(new MovablePoint(2,4,5,1));
        MovableRectangle Points = new MovableRectangle(new MovablePoint(1, 2, 3, 4), new MovablePoint(4, 5, 2 ,1));
    }
}
