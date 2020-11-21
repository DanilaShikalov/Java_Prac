package com.company.Practice21_22;

import java.io.IOException;
import java.util.List;

public interface ItemStore {
    List<Item> getAll() throws IOException, InterruptedException;
    Item get(int id) throws IOException, InterruptedException;
    Item addItem(Item item) throws IOException, InterruptedException;
    Item editItem(Item item) throws IOException, InterruptedException;
    void deleteItem(Item item) throws IOException, InterruptedException;

}