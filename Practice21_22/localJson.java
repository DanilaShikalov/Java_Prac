package com.company.Practice21_22;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class localJson implements ItemStore {
    private Gson gson = new Gson();
    private String path = "src\\com\\company\\db.json";
    private File file = new File(path);
    private FileWriter fileWriter;

    @Override
    public List<Item> getAll() throws FileNotFoundException {
        Type type = new TypeToken<List<Item>>(){}.getType();
        List<Item> cars = null;
        FileReader fileReader = new FileReader(file);
        cars = gson.fromJson(fileReader, type);
        return cars;
    }

    @Override
    public Item get(int id) throws FileNotFoundException {
        List<Item> cars = getAll();
        for (Item i : cars) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public Item addItem(Item item) throws IOException {
        List<Item> cars = getAll();
        cars.add(item);
        fileWriter = new FileWriter(path);
        fileWriter.write("[\n");
        for (int i = 0; i < cars.size(); i++) {
            fileWriter.write(cars.get(i).toString2());
            if (i != cars.size() - 1) fileWriter.write(",");
            fileWriter.write("\n");
        }
        fileWriter.write("]");
        fileWriter.close();
        return item;
    }

    @Override
    public Item editItem(Item item) throws IOException {
        int id = item.getId();
        List<Item> cars = getAll();
        fileWriter = new FileWriter(path);
        for (Item i : cars) {
            if (i.getId() == id) {
                i.setId(item.getId());
                i.setName(item.getName());
                i.setForSale(item.isForSale());
                i.setDescription(item.getDescription());
            }
        }
        fileWriter.write("[\n");
        for (int i = 0; i < cars.size(); i++) {
            fileWriter.write(cars.get(i).toString2());
            if (i != cars.size() - 1) fileWriter.write(",");
            fileWriter.write("\n");
        }
        fileWriter.write("]");
        fileWriter.close();
        return item;
    }

    @Override
    public void deleteItem(Item item) throws IOException {
        int id = item.getId();
        List<Item> cars = getAll();
        fileWriter = new FileWriter(path);
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId() == id) {
                cars.remove(i);
            }
        }
        fileWriter.write("[\n");
        for (int i = 0; i < cars.size(); i++) {
            fileWriter.write(cars.get(i).toString2());
            if (i != cars.size() - 1) fileWriter.write(",");
            fileWriter.write("\n");
        }
        fileWriter.write("]");
        fileWriter.close();
    }
}
