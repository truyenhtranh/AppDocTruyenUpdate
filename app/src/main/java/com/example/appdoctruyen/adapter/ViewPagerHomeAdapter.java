package com.example.appdoctruyen.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerHomeAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> arrayFrag = new ArrayList<>();
    private ArrayList<String> arraytitle = new ArrayList<>();

    public ViewPagerHomeAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return arrayFrag.get(position);
    }

    @Override
    public int getCount() {
        return arrayFrag.size();
    }
    public  void addfrag(Fragment fragment, String title){

        arrayFrag.add(fragment);
        arraytitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arraytitle.get(position);
    }
}
