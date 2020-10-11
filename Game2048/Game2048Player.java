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
