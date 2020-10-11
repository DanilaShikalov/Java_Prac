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
