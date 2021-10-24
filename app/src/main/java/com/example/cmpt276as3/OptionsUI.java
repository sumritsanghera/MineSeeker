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


    //Dr Fraser Youtube Video
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
            //setChecked
            //https://stackoverflow.com/questions/4134582/how-to-set-a-radio-button-in-android
            int selectedRow = gameOptions.getNumRows();
            boolean buttonSelected = (selectedRow == numCellRow);
            group.addView(button);

            if (buttonSelected) {
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

                    Toast.makeText(OptionsUI.this, numMine + " Mines Selected"
                            , Toast.LENGTH_SHORT).show();
                }
            });

            int selectedMine = gameOptions.getNumMines();
            boolean buttonSelected = (selectedMine == numMine);

            group.addView(button);

            if (buttonSelected) {
                button.setChecked(true);
            }


        }
    }

}