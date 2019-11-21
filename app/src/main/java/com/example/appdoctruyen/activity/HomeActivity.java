package com.example.appdoctruyen.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.adapter.ViewPagerHomeAdapter;
import com.example.appdoctruyen.fragment.Fragment_Tim_Kiem;
import com.example.appdoctruyen.fragment.Fragment_Trang_Chu;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        anhxa();
        init();
        
    }

    private void init() {
        ViewPagerHomeAdapter viewPagerHomeAdapter = new ViewPagerHomeAdapter(getSupportFragmentManager());


        viewPagerHomeAdapter.addfrag(new Fragment_Trang_Chu(),"Home");
        viewPagerHomeAdapter.addfrag(new Fragment_Tim_Kiem(),"Search");

        viewPager.setAdapter(viewPagerHomeAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.icontimkiem);

    }

    private void anhxa() {

        tabLayout = findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPager);

    }
}
