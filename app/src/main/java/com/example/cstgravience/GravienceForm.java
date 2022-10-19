package com.example.cstgravience;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GravienceForm  extends AppCompatActivity {
    Button addGrievance,cancel_button,addtodrafts;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    EditText Grievance_Text;

    Spinner spinner;
    String[] grievance={"Select Category","Academic","Hostel","Personal","Others"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravience_form);
        spinner =findViewById(R.id.categorydropdown);



        ArrayAdapter<String> adapter=new ArrayAdapter<String>(GravienceForm.this, android.R.layout.simple_spinner_item,grievance);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelected(false);
        addGrievance = (Button) findViewById(R.id.postG);
        cancel_button = (Button) findViewById(R.id.cancelG);
        Grievance_Text=(EditText) findViewById(R.id.ugrievance);
        addtodrafts = (Button) findViewById(R.id.addtodrafts);

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Grievance_Text.setText("");
                spinner.setSelection(0);
            }
        });

        addGrievance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TextGv = Grievance_Text.getText().toString();

                if(spinner.getSelectedItemPosition()==0){
                    Toast.makeText(GravienceForm.this, "Please select a category", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(TextGv.matches("")){
                    Toast.makeText(GravienceForm.this,"Please write your Grievance", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Grievance_Text.getContext());
                    builder.setTitle("Are you sure?");
                    builder.setMessage("Posted data can't be undo.");

                    builder.setPositiveButton("Post", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            rootNode = FirebaseDatabase.getInstance();
                            reference = rootNode.getReference("category");
                            String key = reference.push().getKey();
                            Date d = new Date();
                            String date =String.valueOf(d);
                            Toast.makeText(GravienceForm.this, date+"", Toast.LENGTH_SHORT).show();

                            String grievance = Grievance_Text.getText().toString();
                            String sCategory = spinner.getSelectedItem().toString();
                            HelperClass helperClass = new HelperClass(grievance, key,sCategory,date);
                            reference.child(sCategory).child(key).setValue(helperClass);
                            Toast.makeText(GravienceForm.this, "Grievance Posted", Toast.LENGTH_SHORT).show();
                            Grievance_Text.setText("");
                            spinner.setSelection(0);
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Grievance_Text.getContext(),"Cancelled",Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
            }
        });




        //not displaying in drafts activity
      addtodrafts.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String grievance = Grievance_Text.getText().toString();
              if(spinner.getSelectedItemPosition()==0){
                  Toast.makeText(GravienceForm.this, "Please select a category", Toast.LENGTH_SHORT).show();
                  return;
              }
              if(grievance.matches("")){
                  Toast.makeText(GravienceForm.this,"Please write your Grievance", Toast.LENGTH_SHORT).show();
                  return;
              }

              AlertDialog.Builder builder = new AlertDialog.Builder(Grievance_Text.getContext());
              builder.setTitle("Are you sure?");
              builder.setMessage("Added data can't be undo.");

              builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      String sCategory = spinner.getSelectedItem().toString();
                      String grievance = Grievance_Text.getText().toString();
                      FirebaseUser cUser = FirebaseAuth.getInstance().getCurrentUser();

                      String uID = cUser.getUid();
                      String uEmail = cUser.getEmail().toString();
                      FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                      DatabaseReference databaseReference = firebaseDatabase.getReference("Draft");

                      String key = databaseReference.push().getKey();
                      Date d = new Date();
                      String date =String.valueOf(d);
                      DraftGrievance draftGrievance = new DraftGrievance(sCategory,grievance,uEmail,key,date);
                      databaseReference.child(key).setValue(draftGrievance);

                      Toast.makeText(Grievance_Text.getContext(),"Added to Your Draft",Toast.LENGTH_SHORT).show();
                      Grievance_Text.setText("");
                      spinner.setSelection(0);
                  }
              });

              builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      Grievance_Text.setText("");
                      spinner.setSelection(0);
                      Toast.makeText(Grievance_Text.getContext(),"Cancelled",Toast.LENGTH_SHORT).show();
                  }
              });
              builder.show();


          }
      });
    }
}