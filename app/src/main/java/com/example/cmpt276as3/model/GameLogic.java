package com.example.cmpt276as3.model;

import java.util.Random;

public class GameLogic {

    private int numRows;
    private int numColumns;
    private int numMines;

    private MineLogic[][] mines;

    //private OptionsLogic options = OptionsLogic.getInstance();


    public GameLogic(int numRows, int numColumns, int numMines) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.numMines = numMines;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public void SetMines(int numMines) {
        //Random Number
        //https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
        Random rand = new Random();

        //buttons = new int[numRows][numColumns];

//        for (int i = 0; i < numMines; i++) {
//            int row = rand.nextInt(numRows);
//            int col = rand.nextInt(numColumns);

        while(numMines != 0) {
            int row = rand.nextInt(numRows);
            int col = rand.nextInt(numColumns);

            if(mines[row][col].isMinePresent() == false) {
                mines[row][col] = new MineLogic(true);
            }
            numMines--;
        }
    }

    public int Scan(int row, int col) {
        int count = 0;

        for (int i = 0; i < numColumns; i++) {
            if (mines[row][i].isMineHidden() == false) {
                count++;
            }
        }
        for (int j = 0; j < numRows; j++) {
            if(mines[col][j].isMineHidden() == false) {
                count++;
            }
        }
        return count;
    }

    public int NumMinesFound() {
        int count = 0;
        for (MineLogic[] rows : mines) {
            for (MineLogic mine : rows) {
                if (mine.isMineHidden() == false) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean endGame() {
        return numMines == NumMinesFound();

    }



}
