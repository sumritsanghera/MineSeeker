package com.example.cmpt276as3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupOptionButton();
        setupGameButton();
        setupHelpButton();


    }


    private void setupGameButton() {
        Button btn_playGame = (Button) findViewById(R.id.ms_playgame);
        btn_playGame.setBackgroundColor(Color.BLACK);
        btn_playGame.setTextColor(Color.WHITE);
        btn_playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameUI.class);
                startActivity(intent);
            }
        });
    }

    private void setupOptionButton() {
        Button btn_options = (Button) findViewById(R.id.ms_options);
        btn_options.setBackgroundColor(Color.BLACK);
        btn_options.setTextColor(Color.WHITE);
        btn_options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OptionsUI.class);
                startActivity(intent);
            }
        });
    }

    private void setupHelpButton() {
        Button btn_options = (Button) findViewById(R.id.ms_help);
        btn_options.setBackgroundColor(Color.BLACK);
        btn_options.setTextColor(Color.WHITE);
        btn_options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HelpUI.class);
                startActivity(intent);
            }
        });

    }

}