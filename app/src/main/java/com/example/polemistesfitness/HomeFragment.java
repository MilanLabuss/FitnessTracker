package com.example.polemistesfitness;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class HomeFragment extends Fragment {

    DatabaseHelper mydb;
    RecyclerView recyclerView;
    ArrayList<String> exercise_name, set_weight, set_reps, set_date;
    ArrayList<String> total_weight, total_reps;  //for the weekly stats

    //making instance of db adapter class
    DBAdapter dbadapter;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String todaydate;
    String weekAgoDate;
    int totalMonthlyReps=0;
    int totalMonthlyWeight=0;
    int totalMonthSets=0;
    TextView weighttxt;
    TextView repstxt;
    TextView setstxt;
    TextView fitscoretxt;
    int fitnessScore;




    public HomeFragment() {
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

       recyclerView = (RecyclerView) view.findViewById(R.id.homerecycle);

       //resetting in case a new set was added
        totalMonthlyReps=0;
        totalMonthlyWeight=0;
        totalMonthSets=0;
        fitnessScore=0;



        mydb = new DatabaseHelper(getContext());
        exercise_name = new ArrayList<>();
        set_weight = new ArrayList<>();
        set_reps = new ArrayList<>();
        set_date= new ArrayList<>();
        total_weight= new ArrayList<>();
        total_reps= new ArrayList<>();


        todaydate = sdf.format(new Date()).toString();
        weekAgoDate = sdf.format(new Date(System.currentTimeMillis() - 7L * 24 * 3600 * 1000)).toString();

        System.out.println("Week Ago Date: "+weekAgoDate);
        storeDatainArrays();
        TotalSetsWeek(todaydate, weekAgoDate);
        dbadapter = new DBAdapter(getContext(),exercise_name ,set_weight,set_reps,set_date);
        recyclerView.setAdapter(dbadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //for loop to get total sets and weight for the week and put into textviews
        for(int i=0;i<total_weight.size();i++) {
            totalMonthlyWeight += Integer.parseInt(total_weight.get(i));
            totalMonthlyReps += Integer.parseInt(total_reps.get(i));
            System.out.println("Total sets: " + total_weight.size());
        }
        //Fitness score is total number of sets by 2 in the month
        //fitnessScore = (total_weight.size()*2);
        fitnessScore = (totalMonthlyReps+totalMonthlyWeight)/(total_weight.size()*5);

        weighttxt =  view.findViewById(R.id.totalweighttxt);
        weighttxt.setText(String.valueOf(totalMonthlyWeight));
        repstxt = view.findViewById(R.id.totalrepstxt);
        repstxt.setText(String.valueOf(totalMonthlyReps));
        setstxt = view.findViewById(R.id.totalsetstxt);
        setstxt.setText(String.valueOf(total_weight.size()));
        fitscoretxt = view.findViewById(R.id.fitscoretxt);
        fitscoretxt.setText(String.valueOf(fitnessScore));


        return view;

    }

    //Storing the data of the past week
     void TotalSetsWeek(String todaydate, String weekAgoDate) {
       //calling the method in db java class and storing it in cursor
       Cursor cursor = mydb.TotalSetsWeek(todaydate,weekAgoDate);    //Im going to change this to read only todays Data
       if(cursor.getCount() == 0){
           Toast.makeText(getContext(), "Start a Workout Today", Toast.LENGTH_SHORT).show();
       }
       //Here we read the columns by their number
       else{
           while (cursor.moveToNext()){
               //these columindexes might need changing
               System.out.println(cursor.getString(2));
               total_weight.add(cursor.getString(2));
               total_reps.add(cursor.getString(3));


           }
       }
    }



//Storing Todays Data
    void storeDatainArrays(){
        //calling the method in db java class and storing it in cursor
        Cursor cursor = mydb.readDate(todaydate);    //Im going to change this to read only todays Data
        if(cursor.getCount() == 0){
            Toast.makeText(getContext(), "Start a Workout Today", Toast.LENGTH_SHORT).show();
        }
        //Here we read the columns by their number
        else{
            while (cursor.moveToNext()){
                    //these columindexes might need changing
                exercise_name.add(cursor.getString(1)); //storing column data in arraylist
                set_weight.add(cursor.getString(2));
                set_reps.add(cursor.getString(3));
                set_date.add(cursor.getString(4));

            }
        }

    }

}