package com.example.polemistesfitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ExercisesActivity extends AppCompatActivity {

    //This is activity chest exercises
    RecyclerView recycleview;
    TextView tview;


    String chestNames[];
    int chestImages[]={R.drawable.benchpress, R.drawable.closegribench, R.drawable.declinebench,
    R.drawable.inclinebench, R.drawable.declinedumbell, R.drawable.inclinedumbellpress};
    String armNames[];
    int armImages[]={R.drawable.barbellcurls,R.drawable.hammercurls, R.drawable.dumbbellcurls,
    R.drawable.cablecurls, R.drawable.skullcrushers};
    String backNames[];
    int backImages[]={R.drawable.barbellrow,R.drawable.latpulldown,
    R.drawable.reardelt, R.drawable.deadlift,R.drawable.stifflegdead};
    String legNames[];
    int legImages[]={R.drawable.calfraise,R.drawable.frontsquat,R.drawable.hamstringcurl,
    R.drawable.legextension,R.drawable.legpress,R.drawable.squats};
    String shoulderNames[];
    int shoulderImages[]={R.drawable.seateddumbbell,R.drawable.seatedmilitary,
    R.drawable.shouldermachine,R.drawable.barbbellraises,R.drawable.sidelaterals};

    String nm;      //this will store the name of the muscle group the user clicked on

    String exercisenameclicked;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_exercises);

        //the recycelview to be filled with exercises
        recycleview = findViewById(R.id.workoutRecycle);

        getData();

        chestNames = getResources().getStringArray(R.array.chest_names);
        backNames = getResources().getStringArray(R.array.back_names);
        armNames = getResources().getStringArray(R.array.arm_names);
        legNames = getResources().getStringArray(R.array.leg_names);
        shoulderNames = getResources().getStringArray(R.array.shoulder_names);



        if (nm.equals("Chest")) {
            RAdapter myadapter = new RAdapter(this,chestNames,chestImages);
            recycleview.setAdapter(myadapter);
            recycleview.setLayoutManager(new LinearLayoutManager(this));
        }
        else if (nm.equals("Back")){
            RAdapter myadapter = new RAdapter(this,backNames,backImages);
            recycleview.setAdapter(myadapter);
            recycleview.setLayoutManager(new LinearLayoutManager(this));
        }
        else if (nm.equals("Arms")){
            RAdapter myadapter = new RAdapter(this,armNames,armImages);
            recycleview.setAdapter(myadapter);
            recycleview.setLayoutManager(new LinearLayoutManager(this));
        }
        else if (nm.equals("Legs")) {
            RAdapter myadapter = new RAdapter(this,legNames,legImages);
            recycleview.setAdapter(myadapter);
            recycleview.setLayoutManager(new LinearLayoutManager(this));
        }
        else if (nm.equals("Shoulders")) {
            RAdapter myadapter = new RAdapter(this,shoulderNames,shoulderImages);
            recycleview.setAdapter(myadapter);
            recycleview.setLayoutManager(new LinearLayoutManager(this));

        }



        getData();
 //start the log activity when one of the exericses is clicked
        if (!(nm.equals("Chest")) && !(nm.equals("Back")) && !(nm.equals("Arms"))
                && !(nm.equals("Legs")) && !(nm.equals("Shoulders"))){
            Intent i = new Intent(ExercisesActivity.this, LogSet.class);
            i.putExtra("ename",nm);
            startActivity(i);
            finish();
        }
        getData();



//        Intent i = new Intent(ExercisesActivity.this, LogSet.class);
//        i.putExtra("ename",nm);
//        startActivity(i);





    }

    //getting the data from intent
    private void getData() {
        if (getIntent().hasExtra("Name")  ){
            nm = getIntent().getStringExtra("Name");

        } else{
            Toast.makeText(this,"No data was found",Toast.LENGTH_SHORT).show();
        }




    }


}