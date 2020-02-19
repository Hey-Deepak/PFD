package com.dc.pfd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        float firstInSemMarks = Float.parseFloat(((EditText) findViewById(R.id.first_insem)).getText().toString());
        float secondInSemMarks = Float.parseFloat(((EditText) findViewById(R.id.second_insem)).getText().toString());
        float finalSemMarks = Float.parseFloat(((EditText) findViewById(R.id.final_sem)).getText().toString());
        float assignmentMarks = Float.parseFloat(((EditText) findViewById(R.id.assignment)).getText().toString());
        float attendanceMarks = Float.parseFloat(((EditText) findViewById(R.id.attendance)).getText().toString());

        MarksCalculator marksCalculator = new MarksCalculator(firstInSemMarks,secondInSemMarks,finalSemMarks,assignmentMarks,attendanceMarks);
    }

}
