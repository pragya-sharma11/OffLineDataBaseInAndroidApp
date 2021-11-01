package com.example.offlinedatabaseinandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Logout extends AppCompatActivity {
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout2);
        b = findViewById(R.id.button5);
        //Intent intent = getIntent();
        //String s1 = intent.getStringExtra("name");
        //.setText(b.getText() + "  " + s1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Logout.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}