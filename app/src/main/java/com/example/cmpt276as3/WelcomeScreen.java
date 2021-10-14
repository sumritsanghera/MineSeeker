package com.example.cmpt276as3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity {
    private static int TIMEOUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        getSupportActionBar().hide();

        Button btn = (Button) findViewById(R.id.ws_button);
        btn.setBackgroundColor(Color.WHITE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMain();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(WelcomeScreen.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, TIMEOUT);

    }

    private void openMain() {
        Intent intent = new Intent(WelcomeScreen.this, MainActivity.class);
        startActivity(intent);
    }
}