package com.example.cstgravience;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signup extends AppCompatActivity {
    Button button;
    TextInputEditText emailinput;
    TextInputEditText passinput;
    TextInputEditText cfinput;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        button = findViewById(R.id.button);
        emailinput = findViewById(R.id.emailinput);
        passinput = findViewById(R.id.passinput);
        cfinput = findViewById(R.id.cfinput);
        mAuth = FirebaseAuth.getInstance();



        button.setOnClickListener(view -> {
            createUser();

        });


    }
    private void createUser(){
        String email = emailinput.getText().toString();
        String password = passinput.getText().toString();

        if (TextUtils.isEmpty(email)){
            emailinput.setError("Email cannot be empty");
            emailinput.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            passinput.setError("Password cannot be empty");
            passinput.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Signup.this, "User Registered", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Signup.this, UserLogin.class));
                    }else{
                        Toast.makeText(Signup.this, "Registration Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}