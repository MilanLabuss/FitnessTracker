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
        CharSequence Emptytext = "Please input number";
        int duration = Toast.LENGTH_SHORT;
        Toast toastEmpty = Toast.makeText(this, Emptytext, duration);

        CharSequence DoYoutext = "Do you even lift";
        Toast toastDoYou = Toast.makeText(this, DoYoutext, duration);

        CharSequence BeRealtext = "Be Realistic";
        Toast toastBeReal = Toast.makeText(this, BeRealtext, duration);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper mydb = new DatabaseHelper(LogSet.this);

                if((weight_input.getText().toString().trim().length() <= 0) || (reps_input.getText().toString().trim().length() <= 0) ){
                    toastEmpty.show();
                }
                else if( Integer.valueOf(weight_input.getText().toString()) < 1 ||
                Integer.valueOf(reps_input.getText().toString()) <1 ){
                    toastDoYou.show();
                }
                else if (Integer.valueOf(weight_input.getText().toString()) > 10000 ||
                        Integer.valueOf(reps_input.getText().toString()) > 10000 ) {
                    toastBeReal.show();
                }
                else{

                    mydb.addSet(ename,
                            Integer.valueOf(weight_input.getText().toString()),
                            Integer.valueOf(reps_input.getText().toString()),
                            sdf.format(new Date()).toString());

                }

            }
        });


    }


}