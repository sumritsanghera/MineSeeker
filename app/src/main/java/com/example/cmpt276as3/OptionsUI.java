package com.example.cmpt276as3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.example.cmpt276as3.model.OptionsLogic;


public class OptionsUI extends AppCompatActivity {

    private OptionsLogic gameOptions;

    public static Intent makeIntent(Context context) {
        return new Intent(context, OptionsUI.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        getSupportActionBar().hide();

        gameOptions = OptionsLogic.getInstance();

        GameSizeRadioButtons();
        MineRadioButtons();
    }


    private void saveButton() {
        Button btn = (Button) findViewById(R.id.find_selected);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup boardSize = (RadioGroup) findViewById(R.id.radioGroupGameOptions);
                int idOfSelected = boardSize.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(idOfSelected);


            }
        });
    }


    private void GameSizeRadioButtons() {
        RadioGroup group = (RadioGroup) findViewById(R.id.radioGroupGameOptions);

        int[] numCellsRow = getResources().getIntArray(R.array.game_configuration_rows);
        int[] numCellsCol = getResources().getIntArray(R.array.game_configuration_cols);

        //Create the buttons
        for(int i = 0; i < numCellsRow.length; i++) {
            final int numCellRow = numCellsRow[i];
            final int numCellCol = numCellsCol[i];

            RadioButton button = new RadioButton(this);
            button.setText(numCellRow+"x"+numCellCol);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gameOptions.setNumRows(numCellRow);
                    gameOptions.setNumColumns(numCellCol);

                    Toast.makeText(OptionsUI.this, numCellRow + "x" + numCellCol +
                            " Board Selected", Toast.LENGTH_SHORT).show();
                }
            });
            int selectedRow = gameOptions.getNumRows();
            boolean isSelected = (selectedRow == numCellRow);
            group.addView(button);

            if (isSelected) {
                button.setChecked(true);
            }

        }
    }

    private void MineRadioButtons() {
        RadioGroup group = (RadioGroup) findViewById(R.id.radioGroupMineOptions);

        int[] numMines = getResources().getIntArray(R.array.game_configuration_mines);

        //Create the buttons
        for(int i = 0; i < numMines.length; i++) {
            final int numMine = numMines[i];

            RadioButton button = new RadioButton(this);
            button.setText(""+numMine);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gameOptions.setNumMines(numMine);
                    saveMine(gameOptions);

                    Toast.makeText(OptionsUI.this, numMine + " Mines Selected"
                            , Toast.LENGTH_SHORT).show();
                }
            });

            boolean isSelected = (gameOptions.getNumMines() == i);

            group.addView(button);

            if (isSelected) {
                button.setChecked(true);
            }


        }
    }

    private void saveSize(OptionsLogic options) {

        SharedPreferences sizeShare = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sizeShare.edit();

        editor.putInt("row number",options.getNumRows());
        editor.putInt("col number",options.getNumColumns());
        editor.apply();
    }

    private void saveMine(OptionsLogic options) {

        SharedPreferences mineShare = this.getSharedPreferences("mineShare",MODE_PRIVATE);
        SharedPreferences.Editor editor = mineShare.edit();

        editor.putInt("mine number", options.getNumMines());
        editor.apply();
    }

    public void getRowNumberSaved(){
        RadioGroup boardSize = (RadioGroup) findViewById(R.id.radioGroupGameOptions);
        int idOfSelected = boardSize.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(idOfSelected);

        SharedPreferences share = PreferenceManager.getDefaultSharedPreferences(this);
        int row = gameOptions.getNumRows();
        radioButton.getResources().getInteger(row);

    }

     public void getColNumberSaved(){
        RadioGroup boardSize = (RadioGroup) findViewById(R.id.radioGroupGameOptions);
        int idOfSelected = boardSize.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(idOfSelected);

        SharedPreferences share = PreferenceManager.getDefaultSharedPreferences(this);
        int col = gameOptions.getNumColumns();
        radioButton.getResources().getInteger(col);

    }


     public void getMineNumberSaved(){
         RadioGroup radioMines = (RadioGroup) findViewById(R.id.radioGroupMineOptions);
         int idOfSelected = radioMines.getCheckedRadioButtonId();
         RadioButton radioButton = findViewById(idOfSelected);

         SharedPreferences share = PreferenceManager.getDefaultSharedPreferences(this);
         int mines = gameOptions.getNumMines();
         radioButton.getResources().getInteger(mines);

    }
}