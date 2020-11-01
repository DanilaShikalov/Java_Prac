package com.company.Practice15;

import java.util.Scanner;

public class S4 {
    private static Scanner in = new Scanner(System.in);
    private String actionForZero = "restart";
    private String actionForOne = "deploy";

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
            S3 s3 = new S3();
            s3.Action();
        }
        if (s == 1)
        {
            System.out.println(actionForOne);
            S5 s5 = new S5();
            s5.Action();
        }
    }
}
