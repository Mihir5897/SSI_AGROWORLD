package com.me.ssiagroworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;

public class Add_a_Prospect_4 extends AppCompatActivity implements  CheckboxListener{
    RecyclerView recyclerView;
    Context context;
    CheckboxAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_aprospect4);
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
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));//LinearLayoutManager
//        adapter = new CheckboxAdapter(this,getcheckboxtext(),this);
//        recyclerView.setAdapter(adapter);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CheckboxAdapter(this,getcheckboxtext(),this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void ontextchange(ArrayList<String> checkboxtext) {
        //TODO
        Toast.makeText(this,checkboxtext.toString(),Toast.LENGTH_SHORT).show();
    }
}