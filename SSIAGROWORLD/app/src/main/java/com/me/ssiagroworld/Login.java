package com.me.ssiagroworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.me.ssiagroworld.Api.RetrofitApiClient;
import com.me.ssiagroworld.Error.ApiErrorResponse;
import com.me.ssiagroworld.Request.LoginRequest;
import com.me.ssiagroworld.Responce.LoginResponse;
import com.me.ssiagroworld.Responce.RegistrationResponse;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    MaterialButton loginBtn;
    TextInputLayout phone;
    TextView registerBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Register register = new Register();
        registerBtn=findViewById(R.id.don_t_have_);
        backBtn= findViewById(R.id.btn_back);
        loginBtn = findViewById(R.id.BtnLogin);
        phone = findViewById(R.id.edt_phone_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phoneValidation()) {
                    callLoginApi();
                }
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
            }
        });

    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        moveTaskToBack(true);
    }

    private void callLoginApi() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setMobileNumber(phone.getEditText().getText().toString());

        Call<LoginResponse> call = RetrofitApiClient
                .getInstanse()
                .getregistraionApi()
                .login(loginRequest);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Add_a_Prospect_1.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else if (response.code() == 400) {
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

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public boolean phoneValidation() {
        // Check for a valid phone number.
        if (phone.getEditText().getText().toString().isEmpty()) {
            phone.setError(getResources().getString(R.string.phone_error));
            return false;
        } else if (!android.util.Patterns.PHONE.matcher(phone.getEditText().getText().toString()).matches()) {
            phone.setError(getResources().getString(R.string.phone_invalid_error));
            return false;
        } else {
            phone.setError(null);
            return true;
        }

    }
}