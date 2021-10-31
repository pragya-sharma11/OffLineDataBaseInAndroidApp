package com.example.offlinedatabaseinandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity {
    Button b1, b2;
    EditText e1, e2, e3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        b1 = findViewById(R.id.button3);
        b2 = findViewById(R.id.button2);
        e1 = findViewById(R.id.editText3);
        e2 = findViewById(R.id.editText4);
        e3 = findViewById(R.id.editText5);

    }
}