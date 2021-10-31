package com.example.offlinedatabaseinandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    EditText e1, e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        e1 = findViewById(R.id.editText1);
        e2 = findViewById(R.id.editText2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Signup.class);
                startActivity(intent);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s1.isEmpty()){
                    e1.setError("Please fill email");
                } else if(s2.isEmpty()){
                    e2.setError("please fill password");
                } else {
                    SQLiteDatabase database = openOrCreateDatabase("Authentication", MODE_PRIVATE, null);
                    database.execSQL("create table if not exists Students (varchar name, varchar email, varchar password)");
                    String s4 = "select * from Students where email = '" + s1 + "');";
                    Cursor cursor = database.rawQuery(s4, null);
                    if(cursor.getCount()>0){
                        Toast.makeText(MainActivity.this, "User logged in", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, Logout.class);
                        i.putExtra("name", cursor.getString(0));
                        startActivity(i);
                        finish();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "User does not exist!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}