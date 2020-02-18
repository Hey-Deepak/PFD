package com.dc.pfd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    MarksCalculator marksCalculator = new MarksCalculator(findViewById(R.id.first_insem),findViewById(R.id.second_insem),findViewById(R.id.final_sem), findViewById(R.id.attendance),findViewById(R.id.assignment))

}
