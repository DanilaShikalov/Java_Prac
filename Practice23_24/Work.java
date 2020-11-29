package com.company.Practice23_24;

public class Work {
    private int id;
    private String taskDescription;
    private String expression;

    public Work(int id, String taskDescription, String expression) {
        this.id = id;
        this.taskDescription = taskDescription;
        this.expression = expression;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", taskDescription='" + taskDescription + '\'' +
                ", expression='" + expression + '\'' +
                '}';
    }

    public String toString1()
    {
        return "Work{\n" +
                "id=" + id +
                ", \ntaskDescription='" + taskDescription + '\'' +
                ", \nexpression=" + expression +
                "\n}";
    }

    public String toString2()
    {
        return "   {\n" +
                "      \"id\": " + id + "," +
                "\n    \"taskDescription\": " + "\"" + taskDescription +"\"" + "," +
                "\n    \"expression\": \"" + expression  +
                "\"\n   }";
    }
}
