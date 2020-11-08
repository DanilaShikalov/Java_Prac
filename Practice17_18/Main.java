package com.company.Practice17_18;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static PrintWriter printWriter;
    private static int a = 1;
    public static void main(String[] args) throws FileNotFoundException {
        Path path = Paths.get("").toAbsolutePath();
        printWriter = new PrintWriter(path + "\\src\\com\\company\\Practice17_18\\result.md");
        Result(path + "\\src\\com\\company", a);
    }

    public static void Result(String path, int a) {
        Scanner sc = new Scanner(System.in);
        File file = new File(path);
        if (file.isDirectory()) {
            String[] files = file.list();
            for (int i = 0; i < files.length; i++) {
                Result(path + "\\" + files[i], a);
            }
        }
        if (file.isFile()) {
            if (file.getName().endsWith(".java")) {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
                    String line = bufferedReader.readLine();
                    printWriter.write("### Работа с путем ");
                    printWriter.write(path + "\n");
                    printWriter.write("```java\n");
                    while (line != null) {
                        printWriter.write(line + "\n");
                        line = bufferedReader.readLine();
                    }
                    printWriter.write("```\n");
                } catch (FileNotFoundException e) {
                    System.out.println("Incorrect file path");
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //a++;
            }
        }
    }
}
