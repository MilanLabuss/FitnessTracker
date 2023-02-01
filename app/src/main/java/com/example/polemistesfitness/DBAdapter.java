package com.example.polemistesfitness;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//recycleview adapter
public class DBAdapter extends RecyclerView.Adapter<DBAdapter.MyViewHolder> {


    Context context;
    ArrayList ExerciseName, setWeight, setReps, setDate;


    public DBAdapter(Context context, ArrayList exerciseName, ArrayList setWeight, ArrayList setReps, ArrayList setDate) {
        this.context = context;
        ExerciseName = exerciseName;
        this.setWeight = setWeight;
        this.setReps = setReps;
        this.setDate = setDate;
    }

    @NonNull
    @Override
    public DBAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //getting our row layout for our recyclerview
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DBAdapter.MyViewHolder holder, int position) {
        //getting the positon of the arraylist
        holder.ExerciseName_txt.setText(String.valueOf(ExerciseName.get(position)));
        holder.setWeight_txt.setText(String.valueOf(setWeight.get(position)));
        holder.setReps_txt.setText(String.valueOf(setReps.get(position)));
        holder.setDate_txt.setText(String.valueOf(setDate.get(position)));
    }

    @Override
    public int getItemCount() {
        return ExerciseName.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView ExerciseName_txt, setWeight_txt, setReps_txt, setDate_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ExerciseName_txt = itemView.findViewById(R.id.exercise_name_txt);
            setWeight_txt = itemView.findViewById(R.id.weight_txt);
            setReps_txt = itemView.findViewById(R.id.exercise_reps_txt);
            setDate_txt = itemView.findViewById(R.id.set_date_txt);


        }
    }




}
