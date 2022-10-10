package com.example.cstgravience;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cstgravience.fragments.Mainhome;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserLogin extends AppCompatActivity {
Button userlogin,Signup;
EditText emailaddress, Password;
FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        userlogin=findViewById(R.id.loginuser);
        Signup=findViewById(R.id.Signup);
        emailaddress=findViewById(R.id.emailinput);
        Password=findViewById(R.id.Password);


        mAuth = FirebaseAuth.getInstance();

        userlogin.setOnClickListener(view ->{
            loginUser();
        });



//original
//      userlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(UserLogin.this, Homepage.class);
//                startActivity(intent);
//            }
//        });
       Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserLogin.this, Signup.class);
                startActivity(intent);
            }
        });


    }
    private void loginUser(){
        String email = emailaddress.getText().toString();
        String password = Password.getText().toString();

        if (TextUtils.isEmpty(email)){
            emailaddress.setError("Email cannot be empty");
            emailaddress.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            Password.setError("Password cannot be empty");
            Password.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        if(mAuth.getCurrentUser().isEmailVerified()){
                            Intent intent=new Intent(UserLogin.this, Homepage.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(UserLogin.this, "Login error. Please verify your email", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                                Toast.makeText(UserLogin.this, "Login error", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}