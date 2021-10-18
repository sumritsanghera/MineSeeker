package com.example.cmpt276as3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cmpt276as3.model.Game;
import com.example.cmpt276as3.model.Options;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupOptionButton();
        setupGameButton();


    }


    private void setupGameButton() {
        Button btn_playGame = (Button) findViewById(R.id.ms_playgame);
        btn_playGame.setBackgroundColor(Color.BLACK);
        btn_playGame.setTextColor(Color.WHITE);
        btn_playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Game.class);
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
                Intent intent = new Intent(MainActivity.this, Options.class);
                startActivity(intent);
            }
        });
    }

}