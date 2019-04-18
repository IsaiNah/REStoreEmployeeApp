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
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapterUsers extends RecyclerView.Adapter<RecyclerViewAdapterUsers.MyViewHolder> {

    private static final String TAG = " OrogolcLog";
    private Context context;//For layout inflater
    private List<User> list; //List of List of Facial Features

    public  RecyclerViewAdapterUsers(Context context, List<User> list)
    {
        try {
            this.context = context;
            this.list = list;
        }catch (Exception e)
        {
            Log.d(TAG, "Exception in RecyclerViewAdapter:" + e);
        }
    }

    //Returns UI Elements
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_layoutuser, null);// inflates the cardview layout

        return new MyViewHolder(view);
    }

    //Binds data to viewholder
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterUsers.MyViewHolder holder, int position) {
        final User user = list.get(position);
        Log.d(TAG, "onBindViewHolder: counter");
        try {
            holder.textName.setText(user.getFirstName() + " " + user.getLastName());
            holder.textEmail.setText(user.getEmail());
            holder.textPhone.setText(user.getPhone());
            holder.imageView.setImageDrawable(context.getResources().getDrawable(user.getImage()));


            /*Log.d(TAG, "onBindViewHolder: findmatch highlight getter" + findMatch.isHighlight());
            if (findMatch.isHighlight()) {
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
        TextView textName, textEmail, textPhone;
        CardView cardView;

        public MyViewHolder(View itemView)
        {
            super(itemView);


            imageView = itemView.findViewById(R.id.user_picture);
            textName = itemView.findViewById(R.id.user_name);
            textEmail = itemView.findViewById(R.id.user_email);
            textPhone = itemView.findViewById(R.id.user_phone);
            cardView  = itemView.findViewById(R.id.card_users);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            User user = list.get(getAdapterPosition());


          /*  Log.d(TAG, "onClick: is highlight status : " + findMatch.isHighlight());
            if(!findMatch.isHighlight()) {
                cardView.setCardBackgroundColor(Color.parseColor("#c3b180"));
                findMatch.HighLight();

            }else {
                cardView.setCardBackgroundColor(Color.parseColor("#000000"));
                findMatch.HighLight();
            }*/

            Log.d(TAG, "onClick: New OnClick Object = " + user.getEmail() + " ");
        }
    }
}