package com.example.cmpt276as3.model;

public class OptionsLogic {

    private int DEFAULT_NUM_ROWS = 4;
    private int DEFAULT_NUM_COLS = 6;
    private int DEFAULT_NUM_MINES = 10;

    //Initiate with default values so "PLAY GAME" Button works on main screen
    private int numRows = DEFAULT_NUM_ROWS;
    private int numColumns = DEFAULT_NUM_COLS;
    private int numMines = DEFAULT_NUM_MINES;

    //Singleton Support
    private static OptionsLogic instance;

    private OptionsLogic() {
        //private to prevent anyone else from instantiating.
    }

    public static OptionsLogic getInstance() {
        if (instance == null) {
            instance = new OptionsLogic();
        }
        return instance;
    }

    //Normal object code
    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public int getNumMines() {
        return numMines;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
    }

    public void setNumMines(int numMines) {
        this.numMines = numMines;
    }
}
