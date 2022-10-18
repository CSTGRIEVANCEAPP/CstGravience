package com.example.cstgravience;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Drafts extends AppCompatActivity{
TextView category,complaint;
public static final String SHARED = "shared";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_drafts);
        category=findViewById(R.id.category);
        complaint=findViewById(R.id.complaint);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED,MODE_PRIVATE);
        category.setText(sharedPreferences.getString("cate", ""));
        complaint.setText(sharedPreferences.getString("complaint", ""));



//        String cate = getIntent().getStringExtra("keycate");
  //      String grievance = getIntent().getStringExtra("keygrievance");
//
//        category.setText(cate);
//       complaint.setText(grievance);
    }
}