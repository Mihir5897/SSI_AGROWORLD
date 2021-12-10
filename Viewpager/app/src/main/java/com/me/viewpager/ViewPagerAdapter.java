package com.me.viewpager;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position) {
            case 0:

                fragment = new Tab1Fragment();

                break;
            case 1:

                fragment = new Tab2Fragment();
                break;
            // you may add more cases for more fragments

        }
        assert fragment != null;
        return fragment;
    }


    @Override
    public int getCount() {
        // Show total number of pages.
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {

            return "TAB Fragment1";
        } else {
            return "TAB Fragment2";
        }


    }
}

