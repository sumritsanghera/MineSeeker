package com.example.cmpt276as3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cmpt276as3.model.GameLogic;
import com.example.cmpt276as3.model.OptionsLogic;

import org.w3c.dom.Text;

public class GameUI extends AppCompatActivity {

    //private static final int NUM_ROWS = 6;
    //private static final int NUM_COLS = 4;
    OptionsLogic options = OptionsLogic.getInstance();
    private GameLogic Game = new GameLogic(options.getNumRows(), options.getNumColumns(),
            options.getNumMines());


    Button[][] buttons = new Button[options.getNumRows()][options.getNumColumns()];
    static int foundMines = 0;
    static int scansUsed = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().hide();

        populateButtons();
        updateScans();


    }
    //BEGIN SOURCE CODE
    private void populateButtons() {

        TableLayout table = (TableLayout) findViewById(R.id.tableForButtons);

        for (int row = 0; row < options.getNumRows(); row++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
            table.addView(tableRow);

            for (int col = 0; col < options.getNumColumns(); col++){
                final int FINAL_COL = col;
                final int FINAL_ROW = row;

                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f));

                //button.setText("" + col + "," + row);
                button.setText("?");

                // Make text not clip on small buttons
                button.setPadding(0, 0, 0, 0);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        gridButtonClicked(FINAL_COL, FINAL_ROW);

                    }
                });

                //buttons[numRows][numColumns] = button;

                tableRow.addView(button);
                buttons[row][col] = button;
            }
        }
    }

    private void gridButtonClicked(int col, int row) {

        Toast.makeText(this, "Button clicked: " + col + "," + row,
                Toast.LENGTH_SHORT).show();
        Button button = buttons[row][col];

        // Lock Button Sizes:
        lockButtonSizes();

        //TODO INSERT ANIMATION / VIBRATION HERE

        //Shows image if mine present
        if (Game.minePresent(row,col)) {
            //updateGame();
            // Does not scale image.
            // Scale image to button: Only works in JellyBean!
            int newWidth = button.getWidth();
            int newHeight = button.getHeight();
            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.plankton);
            Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true);
            Resources resource = getResources();
            button.setBackground(new BitmapDrawable(resource, scaledBitmap));

            // Change text on button:
            button.setText(" ");
            updateGame(row,col);
            foundMines++;
            updateMines();
        }
        else {
            updateGame(row, col);
            scansUsed++;
            updateScans();
        }
    }



    private void lockButtonSizes() {
        for (int row = 0; row < options.getNumRows(); row++) {
            for (int col = 0; col < options.getNumColumns(); col++) {
                Button button = buttons[row][col];

                int width = button.getWidth();
                button.setMinWidth(width);
                button.setMaxWidth(width);

                int height = button.getHeight();
                button.setMinHeight(height);
                button.setMaxHeight(height);
            }
        }
    }
    //END SOURCE CODE


    private void updateGame(int row, int col) {
        int number = Game.Scan(row, col);
        Button button = buttons[row][col];
        if(Game.minePresent(row,col) == false) {
            button.setText("" + number);
        }
        else {
            button.setText(" ");
        }
    }

    private void updateScans() {
        TextView numScans = (TextView) findViewById(R.id.g_scansUsed);
        numScans.setText("Scans Used: " + scansUsed);
    }

    private void updateMines() {
        TextView numMinesScan = (TextView) findViewById(R.id.g_numMines);
        numMinesScan.setText("Found " + foundMines + " Mines");
    }

}

