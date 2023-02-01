package com.example.polemistesfitness;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

//adapter for muscle groups and exercises recyclerview
public class RAdapter extends RecyclerView.Adapter<RAdapter.MyViewHolder> {


    String names[];
    Context context;
    int images[];


    public RAdapter(Context ct, String nm[], int img[] ){
        names=nm;
        images=img;
        context=ct;
    }


    @NonNull
    @Override
    public RAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_row, parent, false);
        return new MyViewHolder(view);
    }

    //
    @Override
    public void onBindViewHolder(@NonNull RAdapter.MyViewHolder holder, int position) {
//Setting the text to the textView from the names array
        holder.Title.setText(names[holder.getAdapterPosition()]);
        holder.myImg.setImageResource(images[holder.getAdapterPosition()]);
        //onclick listener for the rows

        holder.mylayout.setOnClickListener(new View.OnClickListener() {
            @Override
            //might have to use getContext Here
            public void onClick(View v) {
                Intent intent = new Intent(context, ExercisesActivity.class);
                intent.putExtra("Name", names[holder.getAdapterPosition()]);
                //intent.putExtra("myImg", images[holder.getAdapterPosition()]);
                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    //here i will recieve the view and find the id of the UI elements
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Title;
        ImageView myImg;
        //the main contraint layout of the row.xml which will implement on click listener
        ConstraintLayout mylayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //find the ids of the UI elements
            Title = itemView.findViewById(R.id.rowTitleText);
            myImg = itemView.findViewById(R.id.rowImageView);
            mylayout = itemView.findViewById(R.id.mainlayout);



        }
    }

}











