package com.me.ssiagroworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class Add_a_Prospect_1 extends AppCompatActivity {
    MaterialButton next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_aprospect1);
        next=findViewById(R.id.registerBtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Add_a_Prospect_1.this, Add_a_Prospect_2.class);
                startActivity(intent);
            }
        });
    }
}