package com.company.Practice14;

import java.util.ArrayList;

public class Regex {
    private String regex;
    private String symbol;
    private int start;
    private int end;

    public void setEnd(int end) {
        this.end = end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public void setRegex(String a)
    {
        regex = a;
    }

    public String getRegex()
    {
        return regex;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


}
