package com.example.cstgravience;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.example.cstgravience.fragments.Aboutus;
import com.example.cstgravience.fragments.Mainhome;
import com.example.cstgravience.fragments.Profile;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Homepage extends AppCompatActivity {


    Button changepass;
    BottomNavigationView bottomNavigationView;
    Mainhome mainhome= new Mainhome();
    Profile profile=new Profile();
    Aboutus aboutus=new Aboutus();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

//        changepass=findViewById(R.id.changepassword);
//        changepass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(Homepage.this,change_password.class);
//                startActivity(intent);
//            }
//        });

bottomNavigationView=findViewById(R.id.bottomNavigationView);
getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,mainhome).commit();
        BadgeDrawable badgeDrawable=bottomNavigationView.getOrCreateBadge(R.id.Home);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(10);
bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.Home:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,mainhome).commit();
break;

            case R.id.Profile:
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,profile).commit();
break;

            case R.id.aboutus:
    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,aboutus).commit();
    break;
}
        return false;
    }
});

    }

    public void floatbuttom(View view) {

        Intent intent=new Intent(Homepage.this,GravienceForm.class);
        startActivity(intent);
    }
}