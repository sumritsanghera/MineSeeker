package com.example.cmpt276as3.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.cmpt276as3.R;

public class Options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        
        CreateRadioButtons();
    }

    private void CreateRadioButtons() {
        RadioGroup group = (RadioGroup) findViewById(R.id.radioGroupGameOptions);

        int[] numCellsRow = getResources().getIntArray(R.array.game_configuration_rows);
        int[] numCellsCol = getResources().getIntArray(R.array.game_configuration_cols);

        //Create the buttons
        for(int i = 0; i < numCellsRow.length; i++) {
            int numCellRow = numCellsRow[i];
            int numCellCol = numCellsCol[i];

            RadioButton button = new RadioButton(this);
            button.setText(""+ numCellRow + "x" + numCellCol);

            group.addView(button);
        }

    }
}