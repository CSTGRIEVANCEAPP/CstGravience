package com.example.cstgravience.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cstgravience.Odatamodel;
import com.example.cstgravience.R;
import com.example.cstgravience.adapterforothers;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class Others extends Fragment {

    private String mParam1;
    private String mParam2;
    private ArrayList<Odatamodel> newsarraylist;
    private String[] grievance;
    private RecyclerView recycleview;
    adapterforothers myadapter;

    public Others() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mess, container, false);

        recycleview=view.findViewById(R.id.otherR);
        recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleview.setHasFixedSize(true);
        newsarraylist = new ArrayList<>();
        myadapter=new adapterforothers(getContext(),newsarraylist);
        recycleview.setAdapter(myadapter);
        dataInitialize();

        return view;

    }

    private void dataInitialize(){
        DatabaseReference A_databaseReference = FirebaseDatabase.getInstance().getReference("category");
        A_databaseReference.child("Personal").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){
                    for (DataSnapshot dataSnapshot : task.getResult().getChildren()){
                        Odatamodel datamodel = dataSnapshot.getValue(com.example.cstgravience.Odatamodel.class);
                        newsarraylist.add(datamodel);
                    }
                }
                myadapter.notifyDataSetChanged();
            }
        });


    }
}