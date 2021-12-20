package com.me.ssiagroworld.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.me.ssiagroworld.Model.All_lead_Model;
import com.me.ssiagroworld.Model.DataModelofLeads;
import com.me.ssiagroworld.R;

import java.util.List;

public class Dashboard_Home_adapter extends RecyclerView.Adapter<Dashboard_Home_adapter.ItemViewHolder> {
    Context context;
    private List<All_lead_Model> dataModelList;

    public Dashboard_Home_adapter(Context context, List<All_lead_Model> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_cardview, parent, false);
        return new Dashboard_Home_adapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        try {
            All_lead_Model dataModel = dataModelList.get(position);
            holder.icon_image.setImageResource(dataModel.getIcon());
            holder.number.setText(dataModel.getNumber());
            holder.title.setText(dataModel.getTitle());
            switch (position) {
                case 1:
                    holder.card_dashboard.setCardBackgroundColor
                            (Color.parseColor("#FF7A00"));
                    break;
                case 2:
                    holder.card_dashboard.setCardBackgroundColor
                            (Color.parseColor("#00B2FF"));
                    break;
                case 3:
                    holder.card_dashboard.setCardBackgroundColor
                            (Color.parseColor("#FFB700"));
                    break;
                case 4:
                    holder.card_dashboard.setCardBackgroundColor
                            (Color.parseColor("#00D06C"));
                    break;
                case 5:
                    holder.card_dashboard.setCardBackgroundColor
                            (Color.parseColor("#FF004C"));
                    break;
                default:
                    holder.card_dashboard.setCardBackgroundColor
                            (Color.parseColor("#AD00FF"));
                    break;
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    All_lead_Model dataModel = dataModelList.get(position);

                }
            });
        } catch (Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView card_dashboard;
        LinearLayout background;
        ImageView icon_image;
        TextView number, title;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            card_dashboard = itemView.findViewById(R.id.card_dashboard);
            icon_image = itemView.findViewById(R.id.icon_of_lead);
            number = itemView.findViewById(R.id.tx_number);
            title = itemView.findViewById(R.id.txtitle);
            background = itemView.findViewById(R.id.linearLayoutcardview);
        }
    }
}
