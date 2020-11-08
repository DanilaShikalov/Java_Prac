### Работа с путем D:\Java_Prac\src\com\company\BadWork\Main.java
```java
package com.company.BadWork;

import java.util.Scanner;

public class Main {
//Доп задача 1
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.print(Test(N));
    }

    public static int Test(int N) {
        int temp = 0;
        for (int i = N / 5; i >= 0; i--)
        {
            for (int j = (N - i * 5) / 3; j >= 0; j--)
            {
                for (int k = N - j * 3 - i * 5; k >= 0; k--)
                {
                    if (i * 5 + j * 3 + k == N)
                        temp++;
                }
            }
        }
        return temp;
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Game2048\Cell.java
```java
package com.company.Game2048;

public class Cell {
    private int value;
    public Cell(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int a)
    {
        value = a;
    }
    public Cell multiply() {
        return new Cell(value * 2);
    }
}

```
### Работа с путем D:\Java_Prac\src\com\company\Game2048\CellHolder.java
```java
package com.company.Game2048;

public class CellHolder {
    private Cell cell;

    public boolean isEmpty() {
        return cell == null;
    }

    public Cell popCell() {
        Cell localCell = cell;
        cell = null;
        return localCell;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
    @Override
    public String toString() {
        if (cell == null) {
            return "    ";
        }
        int value = cell.getValue();
        if (value < 10) {
            return "  " + value + " ";
        } else if (value < 100) {
            return " " + value + " ";
        } else if (value < 1000) {
            return " " + value;
        } else return "" + value;
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Game2048\Game2048Field.java
```java
package com.company.Game2048;

public interface Game2048Field {
    int getSize();

    Cell[][] getFieldState();

    void moveRight();

    void moveDown();

    void moveLeft();

    void moveUp();

    boolean isMoveAvailable();
}
```
### Работа с путем D:\Java_Prac\src\com\company\Game2048\Game2048Player.java
```java
package com.company.Game2048;

public abstract class Game2048Player {
    protected Game2048Field game2048Field;

    public Game2048Player(Game2048Field game2048Field){
        this.game2048Field = game2048Field;
    }

    public void startGame(Worst worst, Massiv winner, GameField gameField1) throws InterruptedException {
        if (game2048Field.isMoveAvailable())
        {
            step();
            worst.Test(winner, gameField1);
        }
        while (game2048Field.isMoveAvailable()) {
            step();
        }
    }

    protected abstract void step();
}
```
### Работа с путем D:\Java_Prac\src\com\company\Game2048\GameField.java
```java
package com.company.Game2048;

import java.util.Random;

public class GameField implements Game2048Field{
    private final int size;
    private final CellHolder[][] cells;
    private final LineHolder[] verticalLines;
    private final LineHolder[] horizontalLines;
    private final Random random = new Random();

    public GameField(int size) throws Exception {
        if (size < 3) {
            throw new IllegalArgumentException("size must be 3 or greater");
        }
        this.size = size;
        cells = new CellHolder[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new CellHolder();
            }
        }
        verticalLines = new LineHolder[size];
        for (int i = 0; i < size; i++) {
            LineHolder currentHolder = new LineHolder(size);
            for (int j = 0; j < size; j++) {
                currentHolder.setHolder(j, cells[j][i]);
            }
            verticalLines[i] = currentHolder;
        }

        horizontalLines = new LineHolder[size];
        for (int i = 0; i < size; i++) {
            LineHolder currentHolder = new LineHolder(size);
            for (int j = 0; j < size; j++) {
                currentHolder.setHolder(j, cells[i][j]);
            }
            horizontalLines[i] = currentHolder;
        }

    }

    public CellHolder getCells(int i, int j) {
        return cells[i][j];
    }

    public void SetCells (int a, int i, int j)
    {
        cells[i][j].getCell().setValue(a);
    }

    @Override
    public int getSize() {
        return size;
    }
    @Override
    public Cell[][] getFieldState() {
        Cell[][] cellsMatrix = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cellsMatrix[i][j] = cells[i][j].getCell();
            }
        }
        return cellsMatrix;
    }

    public void generateCell() {
        if (isFullFilled())
        {
            return;
        }
        boolean placed = false;
        int cellValue = (random.nextInt(2) + 1) * 2; // 2 or 4

        while (!placed) {
            int rightPosition = random.nextInt(size);
            int downPosition = random.nextInt(size);
            CellHolder targetHolder = cells[rightPosition][downPosition];
            if (targetHolder.isEmpty()) {
                targetHolder.setCell(new Cell(cellValue));
                placed = true;
            }
        }
    }

    @Override
    public void moveRight() {
        move(horizontalLines, MoveDirection.RIGHT);
    }
    @Override
    public void moveDown() {
        move(verticalLines, MoveDirection.RIGHT);
    }
    @Override
    public void moveLeft() {
        move(horizontalLines, MoveDirection.LEFT);
    }
    @Override
    public void moveUp() {
        move(verticalLines, MoveDirection.LEFT);
    }

    private void move(LineHolder[] holders, MoveDirection direction) {
        boolean moved = false;
        for (LineHolder holder :
                holders) {
            switch (direction) {
                case LEFT:
                    moved |= holder.moveCellsLeft();
                    break;
                case RIGHT:
                    moved |= holder.moveCellsRight();
                    break;
            }
        }
        if (moved) {
            generateCell();
        }
    }
    @Override
    public boolean isMoveAvailable() {
        boolean moveAvailable = false;
        for (LineHolder holder: verticalLines) {
            moveAvailable |= holder.isMoveAvailable();
        }
        for (LineHolder holder: horizontalLines) {
            moveAvailable |= holder.isMoveAvailable();
        }
        return moveAvailable;
    }

    private boolean isFullFilled() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append('|');
            for (int j = 0; j < size; j++) {
                builder.append(cells[i][j]).append("|");
            }
            builder.append('\n');
            builder.append('\n');
        }
        return builder.toString();
    }
    private enum MoveDirection {
        LEFT,
        RIGHT
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Game2048\LineHolder.java
```java
package com.company.Game2048;

import java.util.Arrays;

public class LineHolder {
    private CellHolder[] cellsLine;

    public LineHolder(int size) {
        cellsLine = new CellHolder[size];
    }

    public void setHolder(int position, CellHolder holder) {
        cellsLine[position] = holder;
    }

    public boolean moveCellsLeft() {
        boolean moved = false;
        for (int i = 0; i < cellsLine.length - 1; i++) {
            moved |= workWithCell(i, 1);
        }
        return moved;
    }

    public boolean moveCellsRight() {
        boolean moved = false;
        for (int i = cellsLine.length - 1; i > 0; i--) {
            moved |= workWithCell(i, -1);
        }
        return moved;
    }

    public boolean isMoveAvailable() {
        for (int i =0; i < cellsLine.length - 1; i++) {

            CellHolder currentCell = cellsLine[i];
            if (currentCell.isEmpty()) {
                return true;
            }
            CellHolder nearCell = cellsLine[i + 1];
            if (!nearCell.isEmpty() && currentCell.getCell().getValue() == nearCell.getCell().getValue()) {
                return true;
            }
        }
        return false;
    }

    private boolean workWithCell(int cellIndex, int step) {
        CellHolder to = cellsLine[cellIndex];
        boolean moved = false;
        if (to.isEmpty()) { // move
            for (int i = cellIndex; i < cellsLine.length && i >= 0; i += step) {
                CellHolder from = cellsLine[i];
                if (!from.isEmpty()) {
                    to.setCell(from.popCell());
                    moved = true;
                    break;
                }
            }
        }
        if (!to.isEmpty()) {
            int toValue = to.getCell().getValue();
            for (int i = cellIndex + step; i < cellsLine.length && i >= 0; i += step) { // sum
                CellHolder from = cellsLine[i];
                if (!from.isEmpty())
                {
                    if (toValue == from.getCell().getValue())
                    {
                        to.setCell(from.popCell().multiply());
                        moved = true;
                    }
                    break;
                }
            }
        }
        return moved;
    }

    @Override
    public String toString() {
        return "LineHolder{" +
                "cellsLine=" + Arrays.toString(cellsLine) +
                '}';
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Game2048\Main.java
```java
package com.company.Game2048;

import com.company.Game2048.player.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Worst worst = new Worst();
        GameField gameField = new GameField(4);
        GameField gameField1 = new GameField(4);
        ArrayList<Massiv> objects = new ArrayList<>();
        Massiv winner;
        int[][] array = new int[4][4];
        gameField.generateCell();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (gameField.getCells(i, j).getCell() != null)
                    array[i][j] = gameField.getCells(i, j).getCell().getValue();
            }
        }
        int q = 0;
        do {
            for (int k = 0; k < 1000; k++) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (array[i][j] != 0) {
                            CellHolder target = gameField1.getCells(i, j);
                            target.setCell(new Cell(array[i][j]));
                        }
                    }
                }
                winner = new Massiv();
                objects.add(winner);
                Game2048Player player1 = new Random2048Player(gameField1);
                player1.startGame(worst, winner, gameField1);
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (gameField1.getCells(i, j).getCell() != null)
                            winner.SummaAdd(gameField1.getCells(i, j).getCell().getValue());
                    }
                }
                gameField1 = new GameField(4);
            }
            int t = 0;
            int p = 0;
            for (int i = 0; i < objects.size(); i++)
            {
                if (objects.get(i).GetSumma() > t)
                {
                    t = objects.get(i).GetSumma();
                    p = i;
                }
            }
            array = new int[4][4];
            int i = 0;
                for (int j = 0; j < 4; j++)
                {
                    for (int k = 0; k < 4; k++)
                    {
                        array[j][k] = objects.get(p).getSimbols(i);
                        System.out.print(objects.get(p).getSimbols(i) + "\t");
                        i = i + 1;
                    }
                    System.out.println();
                }
            System.out.println("________________");
            for (int w = 0; w < 4; w++)
            {
                for (int e = 0; e < 4; e++)
                {
                    if (array[w][e] == 2048) q = 1;
                }
            }
            objects.clear();
        } while (q != 2);
        System.out.println("You are Winner!");

    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Game2048\Massiv.java
```java
package com.company.Game2048;

import java.util.ArrayList;

public class Massiv {
    ArrayList<Integer> Summa = new ArrayList<>();
    ArrayList<Integer> Simbols = new ArrayList<>();
    public void SummaAdd(int value)
    {
        Summa.add(value);
    }

    public void SimbolsAdd(int value)
    {
        Simbols.add(value);
    }

    public int getSimbols(int i)
    {
        return Simbols.get(i);
    }


    public int GetSumma()
    {
        int s = 0;
        for (int i = 0; i < Summa.size(); i++)
        {
            s = s + Summa.get(i);
        }
        return s;
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Game2048\player\Console2048Player.java
```java
package com.company.Game2048.player;

import java.util.Scanner;

import com.company.Game2048.Game2048Field;
import com.company.Game2048.Game2048Player;
import com.company.Game2048.Massiv;

public class Console2048Player extends Game2048Player {
    private final Scanner scanner;

    public Console2048Player(Game2048Field game2048Field) {
        super(game2048Field);
        scanner = new Scanner(System.in);
    }

    @Override
    protected void step() {
        String line = scanner.nextLine();
        switch (line) {
            case "w":
                game2048Field.moveUp();
                break;
            case "d":
                game2048Field.moveRight();
                break;
            case "s":
                game2048Field.moveDown();
                break;
            case "a":
                game2048Field.moveLeft();
                break;
        }
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Game2048\player\Random2048Player.java
```java
package com.company.Game2048.player;

import com.company.Game2048.Game2048Field;
import com.company.Game2048.Game2048Player;
import com.company.Game2048.Massiv;

import java.util.Random;

public class Random2048Player extends Game2048Player {
    private Random random = new Random();
    public Random2048Player(Game2048Field game2048Field) {
        super(game2048Field);
    }

    @Override
    protected void step() {
        switch (random.nextInt(5)) {
            case 0:
                game2048Field.moveRight();
                break;
            case 1:
                game2048Field.moveDown();
                break;
            case 2:
                game2048Field.moveLeft();
                break;
            case 3:
                game2048Field.moveUp();
                break;
        }
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Game2048\Worst.java
```java
package com.company.Game2048;

public class Worst {
    public void Test(Massiv winner, GameField gameField1)
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (gameField1.getCells(i, j).getCell() != null)
                    winner.SimbolsAdd(gameField1.getCells(i, j).getCell().getValue());
                else winner.SimbolsAdd(0);
            }
        }
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Main.java
```java
package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice10\Window.java
```java
package com.company.Practice10;

public class Window {
    public static void main(String[] args) {
        new WindowWork().Start();
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice10\WindowWork.java
```java
package com.company.Practice10;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.Random;

public class WindowWork  {
    private final Random random = new Random();
    public void Start()
    {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setResizable(true);
        jFrame.setSize(500 ,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jFrame.add(jPanel);
        JButton jButton = new JButton("+");
        JButton jButton1 = new JButton("-");
        JButton jButton2 = new JButton("*");
        JButton jButton3 = new JButton("/");
        jButton.setBounds(50,100,50,50);
        jButton1.setBounds(150,100,50,50);
        jButton2.setBounds(250,100,50,50);
        jButton3.setBounds(350,100,50,50);
        JTextField jTextField = new JTextField();
        JTextField jTextField1 = new JTextField();
        jTextField.setBounds(175,50,100,20);
        jTextField1.setBounds(175,180,100,20);
        JLabel jLabel = new JLabel();
        jLabel.setText("");
        jLabel.setBounds(175, 300, 1000, 20);
        jPanel.add(jLabel);
        jPanel.add(jTextField);
        jPanel.add(jTextField1);
        jPanel.add(jButton);
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    double a = Double.parseDouble(jTextField.getText());
                    double b = Double.parseDouble(jTextField1.getText());
                    double scale = Math.pow(10, 4);
                    jLabel.setText("Результат: " + String.valueOf((Math.round((a + b) * scale))/scale));
                    jTextField.setText("");
                    jTextField1.setText("");
                }
                catch (Exception ex)
                {
                    jLabel.setText("Введите корректные данные");
                }
            }
        });
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    double a = Double.parseDouble(jTextField.getText());
                    double b = Double.parseDouble(jTextField1.getText());
                    double scale = Math.pow(10, 4);
                    jLabel.setText("Результат: " + String.valueOf((Math.round((a - b) * scale))/scale));
                    jTextField.setText("");
                    jTextField1.setText("");
                }
                catch (Exception ex)
                {
                    jLabel.setText("Введите корректные данные");
                }
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    double a = Double.parseDouble(jTextField.getText());
                    double b = Double.parseDouble(jTextField1.getText());
                    double scale = Math.pow(10, 4);
                    jLabel.setText("Результат: " + String.valueOf((Math.round((a * b) * scale))/scale));
                    jTextField.setText("");
                    jTextField1.setText("");
                }
                catch (Exception ex)
                {
                    jLabel.setText("Введите корректные данные");
                }
            }
        });
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(jTextField.getText());
                    double b = Double.parseDouble(jTextField1.getText());
                    double scale = Math.pow(10, 4);
                    if (b == 0) jLabel.setText("Введите корректные данные");
                    else {
                        jLabel.setText("Результат: " + String.valueOf((Math.round((a / b) * scale)) / scale));
                        jTextField.setText("");
                        jTextField1.setText("");
                    }
                }
                catch (Exception ex)
                {
                    jLabel.setText("Введите корректные данные");
                }
                }
        });
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice11\Main.java
```java
package com.company.Practice11;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static long totalSum;
    static long totalFinal;
    static AtomicInteger totalFac = new AtomicInteger(0);
    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i <  10; i++){
            final int localI = i;
            Thread thread = new Thread(() -> work(localI));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            System.out.println(t.getState());
            t.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);
        System.out.println("total fac: " + totalFac);
        System.out.println("total final: " + totalFinal);
    }

    private static void work(int i) {
        long startTime = System.currentTimeMillis();
        long result = doHardWork(i * 1000, 100_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime-startTime));
    }

    private synchronized static long doHardWork(int start, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * (start + i) * Math.sqrt(start + i);
            doFinalWork();
            doFacIn();
            doFacWork();
        }
        return a;
    }

    private synchronized static void doFacIn()
    {
        totalSum++;
    }

    private static void doFacWork()
    {
        totalFac.getAndIncrement();
    }

    private static void doFinalWork()
    {
        lock.lock();
        totalFinal++;
        lock.unlock();
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice12\Enum.java
```java
package com.company.Practice12;

public enum Enum {
    ANSI_RESET("\u001B[0m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_BLACK("\u001B[30m"),
    ANSI_WHITE("\u001B[30m"),
    ANSI_CYAN("\u001B[36m"),
    ANSI_RED("\u001B[31m"),
    ANSI_YELLOW("\u001B[33m"),
    ANSI_BLUE("\u001B[34m");

    private String color;

    Enum(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice12\Main.java
```java
package com.company.Practice12;

import java.util.Random;

public class Main {
    private static Random r = new Random();
    private static Enum[] anEnum = Enum.values();
    public static void main(String[] args) {
        RandomColors("TTTTTTTTTT");
        SelectColor("TTTTTTTTTT", Enum.ANSI_CYAN);
    }

    public static void RandomColors(String s)
    {
        char[] result = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            System.out.print(anEnum[r.nextInt(anEnum.length)].getColor() + result[i]);
        }
        System.out.println();
    }

    public static void SelectColor(String s, Enum color)
    {
        System.out.println(color.getColor() + s);
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice13\Car.java
```java
package com.company.Practice13;

public class Car {
    private int cost;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) throws NegEx, CostEx {
        if (cost < 0)
        {
            throw new NegEx();
        }
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cost=" + cost +
                '}';
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice13\CostEx.java
```java
package com.company.Practice13;

public class CostEx extends RuntimeException{
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice13\Main.java
```java
package com.company.Practice13;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Car item = new Car();
        try{
            int cost = Integer.parseInt(in.nextLine());
            item.setCost(cost);
            System.out.println("Cost is: " + cost);
        }
        catch (NegEx nce) {
            System.out.println("Cost is negative!");
        }
        catch(NumberFormatException nfe) {
            System.out.println("Incorrect input");
        }
        catch(Exception ex)
        {
            System.out.println("Error");
        }
        finally {
            System.out.println(item);
        }

        throw new CostEx();
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice13\NegEx.java
```java
package com.company.Practice13;

public class NegEx extends IllegalArgumentException{
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice14\Main.java
```java
package com.company.Practice14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int N = scanner.nextInt();
        String t = scanner.nextLine();
        int N = Integer.parseInt(t);
        String[] Regex = new String[N];
        String[] Symbols = new String[N];
        for (int i = 0; i < N; i++) {
            Regex[i] = scanner.next();
            Symbols[i] = scanner.next();
        }
        String s = scanner.next();
        //RegexS(Regex, Symbols, s);
        NotRegexS(Regex, Symbols, s, N);
    }

    public static void RegexS(String[] Regex, String[] Symbols, String s) {
        Pattern pattern;
        Matcher matchers;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < Regex.length; j++) {
                if (i + Regex[j].length() < s.length()) {
                    pattern = Pattern.compile(Regex[j]);
                    matchers = pattern.matcher(s.substring(i, i + Regex[j].length()));
                    if (matchers.find()) {
                        s = s.substring(0, i) + matchers.replaceFirst(Symbols[j] + "|") + s.substring(i + Regex[j].length());
                        i += Symbols[j].length() - 1;
                    }
                }
            }
        }
        pattern = Pattern.compile("\\|");
        matchers = pattern.matcher(s);
        s = matchers.replaceAll("");
        System.out.print(s);
    }

    public static void NotRegexS(String[] Regex, String[] Symbols, String s, int N) {
        String to_out = "";
        for (int i = 0; i < s.length(); i++) {
            int flag = 0;
            for (int j = 0; j < N; j++) {
                if (i + Regex[j].length() <= s.length()) {
                    String key = s.substring(i, i + Regex[j].length());
                    if (Regex[j].equals(key)) {
                        flag = 1;
                        //s = s.replace(Regex[j], Symbols[j] + "");
                        to_out += Symbols[j];
                        i += Regex[j].length() - 1;
                    }
                }
            }
            if (flag == 0)
            {
                to_out += s.charAt(i);
            }
        }
        //s = s.replaceAll(" ", "");
        System.out.print(to_out);
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice14\Regex.java
```java
package com.company.Practice14;

import java.util.ArrayList;

public class Regex {
    private String regex;
    private String symbol;
    private int start;
    private int end;

    public void setEnd(int end) {
        this.end = end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public void setRegex(String a)
    {
        regex = a;
    }

    public String getRegex()
    {
        return regex;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice15\Main.java
```java
package com.company.Practice15;

public class Main {
    public static void main(String[] args) {
        S1 s1 = new S1();
        s1.Action();
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice15\S1.java
```java
package com.company.Practice15;

import java.util.Scanner;

public class S1 {
    private static Scanner in = new Scanner(System.in);
    private String actionForZero = "create_project";
    private String actionForOne = "add_library";

    public void setActionForOne(String actionForOne) {
        this.actionForOne = actionForOne;
    }

    public void setActionForZero(String actionForZero) {
        this.actionForZero = actionForZero;
    }

    public String getActionForOne() {
        return actionForOne;
    }

    public String getActionForZero() {
        return actionForZero;
    }

    public void Action()
    {
        int s = Integer.parseInt(in.nextLine());
        if (s == 0)
        {
            System.out.println(actionForZero);
            S2 s2 = new S2();
            s2.Action();
        }
        if (s == 1)
        {
            System.out.println(actionForOne);
            S5 s5 = new S5();
            s5.Action();
        }

    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice15\S2.java
```java
package com.company.Practice15;

import java.util.Scanner;

public class S2 {
    private static Scanner in = new Scanner(System.in);
    private String actionForZero = "test";
    private String actionForOne = "drop_db";

    public void setActionForOne(String actionForOne) {
        this.actionForOne = actionForOne;
    }

    public void setActionForZero(String actionForZero) {
        this.actionForZero = actionForZero;
    }

    public String getActionForOne() {
        return actionForOne;
    }

    public String getActionForZero() {
        return actionForZero;
    }

    public void Action()
    {
        int s = Integer.parseInt(in.nextLine());
        if (s == 0)
        {
            System.out.println(actionForZero);
            S3 s3 = new S3();
            s3.Action();
        }
        if (s == 1)
        {
            System.out.println(actionForOne);
            S4 s4 = new S4();
            s4.Action();
        }
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice15\S3.java
```java
package com.company.Practice15;

import java.util.Scanner;

public class S3 {
    private static Scanner in = new Scanner(System.in);
    private String actionForZero = "drop_db";
    private String actionForOne = "add_library";

    public void setActionForOne(String actionForOne) {
        this.actionForOne = actionForOne;
    }

    public void setActionForZero(String actionForZero) {
        this.actionForZero = actionForZero;
    }

    public String getActionForOne() {
        return actionForOne;
    }

    public String getActionForZero() {
        return actionForZero;
    }

    public void Action()
    {
        int s = Integer.parseInt(in.nextLine());
        if (s == 0)
        {
            System.out.println(actionForZero);
            S4 s4 = new S4();
            s4.Action();
        }
        if (s == 1) {
            System.out.println(actionForOne);
            S5 s5 = new S5();
            s5.Action();
        }
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice15\S4.java
```java
package com.company.Practice15;

import java.util.Scanner;

public class S4 {
    private static Scanner in = new Scanner(System.in);
    private String actionForZero = "restart";
    private String actionForOne = "deploy";

    public void setActionForOne(String actionForOne) {
        this.actionForOne = actionForOne;
    }

    public void setActionForZero(String actionForZero) {
        this.actionForZero = actionForZero;
    }

    public String getActionForOne() {
        return actionForOne;
    }

    public String getActionForZero() {
        return actionForZero;
    }

    public void Action()
    {
        int s = Integer.parseInt(in.nextLine());
        if (s == 0)
        {
            System.out.println(actionForZero);
            S3 s3 = new S3();
            s3.Action();
        }
        if (s == 1)
        {
            System.out.println(actionForOne);
            S5 s5 = new S5();
            s5.Action();
        }
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice15\S5.java
```java
package com.company.Practice15;

import java.util.Scanner;

public class S5 {
    private static Scanner in = new Scanner(System.in);
    private String actionForZero = "deploy";
    private String actionForOne = "restart";

    public void setActionForOne(String actionForOne) {
        this.actionForOne = actionForOne;
    }

    public void setActionForZero(String actionForZero) {
        this.actionForZero = actionForZero;
    }

    public String getActionForOne() {
        return actionForOne;
    }

    public String getActionForZero() {
        return actionForZero;
    }

    public void Action()
    {
        int s = Integer.parseInt(in.nextLine());
        if (s == 0)
        {
            System.out.println(actionForZero);
            S1 s1 = new S1();
            s1.Action();
        }
        if (s == 1)
        {
            System.out.println(actionForOne);
            S3 s3 = new S3();
            s3.Action();
        }
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice17_18\Main.java
```java
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
```
### Работа с путем D:\Java_Prac\src\com\company\Practice2\Ball.java
```java
package com.company.Practice2;

public class Ball {
    private double R;
    private double S;
    public void SetR(double R)
    {
        this.R = R;
    }

    public void SetS(double S)
    {
        this.S = S;
    }

    @Override
    public String toString() {
        S = 4*3*R*R;
        return "Ball{" +
                "R=" + R +
                ", S=" + S +
                '}';
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice2\Book.java
```java
package com.company.Practice2;

public class Book {
    private int Str;
    private String Author;
    private String Name;
    public void SetSettings(int Str, String Author, String Name)
    {
        this.Str = Str;
        this.Author = Author;
        this.Name = Name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Str=" + Str +
                ", Author='" + Author + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice2\Dog.java
```java
package com.company.Practice2;

public class Dog {
    private String Name;
    private int Age;
    public Dog(){}
    public Dog(String Name, int Age) {
        this.Name = Name;
        this.Age = Age;
    }
    public void SetName(String Name)
    {
        this.Name = Name;
    }
    public void SetAge(int Age)
    {
        this.Age = Age;
    }
    public String GetName()
    {
        return Name;
    }
    public int GetAge()
    {
        return Age;
    }
    @Override
    public String toString() {
        return "Dog{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                '}';
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice2\HouseDog.java
```java
package com.company.Practice2;


public class HouseDog {
        private Dog[] Massiv = new Dog[10];
        private int t = 0;

        public void DogHouse(Dog dog) {
            Massiv[t] = dog;
            t++;
            System.out.println("Принято");
        }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice2\Main.java
```java
package com.company.Practice2;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);


        Shape Test = new Shape();
		System.out.println("Enter Shape");
		String S = in.nextLine();
		Test.Form(S);


	    Ball Test1 = new Ball();
	    System.out.println("Enter Radius");
	    double R = in.nextDouble();
	    Test1.SetR(R);


	    Book Test2 = new Book();
	    System.out.println("Enter Settings of Book");
		System.out.println("Enter Str");
	    int Str = in.nextInt();
		System.out.println("Enter Author");
		String Author1 = in.nextLine();
	    String Author = in.nextLine();
		System.out.println("Enter Name");
	    String Name = in.nextLine();
	    Test2.SetSettings(Str, Author, Name);


	    HouseDog Test3 = new HouseDog();
	    Dog a = new Dog();
	    Test3.DogHouse(a);
	    a.SetAge(1);
	    a.SetName("Pudel");
		System.out.println(Test.toString());
		System.out.println(Test1.toString());
		System.out.println(Test2.toString());
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice2\Shape.java
```java
package com.company.Practice2;

public class Shape {
    private String S;
    public void Form(String s)
    {
        this.S = s;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "S='" + S + '\'' +
                '}';
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice3\Book.java
```java
package com.company.Practice3;

import java.util.Scanner;

public class Book {
    Scanner in = new Scanner(System.in);
    private int Year;
    private String Name;
    private String Name1;
    public void SetYear()
    {
        System.out.println("Enter Year");
        int a = in.nextInt();
        this.Year = a;
    }

    public void setName() {

        System.out.println("Enter Name");
        String a = in.nextLine();
        this.Name = a;
    }

    public void setName1() {
        System.out.println("Enter author");
        String a = in.nextLine();
        this.Name1 = a;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Year=" + Year +
                ", Name='" + Name + '\'' +
                ", Name1='" + Name1 + '\'' +
                '}';
    }

    public int GetYear()
    {
        return Year;
    }
    public String GetName()
    {
        return Name;
    }
    public String GetName1()
    {
        return Name1;
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice3\BookTest.java
```java
package com.company.Practice3;

public class BookTest {
    public static void main(String[] args) {
        Book Test = new Book();
        Test.setName();
        Test.SetYear();
        Test.setName1();
        System.out.println(Test.toString());
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice3\Circle.java
```java
package com.company.Practice3;

public class Circle {
    private int Radius = 10;
    private int Diameter;
    private int C;
    private int Square;
    public void SetR(int a)
    {
        Radius = a;
    }
    public int GetR()
    {
        return Radius;
    }
    public int GetD()
    {
        return Radius*2;
    }
    public int GetC()
    {
        return 2*3*Radius;
    }
    public int GetS()
    {
        return 3*Radius*Radius;
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice3\CircleTest.java
```java
package com.company.Practice3;

import java.util.Scanner;

public class CircleTest {
    public static void main(String[] args) {
        Circle Test = new Circle();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 1 if you want to enter information, else enter 2");
        int A = in.nextInt();
        if (A == 1)
        {
            System.out.println("Enter Radius");
            int Radius = in.nextInt();
            Test.SetR(Radius);
        }
        System.out.println("Information: \nRadius: " + Test.GetR() + "\nSquare: " + Test.GetS() + "\nC: " + Test.GetC() + "\nDiameter: " + Test.GetD());
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice3\Hand.java
```java
package com.company.Practice3;

import java.util.Scanner;

public class Hand {
    private int Length;

    public int getLength() {
        return Length;
    }

    public void setLength(int length) {
        Length = length;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "Length=" + Length +
                '}';
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice3\Head.java
```java
package com.company.Practice3;

import java.util.Scanner;

public class Head {
    private int IQ;

    public int getIQ() {
        return IQ;
    }

    public void setIQ(int IQ) {
        this.IQ = IQ;
    }

    @Override
    public String toString() {
        return "Head{" +
                "IQ=" + IQ +
                '}';
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice3\Human.java
```java
package com.company.Practice3;

public class Human {
    private Hand hand;
    private Head head;
    private Leg leg;
    private int age;

    public void SetHand(Hand hand)
    {
        this.hand = hand;
    }

    public void SetHead(Head head)
    {
        this.head = head;
    }

    public void SetLeg(Leg leg)
    {
        this.leg = leg;
    }

    public Hand GetHand()
    {
        return hand;
    }

    public Head GetHead()
    {
        return head;
    }

    public Leg GetLeg()
    {
        return leg;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "hand=" + hand +
                ", head=" + head +
                ", leg=" + leg +
                '}';
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice3\Leg.java
```java
package com.company.Practice3;

import java.util.Scanner;

public class Leg {
    private int Length;

    public int getLength() {
        return Length;
    }

    public void setLength(int length) {
        Length = length;
    }

    @Override
    public String toString() {
        return "Leg{" +
                "Length=" + Length +
                '}';
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice3\Main.java
```java
package com.company.Practice3;

public class Main {

    public static void main(String[] args) {
        Human human = new Human();
        human.setAge(19);
        human.getAge();
        human.SetHand(new Hand());

    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice4\Circle.java
```java
package com.company.Practice4;

public class Circle extends Shape {
    protected double Radius = 25;
    public Circle()
    {
    }
    Circle(double radius)
    {
        this.Radius = radius;
    }
    Circle(double radius, String color, boolean filled)
    {
        super(color, filled);
        this.Radius = radius;
    }
    public double GetRadius()
    {
        return Radius;
    }
    public void SetRadius(double a)
    {
        Radius = a;
    }

    @Override
    public double GetArea() {
        return 3.14*3.14*Radius;
    }

    @Override
    public double GetPerimeter() {
        return 2*3.14*Radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "Radius=" + Radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice4\Main.java
```java
package com.company.Practice4;

public class Main {

    public static void main(String[] args) {
        Rectangle G = new Rectangle();
        System.out.println(G.GetArea() + G.GetLength() + G.GetPerimeter());
        Square H = new Square(4);
        System.out.println(H.toString() + H.GetPerimeter());
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice4\Rectangle.java
```java
package com.company.Practice4;

class Rectangle extends Shape {
    protected double width = 3;
    protected double length = 4;
    Rectangle()
    {

    }
    Rectangle(double width, double length)
    {
        this.length = length;
        this.width = width;
    }
    Rectangle(double width, double length, String color, boolean filled)
    {
        super(color, filled);
        this.filled = filled;
        this.length = length;
        this.width = width;
    }
    public double GetWidth()
    {
        return width;
    }
    public void SetWidth(double a)
    {
        width = a;
    }
    public double GetLength()
    {
        return length;
    }
    public void SetLength(double a)
    {
        length = a;
    }
    @Override
    public double GetArea() {
        return length*width;
    }

    @Override
    public double GetPerimeter() {
        return 2*(length+width);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice4\Shape.java
```java
package com.company.Practice4;

public abstract class Shape {
    protected String color = "black";
    protected boolean filled = true;
    Shape(){}
    Shape(String color, boolean filled)
    {
        this.filled = filled;
        this.color = color;
    }

    public String GetColor()
    {
        return color;
    }
    public void SetColor(String a)
    {
        color = a;
    }
    public boolean isFilled()
    {
        return filled;
    }
    public void SetFilled(boolean a)
    {
        filled = a;
    }
    public abstract double GetArea();
    public abstract double GetPerimeter();
    public abstract String toString();
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice4\Square.java
```java
package com.company.Practice4;

class Square extends Shape {
    protected double side = 5;
    Square()
    {

    }
    Square(double side)
    {
        this.side = side;
    }
    Square(double side, String color, boolean filled)
    {
        super(color, filled);
        this.side = side;
    }
    public void SetSide(double a)
    {
        side = a;
    }

    @Override
    public double GetArea() {
        return side*side;
    }

    @Override
    public double GetPerimeter() {
        return 4*side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice5\Main.java
```java
package com.company.Practice5;

public class Main {

    public static void main(String[] args) {
        MovablePoint Test1 = new MovablePoint();
        MovableCircle Test2 = new MovableCircle(new MovablePoint(2,4,5,1));
        MovableRectangle Points = new MovableRectangle(new MovablePoint(1, 2, 3, 4), new MovablePoint(4, 5, 2 ,1));
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice5\Movable.java
```java
package com.company.Practice5;

public interface Movable {
    public void moveUp();
    public void moveDown();
    public void moveLeft();
    public void moveRight();
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice5\MovableCircle.java
```java
package com.company.Practice5;


import com.company.Practice4.Circle;

public class MovableCircle extends Circle implements Movable {
    private MovablePoint Move;
    MovableCircle(MovablePoint Move)
    {
        this.Move = Move;
    }

    public int getX() {
        return Move.getX();
    }

    public int getY() {
        return Move.getY();
    }

    public void setX(int x)
    {
        Move.setX(x);
    }

    public void setY(int y)
    {
        Move.setY(y);
    }

    public void moveUp() {
        Move.moveUp();
    }


    public void moveDown() {
        Move.moveDown();
    }


    public void moveLeft() {
        Move.moveLeft();
    }


    public void moveRight() {
        Move.moveRight();
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice5\MovablePoint.java
```java
package com.company.Practice5;

public class MovablePoint implements Movable {
    private int x;
    private int y;
    private int dx;
    private int dy;
    MovablePoint(){}
    MovablePoint(int x, int y, int dx, int dy)
    {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveUp() {
        this.y = this.y + dy;
    }

    public void moveDown() {
        this.y = this.y - dy;
    }

    public void moveLeft() {
        this.x = this.x - dx;
    }

    public void moveRight() {
        this.x = this.x + dx;
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice5\MovableRectangle.java
```java
package com.company.Practice5;

public class MovableRectangle implements Movable {
    private MovablePoint P1;
    private MovablePoint P2;

    MovableRectangle(MovablePoint P1, MovablePoint P2)
    {
        this.P1 = P1;
        this.P2 = P2;
    }

    public MovablePoint getP1() {
        return P1;
    }

    public MovablePoint getP2() {
        return P2;
    }

    public int GetLength()
    {
        return Math.abs(P1.getX() - P2.getX());
    }
    public int GetWidth()
    {
        return Math.abs(P1.getY() - P2.getY());
    }
    public void SetLength(int Length)
    {
        P1.setX(0);
        P2.setX(Length);
    }
    public void SetWidth(int Width)
    {
        P1.setY(0);
        P2.setY(Width);
    }
    @Override
    public void moveDown() {
        P1.moveDown();
        P2.moveDown();
    }

    @Override
    public void moveLeft() {
        P1.moveLeft();
        P2.moveLeft();
    }

    @Override
    public void moveRight() {
        P1.moveRight();
        P1.moveRight();
    }

    @Override
    public void moveUp() {
        P1.moveUp();
        P2.moveUp();
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice6\Main.java
```java
package com.company.Practice6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        SorryMyLife Fun = new SorryMyLife(N);
        Fun.F(N);
        Fun.Summa(N);
        Fun.Exit(N);
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice6\Massiv.java
```java
package com.company.Practice6;

import java.util.ArrayList;

public class Massiv {
    private int a;
    private ArrayList<Integer> objects = new ArrayList<>();
    Massiv(){}
    public void AddObject(int x, int y)
    {
        objects.add(x + y);
    }
    public int GetObject(int i)
    {
        return objects.get(i);
    }
    public int GetA()
    {
        return a;
    }
    public void SetA(int a)
    {
        this.a = a;
    }
    public int GetLength()
    {
        return objects.size();
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice6\SorryMyLife.java
```java
package com.company.Practice6;

import java.util.Scanner;

public class SorryMyLife {
    private Scanner in = new Scanner(System.in);
    private Massiv[][] array;
    SorryMyLife(int N)
    {
        array = new Massiv[N][N];
    }
    public void F(int N)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                array[i][j] = new Massiv();
                array[i][j].SetA(in.nextInt());
            }
        }
    }
    public void Summa(int N)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if ((i == 0) && (j == 0)) {
                    if ((j + 1) != N) {
                        array[i][j + 1].AddObject(array[i][j].GetA(), array[i][j + 1].GetA());
                    }
                    if ((i + 1) != N) {
                        array[i + 1][j].AddObject(array[i][j].GetA(), array[i + 1][j].GetA());
                    }
                }
                else {
                    if ((j + 1) != N) {
                        for (int k = 0; k < array[i][j].GetLength(); k++) {
                            array[i][j + 1].AddObject(array[i][j].GetObject(k), array[i][j + 1].GetA());
                        }
                    }
                    if ((i + 1) != N) {
                        for (int k = 0; k < array[i][j].GetLength(); k++) {
                            array[i + 1][j].AddObject(array[i][j].GetObject(k), array[i + 1][j].GetA());
                        }
                    }
                }
            }
        }
    }
    public void Exit(int N)
    {
        int Q = 0;
        for (int i = 0; i < array[N - 1][N - 1].GetLength(); i++)
        {
            System.out.println(array[N - 1][N - 1].GetObject(i));
            if (Q < array[N - 1][N - 1].GetObject(i))
            {
                Q = array[N - 1][N - 1].GetObject(i);
            }
        }
        System.out.println("Answer: " + Q);
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice7_8\Company.java
```java
package com.company.Practice7_8;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private ArrayList<Employee> Listt = new ArrayList<>();
    private double Summa = 0;


    public void hire(Employee employee) {
        Listt.add(employee);
    }


    public void fire(int i) {
        Listt.remove(i);
        getIncome();
    }


    public double getIncome() {
        this.Summa = 0;
        for (Employee emp : Listt) {
            if (emp.GetWorkPlace() instanceof Manager) {
                Summa = Summa + ((Manager) emp.GetWorkPlace()).Polza();
            }
        }
        return Summa;
    }

    List<Employee> getTopSalaryStaff(int count) {
        ArrayList<Employee> employees = Listt;
        Employee t;
        for (int i = 0; i < employees.size() - 1; i++)
            for (int j = i + 1; j < employees.size(); j++) {
                if (employees.get(i).GetWorkPlace().calcSalary(employees.get(i).getZP()) < employees.get(j).GetWorkPlace().calcSalary(employees.get(j).getZP())) {
                    t = employees.get(j);
                    employees.set(j, employees.get(i));
                    employees.set(i, t);
                }
            }
        return employees.subList(0, count);
    }

    List<Employee> getLowestSalaryStaff(int count) {
        ArrayList<Employee> employees = Listt;
        Employee t;
        for (int i = 0; i < employees.size() - 1; i++)
            for (int j = i + 1; j < employees.size(); j++) {
                if (employees.get(i).GetWorkPlace().calcSalary(employees.get(i).getZP()) > employees.get(j).GetWorkPlace().calcSalary(employees.get(j).getZP())) {
                    t = employees.get(j);
                    employees.set(j, employees.get(i));
                    employees.set(i, t);
                }
            }
        return employees.subList(0, count);
    }

    public int getListSize() {
        return Listt.size();
    }

    public void hireAll(ArrayList<Employee> listEmployee) {
        Listt.addAll(listEmployee);
    }

    public void fire(Employee employee) {
        Listt.remove(employee);
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice7_8\Employee.java
```java
package com.company.Practice7_8;

public class Employee {
    private String Name;
    private String Surname;
    private double ZP;
    private EmployeePosition WorkPlace;

    public Employee(String name, String Surname, int ZP, EmployeePosition WorkPlace) {
        this.Name = name;
        this.Surname = Surname;
        this.ZP = ZP;
        this.WorkPlace = WorkPlace;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public double getZP() {
        return ZP;
    }

    public void setZP(double ZP) {
        this.ZP = ZP;
    }

    public EmployeePosition GetWorkPlace() {
        return WorkPlace;
    }

    public void setPosition(EmployeePosition WorkPlace) {
        this.WorkPlace = WorkPlace;
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice7_8\EmployeePosition.java
```java
package com.company.Practice7_8;

public interface EmployeePosition {
    String getJobTitle();
    double calcSalary(double ZP);
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice7_8\Manager.java
```java
package com.company.Practice7_8;

import java.util.Random;

public class Manager implements EmployeePosition {
    private Random random = new Random();
    private int Money = 0;

    public int Polza() {
        Money = random.nextInt(140000 - 115000) + 115000;
        return Money;
    }
    

    @Override
    public double calcSalary(double ZP) {
        return ZP + Money * 0.05;
    }

    @Override
    public String getJobTitle() {
        return "Manager";
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice7_8\Operator.java
```java
package com.company.Practice7_8;

public class Operator implements EmployeePosition {


    @Override
    public double calcSalary(double ZP) {
        return ZP;
    }

    @Override
    public String getJobTitle() {
        return "Operator";
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice7_8\TopManager.java
```java
package com.company.Practice7_8;

public class TopManager implements EmployeePosition {
    Company company;

    public TopManager(Company company) {
        this.company = company;
    }


    @Override
    public double calcSalary(double ZP) {
        double t = 0;
        if (company.getIncome() >= 10000000)
        {
            t = ZP * 1.5;
        }
        return ZP + t;
    }

    @Override
    public String getJobTitle() {
        return "TopManager";
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice7_8\Work.java
```java
package com.company.Practice7_8;

import java.util.List;

public class Work {
    private int money = 50000;
    private String name = "Danila";
    private String SurName = "Shikalov";
    private Company company = new Company();


    public static void main(String[] args) {
        new Work();
    }


    public Work() {
        for (int i = 0; i < 180; i++) {
            company.hire(new Employee(name, SurName, money, new Operator()));
        }
        for (int i = 0; i < 80; i++) {
            company.hire(new Employee(name, SurName, money, new Manager()));
        }
        for (int i = 0; i < 10; i++) {
            company.hire(new Employee(name, SurName, money, new TopManager(company)));
        }
        System.out.println("Доход: " + company.getIncome());
        List<Employee> list = company.getTopSalaryStaff(15);
        System.out.println("Топ-15 высоких зарплат");
        for (int i = 0; i < 15; i++) {
            System.out.println(String.valueOf((int) list.get(i).GetWorkPlace().calcSalary(list.get(i).getZP())) + "     " + list.get(i).GetWorkPlace().getJobTitle());
        }
        list = company.getLowestSalaryStaff(30);
        System.out.println("Топ-30 низких зарплат");
        for (int i = 0; i < 30; i++) {
            System.out.println(String.valueOf((int) list.get(i).GetWorkPlace().calcSalary(list.get(i).getZP())) + "     " + list.get(i).GetWorkPlace().getJobTitle());
        }
        for (int i = 0; i < company.getListSize(); i++) {
            company.fire(i);
        }
        System.out.println("Доход после увольнения: "+ company.getIncome());
        list = company.getTopSalaryStaff(15);
        System.out.println("Топ-15 высоких зарплат");
        for (int i = 0; i < 15; i++) {
            System.out.println(String.valueOf((int) list.get(i).GetWorkPlace().calcSalary(list.get(i).getZP())) + "     " + list.get(i).GetWorkPlace().getJobTitle());
        }
        list = company.getLowestSalaryStaff(30);
        System.out.println("Топ-30 низких зарплат");
        for (int i = 0; i < 30; i++) {
            System.out.println(String.valueOf((int) list.get(i).GetWorkPlace().calcSalary(list.get(i).getZP())) + "     " + list.get(i).GetWorkPlace().getJobTitle());
        }
    }
}
```
### Работа с путем D:\Java_Prac\src\com\company\Practice9\Company.java
```java
package com.company.Practice9;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> list = new ArrayList<>();

    public void handleEmployees(Employee1 employee1, Employee2 employee2){
        int t = 0;
        for (Employee employee: list) {
            if (employee2.BOOLEANSout(employee)) {
                employee1.Sout(employee, t);
                t++;
            }
        }
    }

    public void ClearAll()
   