package com.company.Practice15;

import java.util.Scanner;

public class S5 {
    private static Scanner in = new Scanner(System.in);
    private String actionForZero = "deploy";
    private String actionForOne = "restart";

    public void setActionForOne(String actionForOne) {
        this.actionForOne = actionForOne;
    }

    public void setActionForZero(String actionForZero) {
        this.actionForZero = actionForZero;
    }

    public String getActionForOne() {
        return actionForOne;
    }

    public String getActionForZero() {
        return actionForZero;
    }

    public void Action()
    {
        int s = Integer.parseInt(in.nextLine());
        if (s == 0)
        {
            System.out.println(actionForZero);
            S1 s1 = new S1();
            s1.Action();
        }
        if (s == 1)
        {
            System.out.println(actionForOne);
            S3 s3 = new S3();
            s3.Action();
        }
    }
}
