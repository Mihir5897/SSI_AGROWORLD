package com.me.ssiagroworld;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;

public class Exit_Confirmation_Bottom_dialog extends BottomSheetDialogFragment {
ImageView clearImage;
    MaterialButton yesButton,cancelButton;

    public View onCreateView(LayoutInflater inflater , @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.exit_confirmation_buttom_dialog,
                container, false);
        clearImage=v.findViewById(R.id.clearImage);
         yesButton = v.findViewById(R.id.btnYes);
         cancelButton = v.findViewById(R.id.btnCancel);

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getActivity(),
                        "Yes Button clicked", Toast.LENGTH_SHORT)
                        .show();
//                    Intent intent = new Intent(Bottom_Sheet_Dialog.this, User.class);
//                    startActivity(intent);
                dismiss();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getActivity(),
                        "Cancel Button Clicked", Toast.LENGTH_SHORT)
                        .show();
                dismiss();
            }
        });
        return v;
    }
    public void clear(){
        Toast.makeText(getActivity(),
                "Clear Button Clicked", Toast.LENGTH_SHORT)
                .show();
        dismiss();
    }


}
