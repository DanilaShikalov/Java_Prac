package com.company.JsonPractice;

import com.company.Practice21_22.Item;
import com.google.gson.Gson;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import org.w3c.dom.ls.LSOutput;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Item>>(){}.getType();
        FileReader fileReader = new FileReader("src\\com\\company\\db.json");
        List<Item> items = gson.fromJson(fileReader, type);
        for (Item i : items)
        {
            System.out.println(i.toString());
        }
    }
}
