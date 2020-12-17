package com.company.Practice27_28;

public class Performance {
    @AnnotationForPerformance(s = "sum")
    public void sum(Data data)
    {
        int sum = 0;
        for (int x : data.getNumbers())
        {
            sum += x;
        }
        System.out.println(sum);
    }
    @AnnotationForPerformance(s = "print")
    public void print(Data data)
    {
        for (int i = 0; i < data.getWords().size(); i++)
        {
            if (i == data.getWords().size() - 1)
            {
                System.out.print(data.getWords().get(i));
            }
            else System.out.print(data.getWords().get(i) + " " + data.getDelimeter() + " ");
        }
    }

    public void Example()
    {
        System.out.println("Error");
    }
}
