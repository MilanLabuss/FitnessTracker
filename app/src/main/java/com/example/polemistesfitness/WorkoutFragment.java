package com.example.polemistesfitness;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class WorkoutFragment extends Fragment {

    RecyclerView recycleview;

    String musclegroupNames[];
    int musclegroupImages[]={R.drawable.chest,R.drawable.arms,R.drawable.back, R.drawable.legs, R.drawable.shoulders};



    public WorkoutFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_workout, container, false);
        recycleview = (RecyclerView) v.findViewById(R.id.muscleGroupRecycle);


        //Storing the String arrays in musclegroupname a
        musclegroupNames = getResources().getStringArray(R.array.muscleGroup_names);

        //If i get a bug it could be this getContext
        RAdapter myadapter = new RAdapter(getContext(),musclegroupNames,musclegroupImages);
        recycleview.setAdapter(myadapter);
        //If i get a bug it could be this getContext
        recycleview.setLayoutManager(new LinearLayoutManager(getContext()));


        return v;
    }
}