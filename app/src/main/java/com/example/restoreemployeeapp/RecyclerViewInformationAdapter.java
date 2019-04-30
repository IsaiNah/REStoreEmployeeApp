package com.example.restoreemployeeapp;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewInformationAdapter extends RecyclerView.Adapter<RecyclerViewInformationAdapter.MyViewHolder> {
    private static final String TAG = " SEA_LOG";
    private Context context;//For layout inflater
    private List<Information> list; //List of List of Facial Features


    private PassData passData;


    public RecyclerViewInformationAdapter(Context context, List<Information> list, PassData passData)
    {
        this.context = context;
        this.list = list;
        this.passData = passData;
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

            //TODO remove
            holder.textTitle.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    try {
                     /*   FragmentManager manager = ((AppCompatActivity) context).getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainmenu, new FragmentInformationItem());
                        transaction.commit();*/
                        Toast.makeText(context, "Test", Toast.LENGTH_SHORT);
                    }catch(Exception e)
                    {
                        Log.d(TAG, "onClick: Exception " + e);
                    }
                }
            });

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

            try {
               /* FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();

                // FragmentInformationItem fragmentInformationItem = new FragmentInformationItem();
                //fragmentInformationItem.show(fm, "Item");


                FragmentTransaction transaction = fm.beginTransaction();
                //ft.setCustomAnimations(R.anim)
                FragmentInformationItem fragmentInformationItem = new FragmentInformationItem();
                transaction.replace(R.id.mainmenu, fragmentInformationItem);
                transaction.addToBackStack(null);

                transaction.commit();*/

               // FragmentManager fm = ((FragmentActivity) context).getSupportFragmentManager();

                passData.passdata("Test");

                //AppCompatActivity activity = (AppCompatActivity) v.getContext();

                //FragmentInformationItem fragmentInformationItem = new FragmentInformationItem();
                //MainMenu mainMenu = (MainMenu)context;

                //mainMenu.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_allcollection, fragmentInformationItem).addToBackStack(null).commit();
                // Activity activity = unwrap(v.getContext());
               // activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_allcollection, fragmentInformationItem).addToBackStack(null).commit();
/*

                AppCompatActivity  activity = (AppCompatActivity) v.getContext();
                FragmentInformationItem fragmentInformationItem = new FragmentInformationItem();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.mainmenu, fragmentInformationItem).addToBackStack(null).commit();
*/

             //   ((MainMenu)context).FragmentInformationItem();
             //   FragmentInformationItem fragmentInformationItem = new FragmentInformationItem();
               // fragmentInformationItem.show(fm, "a");



            }catch (Exception e)
            {
                Log.d(TAG, "onClick: Exception " + e);
            }

            Log.d(TAG, "onClick: Click");


        }



    }



}
