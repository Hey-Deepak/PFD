package com.dc.pfd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    TextInputEditText fism;
    EditText sism, fis, asimt , atends ;
    Button calculateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignVars();
    }

    private void assignVars (){
        fism = findViewById(R.id.first_insem);
        sism = findViewById(R.id.second_insem);
        fis = findViewById(R.id.final_sem);
        asimt = findViewById(R.id.assignment);
        atends = findViewById(R.id.attendance);

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
            float fism1 = Float.parseFloat(fism.getText().toString())
                    , sism1 = Float.parseFloat(sism.getText().toString())
                    , fis1 = Float.parseFloat(fis.getText().toString())
                    , asimt1 = Float.parseFloat(asimt.getText().toString())
                    , atends1 = Float.parseFloat(atends.getText().toString());

            String result = MarksCalculator.calculate(fism1, sism1, fis1, atends1, asimt1);

            ((TextView) findViewById(R.id.result)).setText(result);
        } catch (NumberFormatException e){
            e.printStackTrace();
            Toast.makeText(this, "Please, Fill all the Entries first!", Toast.LENGTH_SHORT).show();
        }
    }

}
