package com.example.cstgravience;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class GravienceForm  extends AppCompatActivity {


    Spinner spinner;
    String[] grievance={"Select Category","Academic","Hostel","Personal","Others"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravience_form);

        spinner =findViewById(R.id.categorydropdown);



        ArrayAdapter<String> adapter=new ArrayAdapter<String>(GravienceForm.this, android.R.layout.simple_spinner_item,grievance);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}