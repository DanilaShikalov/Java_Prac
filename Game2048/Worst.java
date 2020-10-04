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
