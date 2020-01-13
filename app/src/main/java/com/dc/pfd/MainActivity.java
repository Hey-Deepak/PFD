package com.dc.pfd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
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
        //first_in_sem_marks.setError("You need to enter a Number 0 to 50");
        setOnTextChangedListener(first_in_sem_marks, 50);

        second_in_sem_marks = findViewById(R.id.second_insem);
        setOnTextChangedListener(second_in_sem_marks, 50);

        final_sem_marks = findViewById(R.id.final_sem);
        setOnTextChangedListener(final_sem_marks, 100);

        assignment_marks = findViewById(R.id.assignment);
        setOnTextChangedListener(assignment_marks, 15);

        attendance_marks = findViewById(R.id.attendance);
        setOnTextChangedListener(attendance_marks, 5);

        calculateBtn = findViewById(R.id.calculate);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
            }
        });
    }

    private void setOnTextChangedListener(final TextInputEditText editText, final int upperLimit){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0)
                    editText.setError("Can't be left blank");
                else {
                    float no = Float.parseFloat(editText.getText().toString());
                    if(no < 0 || no > upperLimit)
                        editText.setError("Please enter a number between 0 & " + upperLimit);
                    else
                        editText.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void validateForm() {
        String firstInSem = first_in_sem_marks.getText().toString()
                , secondInSem = second_in_sem_marks.getText().toString()
                , finalInSem = final_sem_marks.getText().toString()
                , assignment = assignment_marks.getText().toString()
                , attendance = attendance_marks.getText().toString();

        if(first_in_sem_marks.getError() == null && firstInSem.length() == 0)
            first_in_sem_marks.setError("Can't be left blank");
        if(second_in_sem_marks.getError() == null && secondInSem.length() == 0)
            second_in_sem_marks.setError("Can't be left blank");
        if(final_sem_marks.getError() == null && finalInSem.length() == 0)
            final_sem_marks.setError("Can't be left blank");
        if(assignment_marks.getError() == null && assignment.length() == 0)
            assignment_marks.setError("Can't be left blank");
        if(attendance_marks.getError() == null && attendance.length() == 0)
            attendance_marks.setError("Can't be left blank");

        if(formContainsError())
            return;

        hideKeyboard();

        String result = MarksCalculator.calculate(Float.parseFloat(firstInSem)
                , Float.parseFloat(secondInSem)
                , Float.parseFloat(finalInSem)
                , Float.parseFloat(assignment)
                , Float.parseFloat(attendance));

        ((TextView) findViewById(R.id.result)).setText(result);
    }

    private boolean formContainsError() {
        return first_in_sem_marks.getError() != null
                || second_in_sem_marks.getError() != null
                || final_sem_marks.getError() != null
                || assignment_marks.getError() != null
                || attendance_marks.getError() != null;
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if(view == null || imm == null)
            return;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}



