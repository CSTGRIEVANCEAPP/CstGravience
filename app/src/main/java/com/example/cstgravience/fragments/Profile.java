package com.example.cstgravience.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cstgravience.R;
import com.example.cstgravience.Signup;
import com.example.cstgravience.UserLogin;
import com.example.cstgravience.change_password;
import com.example.cstgravience.model.Users;
import com.example.cstgravience.mypost;
import com.example.cstgravience.resetpassword;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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

    FirebaseUser user;
    TextView userinfo;
    Button changepasswordbtn,signout,starredf;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_profile, container, false);


        starredf=view.findViewById(R.id.starredb);

        starredf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), mypost.class);
                startActivity(intent);

            }
        });

       changepasswordbtn = view.findViewById(R.id.changepassword);
       user=FirebaseAuth.getInstance().getCurrentUser();
       signout=view.findViewById(R.id.signout);
       changepasswordbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(),change_password.class);
               startActivity(intent);
           }
       });
       signout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
               alert.setTitle("Alert!")
                       .setMessage("By signing out you will permanently delete your account")
                       .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                                   @Override
                                   public void onComplete(@NonNull Task<Void> task) {
                                       if(task.isSuccessful()){
                                           Toast.makeText(getContext(), "Your Account has been deleted", Toast.LENGTH_SHORT).show();
                                           Intent intent = new Intent(getActivity(), Signup.class);
                                           startActivity(intent);
                                       }else{
                                           Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                       }
                                   }
                               });
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

        return view;


    }


}