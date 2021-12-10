package com.me.ssiagroworld;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.checkbox.MaterialCheckBox;

import java.util.ArrayList;

public class CheckboxAdapter extends RecyclerView.Adapter<CheckboxAdapter.ViewHolder> {
    View itemView;
    Context context;
    ArrayList<String> checkboxtext;
    CheckboxListener checkboxListener;
    ArrayList<String> newtext = new ArrayList<>();

    public CheckboxAdapter(Context context, ArrayList<String> checkboxtext,
                           CheckboxListener checkboxListener) {
        this.context = context;
        this.checkboxtext = checkboxtext;
        this.checkboxListener = checkboxListener;
    }

    public View getItemView() {
        return itemView;
    }

    @NonNull
    @Override
    public CheckboxAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(context)
                .inflate(R.layout.checkbox, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckboxAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (checkboxtext != null && checkboxtext.size() > 0) {
            holder.recycler_checkbox.setText(checkboxtext.get(position));
            holder.recycler_checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.recycler_checkbox.isChecked()) {
                        newtext.add(checkboxtext.get(position));
                        holder.materialCardView.setStrokeColor(context.getResources()
                                .getColor(R.color.colorPrimary));

                    } else {
                        newtext.remove(checkboxtext.get(position));
                        holder.materialCardView.setStrokeColor(context.getResources()
                                .getColor(R.color.boxcolour));
                    }
                    checkboxListener.ontextchange(newtext);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return checkboxtext.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public MaterialCheckBox recycler_checkbox;
        public MaterialCardView materialCardView;

        public ViewHolder(View view) {
            super(view);
            //type cast not required for level 26 and above but still...!
            recycler_checkbox = (MaterialCheckBox) view.findViewById(R.id.chechbox);
            materialCardView = (MaterialCardView) itemView.findViewById(R.id.checkCardview);
        }
    }
}


