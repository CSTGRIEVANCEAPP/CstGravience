package com.example.cstgravience;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Drafts extends AppCompatActivity {
TextView category,complaint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_drafts);
        category=findViewById(R.id.category);
        complaint=findViewById(R.id.complaint);


        String cate = getIntent().getStringExtra("keycate");
        String grievance = getIntent().getStringExtra("keygrievance");

        category.setText(cate);
        complaint.setText(grievance);
    }
}