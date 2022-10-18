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
import com.example.cstgravience.adapterforrecycle;
import com.example.cstgravience.adapterforstarred;
//import com.example.cstgravience.datamodel;
import com.example.cstgravience.stareddatamodel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link starred#newInstance} factory method to
 * create an instance of this fragment.
 */
public class starred extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<stareddatamodel> staredarraylist;
    private String[] staredgrievance;
    private RecyclerView recycleview;

    public starred() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static starred newInstance(String param1, String param2) {
        starred fragment = new starred();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_starred, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        dataInitialize();
        recycleview=view.findViewById(R.id.stared);
        recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleview.setHasFixedSize(true);
        adapterforstarred myadapter=new adapterforstarred(getContext(),staredarraylist);
        recycleview.setAdapter(myadapter);
        myadapter.notifyDataSetChanged();


    }
    private void dataInitialize(){
   staredarraylist = new ArrayList<>();
      staredgrievance=new String[]{
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
        for (int i=0;i<staredgrievance.length;i++){

            stareddatamodel stareddatamodel=new stareddatamodel(staredgrievance[i]);
            staredarraylist.add(stareddatamodel);
        }

    }
}