package com.company.Practice27_28;

public class TypeOfWork {
    private String type;
    private Data data;
    private int id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TypeOfWork{" +
                "type='" + type + '\'' +
                ", data=" + data +
                ", id=" + id +
                '}';
    }
}
