package com.me.ssiagroworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.me.ssiagroworld.Adapter.AdapterAllLead;
import com.me.ssiagroworld.Adapter.Dashboard_Home_adapter;
import com.me.ssiagroworld.Model.All_lead_Model;
import com.me.ssiagroworld.Model.DataModelofLeads;

import java.util.ArrayList;
import java.util.List;

public class Dashboard_Home_V1 extends AppCompatActivity {
    RecyclerView addleadrecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_home_v1);
        initViews();
        setUpRecyclerView();
        sendRecyclerViewDataRequest();
    }
    private void sendRecyclerViewDataRequest(){
//assume you are getting data from api or local storage by function getDataList
        List<All_lead_Model> dataModelList = getDataList();
        showRecyclerViewData(dataModelList);
    }
    private List<All_lead_Model> getDataList() {
        List<All_lead_Model> dataModelList = new ArrayList<>();

        All_lead_Model dataModel1 = new All_lead_Model();
        dataModel1.setNumber("245");
        dataModel1.setTitle("Total Leads");
        dataModel1.setIcon(R.drawable.ic_total_lead);
        dataModelList.add(dataModel1);

        All_lead_Model dataModel2 = new All_lead_Model();
        dataModel2.setNumber("12");
        dataModel2.setTitle("Meetings Inlined");
        dataModel2.setIcon(R.drawable.ic_calnder);
        dataModelList.add(dataModel2);

        All_lead_Model dataModel3 = new All_lead_Model();
        dataModel3.setNumber("115");
        dataModel3.setTitle("Follow ups pending");
        dataModel3.setIcon(R.drawable.ic_calendar_click);
        dataModelList.add(dataModel3);

        All_lead_Model dataModel4 = new All_lead_Model();
        dataModel4.setNumber("12");
        dataModel4.setTitle("Upcoming Follow up");
        dataModel4.setIcon(R.drawable.ic_calnder);
        dataModelList.add(dataModel4);

        All_lead_Model dataModel5 = new All_lead_Model();
        dataModel5.setNumber("120");
        dataModel5.setTitle("Lead Conversion");
        dataModel5.setIcon(R.drawable.ic_calendar_click);
        dataModelList.add(dataModel5);

        All_lead_Model dataModel6 = new All_lead_Model();
        dataModel6.setIcon(R.drawable.ic_calnder);
        dataModel6.setNumber("17");
        dataModel6.setTitle("Client Conversion");
        dataModelList.add(dataModel6);

        return dataModelList;
    }

    private void initViews() {
        addleadrecyclerView = findViewById(R.id.all_lead);
    }

    //setup recycler view
    private void setUpRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        addleadrecyclerView.setLayoutManager(gridLayoutManager);
    }
    private void showRecyclerViewData(List<All_lead_Model> dataModelList) {
        Dashboard_Home_adapter recyclerViewItemAdapter = new Dashboard_Home_adapter(this, dataModelList);
        addleadrecyclerView.setAdapter(recyclerViewItemAdapter);
        recyclerViewItemAdapter.notifyDataSetChanged();
    }
}