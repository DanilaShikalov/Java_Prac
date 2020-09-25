package com.company.Practice2;

public class Book {
    private int Str;
    private String Author;
    private String Name;
    public void SetSettings(int Str, String Author, String Name)
    {
        this.Str = Str;
        this.Author = Author;
        this.Name = Name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Str=" + Str +
                ", Author='" + Author + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
