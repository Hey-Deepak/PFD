package com.dc.pfd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

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
        TextInputEditText obj1 = (TextInputEditText) findViewById(R.id.first_insem);
        obj1.setError("You need to enter a Number 0 to 50");

        second_in_sem_marks = findViewById(R.id.second_insem);
        TextInputEditText obj2 = (TextInputEditText) findViewById(R.id.second_insem);
        obj2.setError("You need to enter a Number 0 to 50");

        final_sem_marks = findViewById(R.id.final_sem);
        TextInputEditText obj3 = (TextInputEditText) findViewById(R.id.final_sem);
        obj3.setError("You need to enter a Number 0 to 100");

        assignment_marks = findViewById(R.id.assignment);
        TextInputEditText obj4 = (TextInputEditText) findViewById(R.id.assignment);
        obj4.setError("You need to enter a Number 0 to 15");

        attendance_marks = findViewById(R.id.attendance);
        TextInputEditText obj5 = (TextInputEditText) findViewById(R.id.attendance);
        obj5.setError("You need to enter a Number 0 to 50");

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

            hideKeyboardFrom();

            String result = MarksCalculator.calculate(firstInSem, secondInSem, finalInSem, assignment, attendance);

            ((TextView) findViewById(R.id.result)).setText(result);
        } catch (NumberFormatException e){
                e.printStackTrace();

                Toast.makeText(this, "Please, Fill all the Entries first!", Toast.LENGTH_SHORT).show();
        }
    }

    private void hideKeyboardFrom() {
        View view = this.getCurrentFocus();
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}



