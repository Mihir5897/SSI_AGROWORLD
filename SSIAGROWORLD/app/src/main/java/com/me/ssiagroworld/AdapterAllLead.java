package com.me.ssiagroworld;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class AdapterAllLead extends RecyclerView.Adapter<AdapterAllLead.ItemViewHolder> {

    Context context;
    private List<DataModelofLeads> dataModelList;

    public AdapterAllLead(Context context, List<DataModelofLeads> dataModelList) {

        this.context = context;
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_all_lead_recycelview, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        try {
            DataModelofLeads dataModel = dataModelList.get(position);
            holder.company.setText(dataModel.getCompanyname());
            holder.address.setText(dataModel.getCompanyaddress());
            holder.tag.setText(dataModel.getTag());

            holder.profile.setImageResource(dataModel.getProfileid());
             // holder.profiletv.setVisibility(View.GONE);


            if (dataModel.getProfileurl() != null && !dataModel.getProfileurl().isEmpty()) {
                // profile  is available
                holder.profile.setVisibility(View.VISIBLE);
                holder.profiletv.setVisibility(View.GONE);
            }
            else {
                holder.profile.setVisibility(View.GONE);
                holder.profiletv.setVisibility(View.VISIBLE);
                holder.profiletv.setText(dataModel.getProfileAltText());
            }


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DataModelofLeads dataModel = dataModelList.get(position);

                }
            });
        } catch (Exception e) {
        }

    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        public ShapeableImageView profile;
        public MaterialTextView company, address, tag,profiletv;
        public MaterialCardView materialCardView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            materialCardView = itemView.findViewById(R.id.leadCardview);
            profile = itemView.findViewById(R.id.profile);
            company = itemView.findViewById(R.id.txcompany);
            address = itemView.findViewById(R.id.txaddress);
            tag = itemView.findViewById(R.id.txtag);
            profiletv = itemView.findViewById(R.id.profileTv);
        }
    }
}
