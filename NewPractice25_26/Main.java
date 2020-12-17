package com.company.NewPractice25_26;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        hm.add("Key1", "Value1");
        hm.add("Key2", "Value2");
        hm.add("Key3", "Value3");
        //hm.add("Key3", "Value4");
        System.out.println(hm.get("Key3"));
        hm.remove("Key2");
        System.out.println(hm.get("Key2"));
        for(String value : hm)
        {
            System.out.println(value);
        }
    }
}
