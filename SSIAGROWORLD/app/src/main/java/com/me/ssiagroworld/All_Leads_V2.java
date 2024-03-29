package com.me.ssiagroworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.me.ssiagroworld.Adapter.AdapterAllLead;
import com.me.ssiagroworld.Model.DataModelofLeads;

import java.util.ArrayList;
import java.util.List;

public class All_Leads_V2 extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton fab;
ImageView back;
TextView headertext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_leads_v2);
        back =findViewById(R.id.img_back);
        back.setVisibility(View.GONE);
        headertext = findViewById(R.id.tx_centerHeader);
        headertext.setText(getResources().getString(R.string.all_leads));
         fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initViews();
        setUpRecyclerView();
        sendRecyclerViewDataRequest();
    }
    private void sendRecyclerViewDataRequest() {
        //assume you are getting data from api or local storage by function getDataList
        List<DataModelofLeads> dataModelList = getDataList();
        showRecyclerViewData(dataModelList);
    }
    private List<DataModelofLeads> getDataList() {
        List<DataModelofLeads> dataModelList = new ArrayList<>();
        DataModelofLeads dataModel10 = new DataModelofLeads();
        dataModel10.setProfileurl("");
        dataModel10.setProfileAltText("S");
        dataModel10.setProfileid(R.drawable.ic_profile_image);
        dataModel10.setCompanyname("systango");
        dataModel10.setCompanyaddress("A-2, Indore, Madhya Pradesh");
        dataModel10.setTag("prospect");
        dataModelList.add(dataModel10);

        DataModelofLeads dataModel9 = new DataModelofLeads();
        dataModel9.setProfileurl("");
        dataModel9.setProfileAltText("S");
        dataModel9.setProfileid(R.drawable.ic_profile_image);
        dataModel9.setCompanyname("systango");
        dataModel9.setCompanyaddress("A-2, Indore, Madhya Pradesh");
        dataModel9.setTag("prospect");
        dataModelList.add(dataModel9);

        DataModelofLeads dataModel8 = new DataModelofLeads();
        dataModel8.setProfileurl("");
        dataModel8.setProfileAltText("S");
        dataModel8.setProfileid(R.drawable.ic_profile_image);
        dataModel8.setCompanyname("systango");
        dataModel8.setCompanyaddress("A-2, Indore, Madhya Pradesh");
        dataModel8.setTag("prospect");
        dataModelList.add(dataModel8);

        DataModelofLeads dataModel7 = new DataModelofLeads();
        dataModel7.setProfileurl("");
        dataModel7.setProfileAltText("S");
        dataModel7.setProfileid(R.drawable.ic_profile_image);
        dataModel7.setCompanyname("systango");
        dataModel7.setCompanyaddress("A-2, Indore, Madhya Pradesh");
        dataModel7.setTag("prospect");
        dataModelList.add(dataModel7);

        DataModelofLeads dataModel6 = new DataModelofLeads();
        dataModel6.setProfileurl("");
        dataModel6.setProfileAltText("S");
        dataModel6.setProfileid(R.drawable.ic_profile_image);
        dataModel6.setCompanyname("systango");
        dataModel6.setCompanyaddress("A-2, Indore, Madhya Pradesh");
        dataModel6.setTag("prospect");
        dataModelList.add(dataModel6);

        DataModelofLeads dataModel5 = new DataModelofLeads();
        dataModel5.setProfileurl("");
        dataModel5.setProfileAltText("S");
        dataModel5.setProfileid(R.drawable.ic_profile_image);
        dataModel5.setCompanyname("systango");
        dataModel5.setCompanyaddress("A-2, Indore, Madhya Pradesh");
        dataModel5.setTag("prospect");
        dataModelList.add(dataModel5);

        DataModelofLeads dataModel4 = new DataModelofLeads();
        dataModel4.setProfileurl("");
        dataModel4.setProfileAltText("S");
        dataModel4.setProfileid(R.drawable.ic_profile_image);
        dataModel4.setCompanyname("systango");
        dataModel4.setCompanyaddress("A-2, Indore, Madhya Pradesh");
        dataModel4.setTag("prospect");
        dataModelList.add(dataModel4);

        DataModelofLeads dataModel3 = new DataModelofLeads();
        dataModel3.setProfileurl("");
        dataModel3.setProfileAltText("S");
        dataModel3.setProfileid(R.drawable.ic_profile_image);
        dataModel3.setCompanyname("systango");
        dataModel3.setCompanyaddress("A-2, Indore, Madhya Pradesh");
        dataModel3.setTag("prospect");
        dataModelList.add(dataModel3);

        DataModelofLeads dataModel2 = new DataModelofLeads();
        dataModel2.setProfileurl("");
        dataModel2.setProfileAltText("S");
        dataModel2.setProfileid(R.drawable.ic_profile_image);
        dataModel2.setCompanyname("systango");
        dataModel2.setCompanyaddress("A-2, Indore, Madhya Pradesh");
        dataModel2.setTag("prospect");
        dataModelList.add(dataModel2);

        DataModelofLeads dataModel1 = new DataModelofLeads();
        dataModel1.setProfileAltText("S");
        dataModel1.setProfileurl("");
        dataModel1.setProfileid(R.drawable.ic_profile_image);
        dataModel1.setCompanyname("systango");
        dataModel1.setCompanyaddress("A-2, Indore, Madhya Pradesh");
        dataModel1.setTag("prospect");
        dataModelList.add(dataModel1);

        return dataModelList;
    }

    private void initViews() {
        recyclerView = findViewById(R.id.allLeadrecyclerview);
    }

    //setup recycler view
    private void setUpRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
    private void showRecyclerViewData(List<DataModelofLeads> dataModelList) {
        AdapterAllLead recyclerViewItemAdapter = new AdapterAllLead(this, dataModelList);
        recyclerView.setAdapter(recyclerViewItemAdapter);
        recyclerViewItemAdapter.notifyDataSetChanged();
    }
}
