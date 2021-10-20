package com.example.cmpt276as3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.example.cmpt276as3.model.OptionsLogic;


public class OptionsUI extends AppCompatActivity {

    private OptionsLogic gameOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        gameOptions = OptionsLogic.getInstance();

        GameSizeRadioButtons();
        MineRadioButtons();
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
            button.setText(numCellRow + "x" + numCellCol);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    gameOptions.setNumRows(numCellRow);
                    gameOptions.setNumColumns(numCellCol);

                    Toast.makeText(OptionsUI.this, numCellRow + "x" + numCellCol +
                            " Board Selected", Toast.LENGTH_SHORT).show();
                }
            });

            group.addView(button);
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

            group.addView(button);
        }
    }

}