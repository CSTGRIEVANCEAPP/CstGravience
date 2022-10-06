package com.example.cstgravience;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import com.example.cstgravience.fragments.Loginadapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
Button signup,login,loginadmin;
ViewPager2 viewpagelogin;
TabLayout tableLayoutlogin;
   Loginadapter Loginadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//
         viewpagelogin=findViewById(R.id.loginviewpage);
        tableLayoutlogin=findViewById(R.id.tablayoutlogin);

        Loginadapter=new Loginadapter(this);
        viewpagelogin.setAdapter(Loginadapter);

        tableLayoutlogin.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpagelogin.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        viewpagelogin.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                tableLayoutlogin.getTabAt(position).select();



            }


//            signup = findViewById(R.id.Signup);
//            login = findViewById(R.id.login);
////          loginadmin=findViewById(R.id.loginadmin);
////
//                login.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent1 = new Intent(MainActivity.this, Homepage.class);
//                    startActivity(intent1);
//                }
//            });
//
//                signup.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent2 = new Intent(MainActivity.this, Signup.class);
//                    startActivity(intent2);
//                }
//            });
//
//
//                loginadmin.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent3 = new Intent(MainActivity.this, Adminpage.class);
//                    startActivity(intent3);
//                }
//            });
//
//
        });


            }}
