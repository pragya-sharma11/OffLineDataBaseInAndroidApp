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
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Signup.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if(s1.isEmpty()){
                    e1.setError("please fill username");
                }
                else if (s2.isEmpty()){
                    e2.setError("Please fill email address");
                }
                else if(s3.isEmpty()){
                    e3.setError("Please enter password");
                }
                else{
                    SQLiteDatabase database = openOrCreateDatabase("Authentication", MODE_PRIVATE, null );
                    database.execSQL("create table if not exists Students (varchar name, varchar email, varchar password)");
                    String s4 = "select * from Students where name = '" + s1 + "' and email = '" + s2 + "');";
                    Cursor cursor = database.rawQuery(s4, null);
                    if(cursor.getCount()>0)
                    {
                        Toast.makeText(Signup.this, "User Already Exists", Toast.LENGTH_SHORT).show();
                    } else{
                        database.execSQL("insert into Students values ('" + s1 + "', '" + s2 + "', '" + s3 + "')");
                        Toast.makeText(Signup.this, "Database updated!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}