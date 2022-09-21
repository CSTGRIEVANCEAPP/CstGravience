package com.example.cstgravience;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class Adminpage extends AppCompatActivity {
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage);

        viewPager2=findViewById(R.id.viewpage);
        tabLayout=findViewById(R.id.tablayout);
        viewPager2.setAdapter(myadapter);

        yab



    }
}