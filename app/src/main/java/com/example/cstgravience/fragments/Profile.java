package com.example.cstgravience.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cstgravience.R;
import com.example.cstgravience.UserLogin;
import com.example.cstgravience.change_password;
import com.example.cstgravience.model.Users;
import com.example.cstgravience.resetpassword;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.nio.file.attribute.UserPrincipalLookupService;


public class Profile extends Fragment {
    DatabaseReference reference;
    FirebaseUser user;
    TextView userinfo;
    Button changepasswordbtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_profile, container, false);

       changepasswordbtn = view.findViewById(R.id.changepassword);
       userinfo = view.findViewById(R.id.userinfo);
       changepasswordbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(),change_password.class);
               startActivity(intent);
           }
       });
        return view;


    }


}