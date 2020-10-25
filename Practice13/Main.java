package com.company.Practice13;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Car item = new Car();
        try{
            int cost = Integer.parseInt(in.nextLine());
            item.setCost(cost);
            System.out.println("Cost is: " + cost);
        }
        catch (NegEx nce) {
            System.out.println("Cost is negative!");
        }
        catch(NumberFormatException nfe) {
            System.out.println("Incorrect input");
        }
        catch(Exception ex)
        {
            System.out.println("Error");
        }
        finally {
            System.out.println(item);
        }

        throw new CostEx();
    }
}
