package com.example.cmpt276as3.model;

import java.util.Random;

public class GameLogic {

    private int numRows;
    private int numColumns;
    private int numMines;

    private MineLogic[][] mines;

    public GameLogic(int numRows, int numColumns, int numMines) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.numMines = numMines;

        this.mines = new MineLogic[numRows][numColumns];
        createButtons();
        addMines(numMines);

    }

    public int getNumRows() {

        return numRows;
    }

    public int getNumColumns() {

        return numColumns;
    }

    //creates a layer of empty mine buttons behind the UI buttons
    private void createButtons() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                mines[i][j] = new MineLogic(false);
            }
        }
    }

    public void addMines(int mineNum) {
        //Random Number
        //https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
        Random rand = new Random();

        int rows = numRows;
        int cols = numColumns;

        for (int i = 0; i < numMines; i++) {

            while(mineNum != 0) {
                int col = rand.nextInt(cols);
                int row = rand.nextInt(rows);
                if(mines[row][col].isMinePresent() == false) {
                    mines[row][col].setMinePresent(true);
                    mineNum--;
                }
            }
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

    public boolean isMineVisible(int row, int col) {
        return mines[row][col].isMineVisible();
    }

    public boolean minePresent(int row, int col) {
        return mines[row][col].isMinePresent();
    }

    public boolean isMineScanned(int row, int col) {
        return mines[row][col].isMineScanned();
    }

    public boolean endGame() {
        return numMines == NumMinesFound();

    }

}
