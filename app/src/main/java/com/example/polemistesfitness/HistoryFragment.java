package com.example.polemistesfitness;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.telecom.TelecomManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class HistoryFragment extends Fragment {

    CalendarView calendar;
    TextView tviewdate;
    DatabaseHelper mydb;
    RecyclerView recyclerView;
    ArrayList<String> exercise_name, set_weight, set_reps, set_date;
    //making instance of db adapter class
    DBAdapter dbadapter;
    static String date;

    public HistoryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_history, container, false);

         calendar = (CalendarView) v.findViewById(R.id.calendarView); // get the reference of CalendarView
        //i need to get the date the user picks so i can search for it in
        //in my database object date==date
        tviewdate = v.findViewById(R.id.datetxt);


        recyclerView = (RecyclerView) v.findViewById(R.id.historyRecycle);

        mydb = new DatabaseHelper(getContext());




        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarview, int Year, int Month,int Day) {
                exercise_name = new ArrayList<>();
                set_weight = new ArrayList<>();
                set_reps = new ArrayList<>();
                set_date= new ArrayList<>();
                //formatting to dd/mm/yyyy

                String sYear = String.valueOf(Year);
                String sMonth = String.valueOf((Month + 1));
                String sDay = String.valueOf(Day);

                if (sDay.length() == 1) {
                    sDay = "0" + sDay;
                }

                if (sMonth.length() == 1) {
                    sMonth = "0" + sMonth;
                }
                if (sDay.length() == 1){
                    sDay = "0" + sDay;
                }


                date =   sDay + "/" + sMonth + "/" + sYear;

                //month needs plus 1 because it starts at 0
                tviewdate.setText(date);
                storeDataDateinArrays();
                //IN this function i need to pass date
                dbadapter = new DBAdapter(getContext(),exercise_name ,set_weight,set_reps,set_date);
                recyclerView.setAdapter(dbadapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


            }
        });






        return v;
    }
    void storeDataDateinArrays(){
        //calling the method in db java class and storing it in cursor
        Cursor cursor = mydb.readDate(date);

        if(cursor.getCount() == 0){
            Toast.makeText(getContext(), "No Data", Toast.LENGTH_SHORT).show();
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