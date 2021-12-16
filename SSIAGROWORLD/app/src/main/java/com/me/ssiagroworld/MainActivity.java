package com.me.ssiagroworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button OpenBottomSheet = findViewById(R.id.open_bottom_sheet);
        Button ExitBottomSheet = findViewById(R.id.exit_bottom_sheet);
        OpenBottomSheet.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Bottom_Sheet_Dialog bottomSheet = new Bottom_Sheet_Dialog();
                        bottomSheet.show(getSupportFragmentManager(),
                                "ModalBottomSheet");
                    }
                });
        ExitBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit_Confirmation_Bottom_dialog exit = new Exit_Confirmation_Bottom_dialog();
                exit.show(getSupportFragmentManager(),"ExitBottomSheet");
            }
        });
    }
}