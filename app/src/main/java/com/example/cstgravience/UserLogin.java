package com.example.cstgravience;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cstgravience.fragments.Mainhome;

public class UserLogin extends AppCompatActivity {
Button userlogin,Signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);


        userlogin=findViewById(R.id.loginuser);
        Signup=findViewById(R.id.Signup);
      userlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserLogin.this, Homepage.class);
                startActivity(intent);
            }
        });
       Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserLogin.this, Signup.class);
                startActivity(intent);
            }
        });


    }
}