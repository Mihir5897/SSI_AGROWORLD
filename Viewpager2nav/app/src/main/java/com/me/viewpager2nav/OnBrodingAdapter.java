package com.me.viewpager2nav;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OnBrodingAdapter extends  RecyclerView.Adapter<OnBrodingAdapter.OnboardingviewHolder>{
   private List<Onbordingitem> onbordingitems;

    public OnBrodingAdapter(List<Onbordingitem> onbordingitems) {
        this.onbordingitems = onbordingitems;
    }

    @NonNull
    @Override
    public OnboardingviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnboardingviewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_cpnternar_onbording,parent,false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OnboardingviewHolder holder, int position) {
        holder.setOnBordingData(onbordingitems.get(position));
    }

    @Override
    public int getItemCount() {
        return onbordingitems.size();
    }

    class OnboardingviewHolder extends RecyclerView.ViewHolder{
        private ImageView imageonbording;
        private TextView textTitle;
        private TextView textDescription;

        public OnboardingviewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle=itemView.findViewById(R.id.texTitle);
            textDescription=itemView.findViewById(R.id.textDescription);
            imageonbording=itemView.findViewById(R.id.ImageOnBorading);
        }
        void setOnBordingData(Onbordingitem onbordingitem){
            textTitle.setText(onbordingitem.getTitle());
            textDescription.setText(onbordingitem.getDescription());
            imageonbording.setImageResource(onbordingitem.getImage());
        }

    }
}
