package com.example.cmpt276as3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class HelpUI extends AppCompatActivity {

    TextView linkTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        getSupportActionBar().hide();


        //Add HyperLink
        //https://www.youtube.com/watch?v=tL9fCKC2lNA

        linkTextView = findViewById(R.id.h_hyperlink);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}