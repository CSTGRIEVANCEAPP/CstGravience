package com.example.cstgravience;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class resetpassword extends AppCompatActivity {
private EditText emailEditText;
private Button resetbutton;
    ProgressBar Progress_Bar;

FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);

        emailEditText=findViewById(R.id.email);
        resetbutton=findViewById(R.id.resetbtn);
        mAuth= FirebaseAuth.getInstance();
        Progress_Bar=findViewById(R.id.progress_bar);

        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetting();
            }
        });
    }
    private void resetting(){
        String email = emailEditText.getText().toString().trim();

        if(email.isEmpty()){
            emailEditText.setError("Email is required");
            emailEditText.requestFocus();
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Please provide valid email");
            emailEditText.requestFocus();
        }

        Progress_Bar.setVisibility(View.VISIBLE );
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(resetpassword.this, "Check Your Email to reset", Toast.LENGTH_SHORT).show();
                    Progress_Bar.setVisibility(View.INVISIBLE );
                }else{
                    Toast.makeText(resetpassword.this, "Error 404", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}