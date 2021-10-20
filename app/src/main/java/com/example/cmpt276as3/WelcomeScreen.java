package com.example.cmpt276as3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity {
    private static int TIMEOUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        //https://www.youtube.com/watch?v=jXtof6OUtcE
        getSupportActionBar().hide();

        setupSkipButton();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(WelcomeScreen.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, TIMEOUT);

    }

    private void setupSkipButton() {
        Button btn = (Button) findViewById(R.id.ws_button);
        btn.setBackgroundColor(Color.WHITE);
        btn.setTextColor(Color.BLACK);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}