package com.example.cstgravience;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class GravienceForm extends AppCompatActivity {


    Spinner spinner;
    String[] grievance={"Academic","Hostel","Personal","Others"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravience_form);

        spinner =findViewById(R.id.categorydropdown);


    }
}