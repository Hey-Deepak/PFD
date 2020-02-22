package com.dc.pfd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText first_in_sem_marks, second_in_sem_marks, final_sem_marks, assignment_marks, attendance_marks;
    Button calculateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignVars();
    }

    private void assignVars (){
        first_in_sem_marks = findViewById(R.id.first_insem);
        second_in_sem_marks = findViewById(R.id.second_insem);
        final_sem_marks = findViewById(R.id.final_sem);
        assignment_marks = findViewById(R.id.assignment);
        attendance_marks = findViewById(R.id.attendance);

        calculateBtn = findViewById(R.id.calculate);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
            }
        });
    }

    private void validateForm() {
        try{
            float firstInSem = Float.parseFloat(first_in_sem_marks.getText().toString())
                    , secondInSem = Float.parseFloat(second_in_sem_marks.getText().toString())
                    , finalInSem = Float.parseFloat(final_sem_marks.getText().toString())
                    , assignment = Float.parseFloat(assignment_marks.getText().toString())
                    , attendance = Float.parseFloat(attendance_marks.getText().toString());

            String result = MarksCalculator.calculate(firstInSem, secondInSem, finalInSem, assignment, attendance);

            ((TextView) findViewById(R.id.result)).setText(result);
        } catch (NumberFormatException e){
            e.printStackTrace();
            Toast.makeText(this, "Please, Fill all the Entries first!", Toast.LENGTH_SHORT).show();
        }
    }

}
