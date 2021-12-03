package com.me.ssiagroworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button register,more;
    Spinner spino;
    EditText f_name, email, phone, l_name;
    boolean isFristNameValid, isEmailValid, isPhoneValid, isLastNameValid;
    String[] user_type = {"BDE", "BDA", "BDB", "BDC",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        // Take the instance of Spinner and
        // apply OnItemSelectedListener on it which
        // tells which item of spinner is clicked
        spino = findViewById(R.id.spinner_select_user);
        spino.setOnItemSelectedListener(this);
        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,user_type);
        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(android.R.layout
                        .simple_spinner_dropdown_item);
        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spino.setAdapter(ad);

        l_name = findViewById(R.id.rectangle_last_name);
        f_name = findViewById(R.id.rectangle_frist_name);
        email = findViewById(R.id.enter_email);
        phone = findViewById(R.id.edt_phone);
        register = findViewById(R.id.btn_register);
        more =findViewById(R.id.btn_more);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();
                if (isFristNameValid && isEmailValid && isPhoneValid && isLastNameValid) {
                    Intent intent = new Intent(Register.this, Verification.class);
                    startActivity(intent);
                }
            }
        });
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spino.performClick();
//                if(spino.getSelectedItem() == null) { // user selected nothing...
//                    spino.performClick();
//                }
            }
        });
    }

    public void SetValidation() {
        // Check for a valid name.
        if (f_name.getText().toString().isEmpty()) {
            f_name.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_error, 0);
            f_name.setError(getResources().getString(R.string.name_error));

            isFristNameValid = false;
        } else {
            f_name.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            isFristNameValid = true;
        }

        // Check for a valid Last name.
        if (l_name.getText().toString().isEmpty()) {
            l_name.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_error, 0);
            l_name.setError(getResources().getString(R.string.last_error));
            isLastNameValid = false;
        } else {
            l_name.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            isLastNameValid = true;
        }

        // Check for a valid email address.
        if (email.getText().toString().isEmpty()) {
            email.setError(getResources().getString(R.string.email_error));
            email.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_error, 0);
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            email.setError(getResources().getString(R.string.error_invalid_email));
            email.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_error, 0);

            isEmailValid = false;
        } else {
            email.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

            isEmailValid = true;
        }

        // Check for a valid phone number.
        if (phone.getText().toString().isEmpty()) {
            phone.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_error, 0);
            phone.setError(getResources().getString(R.string.phone_error));
            isPhoneValid = false;
        } else if (!android.util.Patterns.PHONE.matcher(phone.getText().toString()).matches()) {
            phone.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_error, 0);
            phone.setError(getResources().getString(R.string.phone_invalid_error));

            isPhoneValid = false;
        } else {
            phone.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            isPhoneValid = true;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
// make toastof name of course
        // which is selected in spinner
        Toast.makeText(getApplicationContext(),
                user_type[position],
                Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}