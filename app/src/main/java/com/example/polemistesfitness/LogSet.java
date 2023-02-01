package com.example.polemistesfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogSet extends AppCompatActivity {

    TextView tview;
    String ename;
    EditText weight_input, reps_input;
    Button submitbtn;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_set);



        tview= findViewById(R.id.exerciseName);

        ename = getIntent().getStringExtra("ename");
        tview.setText(ename);

        weight_input = findViewById(R.id.weighttxt);
        reps_input = findViewById(R.id.repstxt);
        submitbtn = findViewById(R.id.logsetbtn);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper mydb = new DatabaseHelper(LogSet.this);
                mydb.addSet(ename,
                        Integer.valueOf(weight_input.getText().toString()),
                        Integer.valueOf(reps_input.getText().toString()),
                        sdf.format(new Date()).toString());
            }
        });


    }


}