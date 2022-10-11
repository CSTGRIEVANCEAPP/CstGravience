package com.example.cstgravience;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cstgravience.fragments.Mainhome;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserLogin extends AppCompatActivity {
Button userlogin,Signup,reset;
EditText emailaddress, Password;
FirebaseAuth mAuth;
ProgressBar Progress_Bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        userlogin=findViewById(R.id.loginuser);
        Signup=findViewById(R.id.Signup);
        emailaddress=findViewById(R.id.EmailAddress);
        Password=findViewById(R.id.Password);
        reset=findViewById(R.id.fogotpw);
        Progress_Bar=findViewById(R.id.progress_bar);
        mAuth = FirebaseAuth.getInstance();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLogin.this, resetpassword.class);
                startActivity(intent);
            }
        });

      userlogin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Progress_Bar.setVisibility(View.VISIBLE);
              String email=emailaddress.getText().toString().trim();
              String password=Password.getText().toString().trim();
              if(TextUtils.isEmpty(email)){
                  Progress_Bar.setVisibility(View.GONE);
                  emailaddress.setError("Email is required");
                  return;
              }
              if(TextUtils.isEmpty(password)){
                  Progress_Bar.setVisibility(View.GONE);
                  Password.setError("Password is required");
                  return;
              }
              if(password.length() <= 8){
                  Progress_Bar.setVisibility(View.GONE);
                  Password.setError("Your Password you have atleast 8 characters");
                  return;
              }

              mAuth.signInWithEmailAndPassword(email,password
              ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful()){
                          if(mAuth.getCurrentUser().isEmailVerified()){
                              Toast.makeText(UserLogin.this,"Logged In Successfully",Toast.LENGTH_SHORT).show();
                              startActivity(new Intent(UserLogin.this,Homepage.class));

                          }
                          else{
                              Progress_Bar.setVisibility(View.GONE);
                              Toast.makeText(UserLogin.this,"verify your email",Toast.LENGTH_SHORT).show();
                          }
                      }
                      else{
                          Progress_Bar.setVisibility(View.GONE);
                          Toast.makeText(UserLogin.this,""+task.getException().toString(),Toast.LENGTH_SHORT).show();
                      }
                  }
              });

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