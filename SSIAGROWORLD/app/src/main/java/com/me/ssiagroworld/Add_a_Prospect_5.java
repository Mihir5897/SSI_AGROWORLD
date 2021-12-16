package com.me.ssiagroworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class Add_a_Prospect_5 extends AppCompatActivity {
    MaterialButton doneButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_aprospect5);
        doneButton = findViewById(R.id.btnNext);
        doneButton.setText(R.string.done);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit_Confirmation_Bottom_dialog exit = new Exit_Confirmation_Bottom_dialog();
                exit.show(getSupportFragmentManager(),"ExitBottomSheet");
            }
        });
    }
}