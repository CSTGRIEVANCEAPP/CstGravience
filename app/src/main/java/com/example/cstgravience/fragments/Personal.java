package com.example.cstgravience.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.cstgravience.R;
import com.example.cstgravience.adapterforpersonal;
import com.example.cstgravience.pdatamodel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Personal extends Fragment {
    private String mParam1;
    private String mParam2;
    private ArrayList<pdatamodel> newsarraylist;
    private String[] grievance;
    private RecyclerView recycleview;
    private adapterforpersonal myadapter;

    public Personal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personal, container, false);

        recycleview=view.findViewById(R.id.personalR);
        recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleview.setHasFixedSize(true);
        newsarraylist = new ArrayList<>();
        myadapter=new adapterforpersonal(getContext(),newsarraylist);
        recycleview.setAdapter(myadapter);
        dataInitialize();

        return view;
    }
    private void dataInitialize(){
        DatabaseReference A_databaseReference = FirebaseDatabase.getInstance().getReference("category");
        A_databaseReference.child("Others").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){
                    for (DataSnapshot dataSnapshot : task.getResult().getChildren()){
                        pdatamodel datamodel = dataSnapshot.getValue(com.example.cstgravience.pdatamodel.class);
                        newsarraylist.add(datamodel);
                    }
                }
                myadapter.notifyDataSetChanged();
            }
        });
    }
}