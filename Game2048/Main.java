package com.company.Game2048;

import com.company.Game2048.player.*;

import java.util.ArrayList;
import java.util.Set;

public class Main {
    //Massiv winner = new Massiv();
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
                //System.out.println(array[i][j]);
                //if (array[i][j] != 0)
                //System.out.println(gameField.getCells(i,j).getCell().getValue());
            }
        }
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                if (array[i][j] != 0) {
//                    CellHolder target = gameField1.getCells(i, j);
//                    target.setCell(new Cell(array[i][j]));
//                }
//            }
//        }
        int q = 0;
        do {
            for (int k = 0; k < 3; k++) {
//                for (int i = 0; i < 4; i++) {
//                    for (int j = 0; j < 4; j++) {
//                        if (gameField.getCells(i, j).getCell() != null)
//                            array[i][j] = gameField.getCells(i, j).getCell().getValue();
//                        //System.out.println(array[i][j]);
//                        //if (array[i][j] != 0)
//                        //System.out.println(gameField.getCells(i,j).getCell().getValue());
//                    }
//                }
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
                //Game2048Player player = new Random2048Player(gameField);
                Game2048Player player1 = new Random2048Player(gameField1);
                //player.startGame();
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
//            while (i != 15)
//            {
                for (int j = 0; j < 4; j++)
                {
                    for (int k = 0; k < 4; k++)
                    {
                        array[j][k] = objects.get(p).getSimbols(i);
                        System.out.println(objects.get(p).getSimbols(i));
                        i = i + 1;
                    }
                }
            //}
//            for (int u = 0;  u < 4; u++) {
//                for (int j = 0; j < 4; j++) {
//                    if (array[u][j] == 0)
//                        System.out.print("    ");
//                    else if (array[u][j] < 10)
//                        System.out.print("  " + array[u][j] + " ");
//                    else if (array[u][j] < 100)
//                        System.out.print(" " + array[u][j] + " ");
//                    else if (array[u][j] < 1000)
//                        System.out.print(" " + array[u][j]);
//                    else System.out.print("" + array[u][j]);
//                }
//                System.out.println();
//            }
//            System.out.println("______________________");
                //if (cell == null) {
//            return "    ";
//        }
//        int value = cell.getValue();
//        if (value < 10) {
//            return "  " + value + " ";
//        } else if (value < 100) {
//            return " " + value + " ";
//        } else if (value < 1000) {
//            return " " + value;
//        } else return "" + value;

            q = q + 1;
        } while (q != 1);
        for (int i = 0; i < objects.size(); i++)
        {
            objects.get(i).SimbolsPrint();
        }
    }
}
