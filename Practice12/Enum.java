package com.company.Practice12;

public enum Enum {
    ANSI_RESET("\u001B[0m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_BLACK("\u001B[30m"),
    ANSI_WHITE("\u001B[30m"),
    ANSI_CYAN("\u001B[36m"),
    ANSI_RED("\u001B[31m"),
    ANSI_YELLOW("\u001B[33m"),
    ANSI_BLUE("\u001B[34m");

    private String color;

    Enum(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
