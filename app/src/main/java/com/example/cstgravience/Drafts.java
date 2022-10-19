package com.example.cstgravience;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class Drafts extends AppCompatActivity {
    ArrayList<DraftGrievance> GDraftList;
    private RecyclerView Draft_recyclerV;
    private DraftAdapter Draft_Adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drafts);

        GDraftList = new ArrayList<>();
        Draft_recyclerV = findViewById(R.id.Drafts_RecyclerV);
        Draft_recyclerV.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        Draft_Adapter = new DraftAdapter(GDraftList);
        Draft_recyclerV.setAdapter(Draft_Adapter);
        dataInitialize();

        Draft_recyclerV.setLayoutManager(mLayoutManager);

    }

    private void dataInitialize(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        FirebaseUser cUser = FirebaseAuth.getInstance().getCurrentUser();

        String uID = cUser.getUid();
        String uEmail = cUser.getEmail();
        DatabaseReference A_databaseReference = firebaseDatabase.getReference("Draft");
        Query query = A_databaseReference.orderByChild("grievanceKey").equalTo(uEmail);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot :snapshot.getChildren()){
                    DraftGrievance datamodel = dataSnapshot.getValue(com.example.cstgravience.DraftGrievance.class);
                    GDraftList.add(datamodel);
                    Collections.reverse(GDraftList);
                }
                Draft_Adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}