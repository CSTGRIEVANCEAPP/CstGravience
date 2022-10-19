package com.example.cstgravience;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Adminlogin extends AppCompatActivity {
Button adminlogin;
EditText admin_email,admin_password,admin_ID;
FirebaseAuth Admin_Auth;
ProgressBar Progress_Bar;
    public static final String SHARED_PREF = "sharedPrefs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_adminlogin);

        adminlogin = findViewById(R.id.loginadmin);
        Admin_Auth = FirebaseAuth.getInstance();
        admin_email = findViewById(R.id.EmailAddress);
        admin_password = findViewById(R.id.Password);
        Progress_Bar = findViewById(R.id.progress_bar);
        admin_ID = findViewById(R.id.admin_ID);
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
        String check = sharedPreferences.getString("CHECK", "");
        if(check.equals("true")){
            startActivity(new Intent(Adminlogin.this,Adminpage.class));
            finish();
        }

        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Progress_Bar.setVisibility(View.VISIBLE);
                String email = admin_email.getText().toString().trim();
                String password = admin_password.getText().toString().trim();
                String admin_id = admin_ID.getText().toString();

                if(TextUtils.isEmpty(admin_id)){
                    Progress_Bar.setVisibility(View.GONE);
                    admin_ID.setError("Enter The ID");
                    return;
                }

                if(!admin_id.equals("123")){
                    Progress_Bar.setVisibility(View.GONE);
                    admin_ID.setError("Wrong ID");
                  return;
                }

                if(TextUtils.isEmpty(email)){
                    Progress_Bar.setVisibility(View.GONE);
                    admin_email.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Progress_Bar.setVisibility(View.GONE);
                    admin_password.setError("Password is required");
                    return;
                }

                Admin_Auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            if(Admin_Auth.getCurrentUser().isEmailVerified()){
                                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("CHECK", "true");
                                editor.putString("EMAIL", admin_email.getText().toString());
                                editor.apply();
                                Toast.makeText(Adminlogin.this,"Logged In Successfully",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Adminlogin.this,Adminpage.class));
                            }
                            else{
                                Progress_Bar.setVisibility(View.GONE);
                                Toast.makeText(Adminlogin.this,"verify your email",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Progress_Bar.setVisibility(View.GONE);
                            Toast.makeText(Adminlogin.this,""+task.getException().toString(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });

//                Intent intent=new Intent(Adminlogin.this,Adminpage.class);
//                startActivity(intent);

            }
        });


    }
}