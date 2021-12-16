package com.me.ssiagroworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.me.ssiagroworld.Api.RetrofitApiClient;
import com.me.ssiagroworld.Error.ApiErrorResponse;
import com.me.ssiagroworld.Request.RegistrationRequest;
import com.me.ssiagroworld.Responce.RegistrationResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button register;
    Spinner spino;
    TextView txfrist, txlast, txphone, txemail,redirectLogin;
    TextInputLayout f_name, email, phone, l_name;
    int role;
    boolean isFristNameValid, isEmailValid, isPhoneValid, isLastNameValid;
    String[] user_type = {"BDE", "BDA", "BDB", "BDC","MBA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        // Take the instance of Spinner and
        // apply OnItemSelectedListener on it which
        // tells which item of spinner is clicked
        spino = findViewById(R.id.userTypeSpinner);
        spino.setOnItemSelectedListener(Register.this);
        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, user_type);
        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spino.setAdapter(ad);

        redirectLogin=findViewById(R.id.already_hav);
        txfrist = findViewById(R.id.first_name_3);
        txlast = findViewById(R.id.last_name);
        txphone = findViewById(R.id.phone_numbe);
        txemail = findViewById(R.id.email_id);
        l_name = findViewById(R.id.lastNameTextField);
        f_name = findViewById(R.id.firstNameTextField);
        email = findViewById(R.id.emailTextField);
        phone = findViewById(R.id.edt_phonee);
        register = findViewById(R.id.btn_register2);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();
                if (isFristNameValid && isEmailValid && isPhoneValid && isLastNameValid) {

                    callregistrationapi();
                }
            }
        });
        redirectLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //moveTaskToBack(true);
    }

    private void callregistrationapi() {
        RegistrationRequest registrationRequest =new RegistrationRequest();
        registrationRequest.setEmail(email.getEditText().getText().toString());
        registrationRequest.setFirstName(f_name.getEditText().getText().toString());
        registrationRequest.setLastName(l_name.getEditText().getText().toString());
        registrationRequest.setMobileNumber(phone.getEditText().getText().toString());
        registrationRequest.setRole(role);


        Call<RegistrationResponse> call = RetrofitApiClient
                .getInstanse()
                .getregistraionApi()
                .register(registrationRequest);
        call.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                RegistrationResponse registrationResponse = response.body();
                if (response.isSuccessful()){
                    Toast.makeText(Register.this,registrationResponse.getMessage(),Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this, Login.class);
                    //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
               }else if (response.code() == 400) {
                    ResponseBody body = response.errorBody();
                    Gson gson = new Gson();
                    ApiErrorResponse apiErrorResponse;
                    String content = null;
                    try {
                        content = body.string();
                        apiErrorResponse = gson.fromJson(content, ApiErrorResponse.class);
                        Toast.makeText(getApplicationContext(), apiErrorResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
//                else {
//                    Toast.makeText(getApplicationContext(), registrationResponse.getMessage(), Toast.LENGTH_SHORT).show();
//                }
            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public  void  SetValidation() {
        // Check for a valid name.
        if (f_name.getEditText().getText().toString().isEmpty()) {
            f_name.setError(getResources().getString(R.string.name_error));
            txfrist.setText(Utilities.getErrorMessageForTextInputLayoutHeading(getResources().getString(R.string.first_name_)));
            isFristNameValid = false;
        } else {
            f_name.setError(null);
            txfrist.setText(getResources().getString(R.string.first_name_));
            isFristNameValid = true;
        }

        // Check for a valid Last name.
        if (l_name.getEditText().getText().toString().isEmpty()) {
            l_name.setError(getResources().getString(R.string.last_error));
            isLastNameValid = false;
            txlast.setText(Utilities.getErrorMessageForTextInputLayoutHeading(getResources().getString(R.string.last_name_)));

        } else {
            l_name.setError(null);
            txlast.setText(getResources().getString(R.string.last_name_));

            isLastNameValid = true;
        }

        // Check for a valid email address.
        if (email.getEditText().getText().toString().isEmpty()) {
            email.setError(getResources().getString(R.string.email_error));
            txemail.setText(Utilities.getErrorMessageForTextInputLayoutHeading(getResources().getString(R.string.email_id_)));
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getEditText().getText().toString()).matches()) {
            email.setError(getResources().getString(R.string.error_invalid_email));
            txemail.setText(Utilities.getErrorMessageForTextInputLayoutHeading(getResources().getString(R.string.email_id_)));
            isEmailValid = false;
        } else {
            txemail.setText(getResources().getString(R.string.email_id_));
            email.setError(null);
            isEmailValid = true;
        }

        // Check for a valid phone number.
        if (phone.getEditText().getText().toString().isEmpty()) {
            phone.setError(getResources().getString(R.string.phone_error));
            txphone.setText(Utilities.getErrorMessageForTextInputLayoutHeading(getResources().getString(R.string.phone_numbe)));

            isPhoneValid = false;
        } else if (!android.util.Patterns.PHONE.matcher(phone.getEditText().getText().toString()).matches()) {
            phone.setError(getResources().getString(R.string.phone_invalid_error));
            txphone.setText(Utilities.getErrorMessageForTextInputLayoutHeading(getResources().getString(R.string.phone_numbe)));

            isPhoneValid = false;
        } else {
            txphone.setText(getResources().getString(R.string.phone_numbe));

            phone.setError(null);
            isPhoneValid = true;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // make toast of name of course
        // which is selected in spinner
//        Toast.makeText(getApplicationContext(),
//                user_type[position],
//                Toast.LENGTH_LONG)
//                .show();
        role=position+1;
        Log.e("TAG", "onItemSelected: "+ role);
       // Toast.makeText(getApplicationContext(), position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}