package com.example.restoreemployeeapp;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewInformationAdapter extends RecyclerView.Adapter<RecyclerViewInformationAdapter.MyViewHolder> {
    private static final String TAG = " SEA_LOG";
    private Context context;//For layout inflater
    private List<Information> list; //List of List of Facial Features

    public RecyclerViewInformationAdapter(Context context, List<Information> list)
    {
        this.context = context;
        this.list = list;
    }

    //Returns UI Elements
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_information_unit, null);// inflates the cardview layout

        return new MyViewHolder(view);
    }

    //Binds data to viewholder
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewInformationAdapter.MyViewHolder holder, int position) {

        final Information information = list.get(position);
        Log.d(TAG, "onBindViewHolder: counter");
        try {
            Log.d(TAG, "Value of title = " + information.getTitle());
            holder.textTitle.setText(information.getTitle());
            holder.textSubA.setText(information.getSubTitleA());
            holder.textSubB.setText(information.getSubTitleB());
           // holder.imageView.setImageDrawable(context.getResources().getDrawable(findMatch.getImage()));


         //   Log.d(TAG, "onBindViewHolder: findmatch highlight getter" + information.isHighlight());
          /*  if (findMatch.isHighlight())
            {
                holder.cardView.setCardBackgroundColor(Color.parseColor("#c3b180"));
            }*/

        } catch (Exception e) {
            Log.d(TAG, "onBindViewHolder: " + e);
        }

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: value of list size : " + list.size());
        return this.list.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView textTitle, textSubA, textSubB;


        public MyViewHolder(View itemView) {
            super(itemView);


            imageView = itemView.findViewById(R.id.item_image);
            textTitle = itemView.findViewById(R.id.item_title);
            textSubA = itemView.findViewById(R.id.item_detail);
            textSubB = itemView.findViewById(R.id.item_staringredients);


            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Information information = list.get(getAdapterPosition());

            Log.d(TAG, "onClick: Click");


        }
    }









}
