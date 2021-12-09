package com.me.ssiagroworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class Try extends AppCompatActivity implements  CheckboxListener{
RecyclerView recyclerView;
    CheckboxAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try);
        recyclerView= findViewById(R.id.recyclerview);
        setrecycleView();


    }
    private ArrayList<String> getcheckboxtext(){
        ArrayList<String> checkboxtext = new ArrayList<>();
        checkboxtext.add(getResources().getString(R.string.basmati_ric_1));
        checkboxtext.add(getResources().getString(R.string.barley));
        checkboxtext.add(getResources().getString(R.string.basmati_ric));
        checkboxtext.add(getResources().getString(R.string.gram));
        checkboxtext.add(getResources().getString(R.string.oats));
        checkboxtext.add(getResources().getString(R.string.pusa_basmat));
        checkboxtext.add(getResources().getString(R.string.sorghum_red));
        checkboxtext.add(getResources().getString(R.string.toor_daal));
        checkboxtext.add(getResources().getString(R.string.traditional));

        return checkboxtext;
    }
    private void setrecycleView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,LinearLayoutManager.VERTICAL));
        adapter = new CheckboxAdapter(this,getcheckboxtext(),this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void ontextchange(ArrayList<String> checkboxtext) {
        //TODO
Toast.makeText(this,checkboxtext.toString(),Toast.LENGTH_SHORT).show();
    }
}