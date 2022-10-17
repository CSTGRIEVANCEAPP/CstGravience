package com.example.cstgravience;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GravienceForm  extends AppCompatActivity {
    Button addGrievance,cancel_button,addtodrafts;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    EditText Grievance_Text;

    Spinner spinner;
    String[] grievance={"","Academic","Hostel","Personal","Others"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

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


        addGrievance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(spinner.getSelectedItemPosition()==0){
                    Toast.makeText(GravienceForm.this, "Please select a category", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("category");
                    String key = reference.push().getKey();

                    String grievance = Grievance_Text.getText().toString();
                    String sCategory = spinner.getSelectedItem().toString();
                    Toast.makeText(GravienceForm.this, sCategory + "", Toast.LENGTH_SHORT).show();
                    HelperClass helperClass = new HelperClass(grievance, key);
                    reference.child(sCategory).child(key).setValue(helperClass);
                }
            }
        });

        addtodrafts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}