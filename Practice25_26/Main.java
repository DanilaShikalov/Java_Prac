package com.company.Practice25_26;

public class Main {
    public static void main(String[] args) {
        HashMapWork<String, String> hashMapWork = new HashMapWork<>();
        hashMapWork.add("Hi", "No");
        hashMapWork.add("GG", "m8");
        hashMapWork.add("Hi", "Java Habr");
        hashMapWork.remove("Hi");
        hashMapWork.add("Hi", "String");
        System.out.println("///////  " + hashMapWork.get("GG"));
        for (String str : hashMapWork)
        {
            System.out.println(str);
        }
    }
}
