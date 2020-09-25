package com.company.Practice3;

public class Human {
    private Hand hand;
    private Head head;
    private Leg leg;
    private int age;

    public void SetHand(Hand hand)
    {
        this.hand = hand;
    }

    public void SetHead(Head head)
    {
        this.head = head;
    }

    public void SetLeg(Leg leg)
    {
        this.leg = leg;
    }

    public Hand GetHand()
    {
        return hand;
    }

    public Head GetHead()
    {
        return head;
    }

    public Leg GetLeg()
    {
        return leg;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "hand=" + hand +
                ", head=" + head +
                ", leg=" + leg +
                '}';
    }
}
