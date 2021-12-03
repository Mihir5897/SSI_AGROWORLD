package com.me.ssiagroworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.view.View;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class Bottom_Sheet_Dialog extends BottomSheetDialogFragment {



        public View onCreateView(LayoutInflater inflater , @Nullable
                ViewGroup container, @Nullable Bundle savedInstanceState)
        {
            View v = inflater.inflate(R.layout.activity_bottom_sheet_dialog,
                    container, false);

            Button okay = v.findViewById(R.id.btnokay);
            Button clear = v.findViewById(R.id.btnclear);

            okay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(getActivity(),
                            "Okay Button clicked", Toast.LENGTH_SHORT)
                            .show();
//                    Intent intent = new Intent(Bottom_Sheet_Dialog.this, User.class);
//                    startActivity(intent);
                    dismiss();
                }
            });

            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(getActivity(),
                            "Cross Button Clicked", Toast.LENGTH_SHORT)
                            .show();
                    dismiss();
                }
            });
            return v;
        }
}