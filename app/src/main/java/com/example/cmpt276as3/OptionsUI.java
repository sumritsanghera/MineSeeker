package com.example.cmpt276as3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class OptionsUI extends AppCompatActivity {

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
            final int numCellRow = numCellsRow[i];
            final int numCellCol = numCellsCol[i];

            RadioButton button = new RadioButton(this);
            button.setText(""+ numCellRow + "x" + numCellCol);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(OptionsUI.this, numCellRow + "x" + numCellCol +
                            " Board Selected", Toast.LENGTH_SHORT).show();
                }
            });

            group.addView(button);
        }

    }
}