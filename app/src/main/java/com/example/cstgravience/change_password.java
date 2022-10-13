package com.example.cstgravience;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class change_password extends AppCompatActivity {
Button updatebtn,cancel_button;
EditText userpasswordtxt, userconfirmtxt;
FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        updatebtn=findViewById(R.id.updatebtn);
        cancel_button=findViewById(R.id.cancel_button);
        userpasswordtxt=findViewById(R.id.userpasswordtxt);
        userconfirmtxt=findViewById(R.id.userconfirmtxt);
        user = FirebaseAuth.getInstance().getCurrentUser();


        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userpasswordtxt.getText().toString().isEmpty()){
                    userpasswordtxt.setError("Required Field");
                    return;
                }
                if(userconfirmtxt.getText().toString().isEmpty()){
                    userconfirmtxt.setError("Required FIeld");
                    return;
                }
                if(userconfirmtxt.length() <= 8){
                    userconfirmtxt.setError("Your Password you have atleast 8 characters");
                    return;
                }
                if(userpasswordtxt.length() <= 8){
                    userpasswordtxt.setError("Your Password you have atleast 8 characters");
                    return;
                }
                if(!userpasswordtxt.getText().toString().equals(userconfirmtxt.getText().toString())){
                    userconfirmtxt.setError("Password doesnt match");
                    return;
                }
                user.updatePassword(userpasswordtxt.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(change_password.this, "Password Updated", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(change_password.this, "Error 404", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}