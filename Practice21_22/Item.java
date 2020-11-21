package com.company.Practice21_22;

public class Item {
    private int id;
    private String Name;
    private boolean forSale;
    private String description;

    public Item(int id, String data, boolean isGood, String description) {
        this.id = id;
        this.Name = data;
        this.forSale = isGood;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public boolean isForSale() {
        return forSale;
    }

    public String getDescription() {
        return description;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Car{\n" +
                "id=" + id +
                ", \nName='" + Name + '\'' +
                ", \nforSale=" + forSale +
                ", \ndescription='" + description + '\'' +
                "\n}";
    }

    public String toString1()
    {
        return "Car{\n" +
                "id=" + id +
                ", \nName='" + Name + '\'' +
                ", \nforSale=" + forSale +
                "\n}";
    }

    public String toString2()
    {
        return "   {\n" +
                "      \"id\": " + id + "," +
                "\n    \"Name\": " + "\"" + Name +"\"" + "," +
                "\n    \"forSale\": " + forSale + "," +
                "\n    \"description\": " + "\"" + description + "\"" +
                "\n   }";
    }
}

