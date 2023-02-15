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

        //CharSequence DoYoutext = "Do you even lift";
        //Toast toastDoYou = Toast.makeText(this, DoYoutext, duration);

        CharSequence BeRealtext = "Be Realistic";
        Toast toastBeReal = Toast.makeText(this, BeRealtext, duration);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper mydb = new DatabaseHelper(LogSet.this);
             //   if() {
                    String Weightvalue = weight_input.getText().toString().trim();
                    String Repsvalue = reps_input.getText().toString().trim();




                    int RepsInt=0;
                    int weightInt=0;

                    if(Weightvalue.equals("") || Weightvalue==null) {
                        toastEmpty.show();
                    }else{

                        weightInt = Integer.parseInt(Weightvalue);
                    }
                    if(Repsvalue.equals("") || Repsvalue==null) {
                        toastEmpty.show();
                    }else{
                        RepsInt = Integer.parseInt(Repsvalue);

                    }



                    if (weightInt == 0 || RepsInt == 0) {
                        toastEmpty.show();
                    } else if (weightInt > 10000 ||
                            RepsInt > 10000) {
                        toastBeReal.show();
                    } else {

                        mydb.addSet(ename,
                                weightInt,
                                RepsInt,
                                sdf.format(new Date()));

                     }

                   // }
               // else {

              //  }



            }
        });


    }


}