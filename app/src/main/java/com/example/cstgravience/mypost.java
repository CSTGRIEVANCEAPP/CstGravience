package com.example.cstgravience;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class mypost extends AppCompatActivity {
    private ArrayList<stareddatamodel> Mypostarraylist;
    private String[] Mypostgrievance;
    private RecyclerView recycleview;
    adapterforstarred adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypost);
        dataInitialize();
        recycleview=findViewById(R.id.MypostR);
        recycleview.setLayoutManager(new LinearLayoutManager(this));
Mypostarraylist=new ArrayList<>();
adapter=new adapterforstarred(this, Mypostarraylist);
recycleview.setAdapter(adapter);
recycleview.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));



    }
    private void dataInitialize() {
        Mypostarraylist = new ArrayList<>();
        Mypostgrievance = new String[]{
                getString(R.string.h1),
                getString(R.string.h2),
                getString(R.string.h3),
                getString(R.string.h4),

                getString(R.string.h5),
                getString(R.string.h6),
                getString(R.string.h7),
                getString(R.string.h8),
                getString(R.string.h9),
                getString(R.string.h10)


        };
        for (int i = 0; i < Mypostgrievance.length; i++) {

            stareddatamodel stareddatamodel = new stareddatamodel(Mypostgrievance[i]);
        Mypostarraylist.add(stareddatamodel);
        }

    }

    }