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

import com.example.cstgravience.HelperClass;
import com.example.cstgravience.R;
import com.example.cstgravience.adapterformainhome;
import com.example.cstgravience.displaydatamodel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;

public class Mainhome extends Fragment {

    private String mParam1;
    private String mParam2;
    private ArrayList<displaydatamodel> homearraylist;
    private String[] displaygrievance;
    private RecyclerView recycleview;
    private adapterformainhome myadapter;

    public Mainhome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mainhome, container, false);

        recycleview=view.findViewById(R.id.mainhomeR);
        recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleview.setHasFixedSize(true);
        homearraylist = new ArrayList<>();
        myadapter=new adapterformainhome(getContext(),homearraylist);
        recycleview.setAdapter(myadapter);
        dataInitialize();

        return view;
    }

    private void dataInitialize(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference A_databaseReference = firebaseDatabase.getReference("Selected");
        A_databaseReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){
                    for (DataSnapshot dataSnapshot : task.getResult().getChildren()){
                        displaydatamodel datamodel = dataSnapshot.getValue(com.example.cstgravience.displaydatamodel.class);
                        homearraylist.add(datamodel);
                        Collections.reverse(homearraylist);
                    }
                }
                myadapter.notifyDataSetChanged();
            }
        });

    }
}