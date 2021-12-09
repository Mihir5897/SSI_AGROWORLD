package com.me.ssiagroworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.button.MaterialButton;

public class Add_a_Prospect_5 extends AppCompatActivity {
    MaterialButton doneButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_aprospect5);
        doneButton = findViewById(R.id.btnNext);
        doneButton.setText(R.string.done);
    }
}