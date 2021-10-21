package com.example.cmpt276as3.model;

public class OptionsLogic {

    private int numRows;
    private int numColumns;
    private int numMines;

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
