package com.example.appdoctruyen.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

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

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông Báo!!!!");
        builder.setMessage("Do dùng Web Free nên ảnh truyện sẽ đươc load châm hơn bình thường mong các bạn thông cảm. Vuốt sang để chuyển ảnh truyện");
        builder.setCancelable(false);

        builder.setNegativeButton("Đã Hiểu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

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
