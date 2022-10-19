package com.example.cstgravience;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.cstgravience.fragments.academic;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Adminpage extends AppCompatActivity {
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    myadapter myadapter;
    private FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FloatingActionButton fab;
    private static final String SHARED_PREF = "sharedPrefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_adminpage);

        viewPager2=findViewById(R.id.viewpage);
        tabLayout=findViewById(R.id.tablayout);
        myadapter=new myadapter(this);
        viewPager2.setAdapter(myadapter);
        fab = findViewById(R.id.btn_fab);
        firebaseDatabase=FirebaseDatabase.getInstance();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.setTitle("Alert!")
                        .setMessage("Are you sure you want to log out")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
                                        sharedPreferences.edit().clear().commit();
                                        Toast.makeText(Adminpage.this, "Admin Logout success", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(Adminpage.this, Adminlogin.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                alert.show();
            }
        });
        DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference();
        mDatabaseRef.child("category").child("Academic").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
              int count= (int) snapshot.getChildrenCount();
                BadgeDrawable badgeDrawableA = tabLayout.getTabAt(0).getOrCreateBadge();
                badgeDrawableA.setVisible(true);
                badgeDrawableA.setNumber(count);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mDatabaseRef.child("category").child("Hostel").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int countH= (int) snapshot.getChildrenCount();
                BadgeDrawable badgeDrawableA = tabLayout.getTabAt(1).getOrCreateBadge();
                badgeDrawableA.setVisible(true);
                badgeDrawableA.setNumber(countH);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mDatabaseRef.child("category").child("Others").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int countO= (int) snapshot.getChildrenCount();
                BadgeDrawable badgeDrawableA = tabLayout.getTabAt(3).getOrCreateBadge();
                badgeDrawableA.setVisible(true);
                badgeDrawableA.setNumber(countO);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mDatabaseRef.child("category").child("Personal").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int countP= (int) snapshot.getChildrenCount();
                BadgeDrawable badgeDrawableA = tabLayout.getTabAt(2).getOrCreateBadge();
                badgeDrawableA.setVisible(true);
                badgeDrawableA.setNumber(countP);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        academic academic = new academic();




        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());

                if( tab.getPosition()==3){
                    BadgeDrawable badgeDrawableO= tabLayout.getTabAt(3).getBadge();
                    badgeDrawableO.clearNumber();
                    badgeDrawableO.setVisible(false);
                }
                if( tab.getPosition()==0){
                    BadgeDrawable badgeDrawableA= tabLayout.getTabAt(0).getBadge();
                    badgeDrawableA.clearNumber();
                    badgeDrawableA.setVisible(false);

                }
                if( tab.getPosition()==1){
                    BadgeDrawable badgeDrawableH = tabLayout.getTabAt(1).getBadge();
                    badgeDrawableH.clearNumber();
                    badgeDrawableH.setVisible(false);
                }
                if( tab.getPosition()==2){
                    BadgeDrawable badgeDrawableP = tabLayout.getTabAt(2).getBadge();
                    badgeDrawableP.clearNumber();
                    badgeDrawableP.setVisible(false);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        tabLayout.getTabAt(position).select();
    }
});
    }
}