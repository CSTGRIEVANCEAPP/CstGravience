package com.example.cstgravience;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.cstgravience.fragments.Aboutus;
import com.example.cstgravience.fragments.Mainhome;
import com.example.cstgravience.fragments.Profile;
import com.example.cstgravience.fragments.starred;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class Homepage extends AppCompatActivity {


    Button changepass;
    BottomNavigationView bottomNavigationView;
    Mainhome mainhome= new Mainhome();
    Profile profile=new Profile();
    Aboutus aboutus=new Aboutus();
    Button starr;
    Fragment f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

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
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),UserLogin.class));
                finish();
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