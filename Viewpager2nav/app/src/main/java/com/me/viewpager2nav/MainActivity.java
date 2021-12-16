package com.me.viewpager2nav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  OnBrodingAdapter onBrodingAdapter;
    private LinearLayout layoutonBordingIndicators;
    private MaterialButton actionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpOnbordingitems();

        actionButton = findViewById(R.id.buttonBoaerdAction);
        layoutonBordingIndicators = findViewById(R.id.onBordingIndicators);
        ViewPager2 onboardingViewPAge2 = findViewById(R.id.onBoardViewpage2);
        onboardingViewPAge2.setAdapter(onBrodingAdapter);
        setOnBrodingIndicators();
        setCurrentOnboardingIndicator(0);
        onboardingViewPAge2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicator(position);
            }
        });
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onboardingViewPAge2.getCurrentItem() +1 < onBrodingAdapter.getItemCount()){
                    onboardingViewPAge2.setCurrentItem(onboardingViewPAge2.getCurrentItem() + 1);
                }else {
                        startActivity( new Intent(getApplicationContext(),Home.class));
                        finish();
                }
            }
        });

    }
    private void setUpOnbordingitems (){
        List<Onbordingitem> onbordingitems = new ArrayList<>();
        Onbordingitem mount = new Onbordingitem();
        mount.setTitle("Mountain");
        mount.setDescription("scenic view of snow cappes mountain During Night");
        mount.setImage(R.drawable.three);
        onbordingitems.add(mount);

        Onbordingitem falls = new Onbordingitem();
        falls.setTitle("WaterFAlls");
        falls.setDescription("Amazing waterfalls with lusc fuagies on rock");
        falls.setImage(R.drawable.two);
        onbordingitems.add(falls);


        Onbordingitem dry = new Onbordingitem();
        dry.setTitle("Landscape");
        dry.setDescription("Brown Landscape Under Gray sky");
        dry.setImage(R.drawable.one);
        onbordingitems.add(dry);

        onBrodingAdapter = new OnBrodingAdapter(onbordingitems);

    }
    private void setOnBrodingIndicators(){
        ImageView[] indicators = new ImageView[onBrodingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0,8,0);
        for (int i=0;i<indicators.length;i++){
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onbroding_indictor_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutonBordingIndicators.addView(indicators[i]);
        }
    }

    private void setCurrentOnboardingIndicator (int index){
        int childcount = layoutonBordingIndicators.getChildCount();
        for (int i = 0;i<childcount;i++){
            ImageView imageView = (ImageView)  layoutonBordingIndicators.getChildAt(i);
            if(i==index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext()
                                ,R.drawable.onbroding_indictor_active)
                );
            }else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext()
                                ,R.drawable.onbroding_indictor_inactive)
                );
            }
        }
        if (index == onBrodingAdapter.getItemCount()-1){
            actionButton.setText("Start");
        }else{
            actionButton.setText("Next");
        }
    }


}