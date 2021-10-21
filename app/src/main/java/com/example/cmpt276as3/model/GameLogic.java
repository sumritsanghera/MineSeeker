package com.example.cmpt276as3.model;

import java.util.Random;

public class GameLogic {

    private int numRows;
    private int numColumns;
    private int numMines;
    private boolean minePlaced = false;

    private int[][] buttons;

    //private OptionsLogic options = OptionsLogic.getInstance();


    public GameLogic(int numRows, int numColumns, int numMines) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.numMines = numMines;
    }


    public void setMines(int mines) {
        //Random Number
        //https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
        Random rand = new Random();

        buttons = new int[numRows][numColumns];

        for (int i = 0; i < numMines; i++) {
            int row = rand.nextInt(numRows);
            int col = rand.nextInt(numColumns);

            while(numMines != 0) {
                //buttons.insert()

            }

        }
    }



}
