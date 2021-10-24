package com.example.cmpt276as3.model;

import java.util.Random;

/*
GameLogic class has methods to implement the gameplay of the Game. It creates a layer of
Mine Buttons behind the UI Buttons (Randomly!).
*/

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
        addMines(numMines);

    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }


    public void addMines(int mineNum) {
        //create layer of mine buttons behind UI buttons
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                mines[i][j] = new MineLogic(false);
            }
        }
        //Random Number - Discussed with TA during office hours
        //https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
        Random rand = new Random();
        //place mines randomly
        for (int k = 0; k < numMines; k++) {
            while(mineNum != 0) {
                int col = rand.nextInt(numColumns);
                int row = rand.nextInt(numRows);
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
            if (mines[row][i].isMinePresent() == true) {
                mines[row][i].setScan();
                count++;
            }
        }
        for (int j = 0; j < numRows; j++) {
            if(mines[j][col].isMinePresent() == true) {
                mines[j][col].setScan();
                count++;
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

}
