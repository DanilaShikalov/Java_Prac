package com.company.Practice21_22;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ItemStore itemStore = null;
        Scanner in = new Scanner(System.in);
        System.out.println("1-Server\n2-Local");
        int choose;
        choose = in.nextInt();
        if(choose == 1){
            itemStore = new httpJson();
        } else if (choose == 2) {
            itemStore = new localJson();
        }
        System.out.println("1-get all\n2-get\n3-add\n4-edit\n5-delete");
        int pas;
        while (true){
            pas = in.nextInt();
            switch (pas){
                case 1:
                    List<Item> items = itemStore.getAll();
                    for (int i = 0; i < items.size(); i++)
                    {
                        if (choose == 2)
                            System.out.println(items.get(i).toString1());
                    }
                    break;
                case 2:
                    System.out.print("Enter car id: ");
                    int IdSearch = in.nextInt();
                    Item car = itemStore.get(IdSearch);
                    if (car == null) {
                        System.out.println("Error");
                    } else {
                        System.out.println(car.toString());
                    }
                    break;
                case 3:
                    int id;
                    String Name, description;
                    boolean ForSale;
                    System.out.print("Car id:");
                    id = in.nextInt();
                    System.out.print("Car Name:");
                    Name = in.next();
                    System.out.print("Is the car for sale?");
                    ForSale = in.nextBoolean();
                    System.out.print("Car description:");
                    description = in.next();
                    itemStore.addItem(new Item(id, Name, ForSale, description));
                    System.out.println("Car added");
                    break;
                case 4:
                    System.out.print("Enter car id: ");
                    int IdSearch1 = in.nextInt();
                    Item Car = itemStore.get(IdSearch1);
                    String newName;
                    boolean forSale;
                    String newDescription;
                    System.out.println(Car);
                    System.out.print("Enter new name data:");
                    newName = in.next();
                    System.out.print("Is the car for sale?");
                    forSale = in.nextBoolean();
                    System.out.print("Enter new car description:");
                    newDescription = in.next();
                    itemStore.editItem(new Item(IdSearch1, newName, forSale, newDescription));
                    System.out.println("Car edited!");
                    break;
                case 5:
                    System.out.print("Enter car id: ");
                    int IdSearch2 = in.nextInt();
                    itemStore.deleteItem(new Item(IdSearch2, "", true, ""));
                    System.out.println("Car deleted!");
                    break;
            }
        }

    }
}
