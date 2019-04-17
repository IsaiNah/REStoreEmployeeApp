package com.example.restoreemployeeapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapterMainMenu extends  RecyclerView.Adapter<RecyclerViewAdapterMainMenu.MyViewHolder> {
    private static final String TAG = "SEA_Log";
    private Context context;//For layout inflater
    private List<MenuItem> list; // list of menu items


public RecyclerViewAdapterMainMenu(Context context, List<MenuItem> list)
{
    try{
        this.context = context;
        this.list = list;
    } catch (Exception e)
    {
        Log.d(TAG, "RecyclerViewAdapterMainMenu: " + e);
    }
}

    //Returns UI Elements
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview_menuitem, null);// inflates the cardview layout

        return new MyViewHolder(view);
    }

    //Binds data to viewholder
    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewAdapterMainMenu.MyViewHolder holder, int position) {
        final MenuItem menuItem = list.get(position);
        Log.d(TAG, "onBindViewHolder: counter");
        try {
            holder.textTitle.setText(menuItem.getMenuTitle());
            holder.imageView.setImageDrawable(context.getResources().getDrawable(menuItem.getImage()));
        } catch (Exception e) {
            Log.d(TAG, "onBindViewHolder: " + e);
        }

        try {
            holder.cardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    /* //Creating data bundle to pass to fragment
                    Bundle bundle = new Bundle();
                    bundle.putString("Title", menuItems.getCollectionTitle());
                    bundle.putString("Description", productCollections.getCollectionDesc());
                    bundle.putString("Filename", productCollections.getFilename());
                    bundle.putInt("Id", productCollections.getCollectionImage());

                    fragmentAllCollections.setArguments(bundle);*/
                    FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();

                    Log.d(TAG, "onClick: Clicked on " + holder.getLayoutPosition());

                    // Launching Fragment
                    switch (holder.getLayoutPosition())
                    {
                        case 0: FragmentInformation fragmentInformation = new FragmentInformation();
                                fragmentInformation.show(fm, "Fragment Information");
                                break;

                        case 2: FragmentCoworkers fragmentCoworkers = new FragmentCoworkers();
                        fragmentCoworkers.show(fm, "Fragment Coworkers");
                                 break;

                    }

                }
            });

        }catch(Exception e)
        {
            Log.d(TAG, "onBindViewHolder: Exception" +e);
        }



    }

    //Returns size of the list
    @Override
    public int getItemCount() {

        Log.d(TAG, "getItemCount: value of list size : " + list.size());
        return this.list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView textTitle;
        CardView cardView;

        public MyViewHolder(View itemView)
        {
            super(itemView);


            imageView = itemView.findViewById(R.id.mainmenu_image);
            textTitle = itemView.findViewById(R.id.mainmenu_title);
            cardView  = itemView.findViewById(R.id.cardview_mainmenu);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            MenuItem menuItem = list.get(getAdapterPosition());
            Log.d(TAG, "onClick: New OnClick Object = " );
        }
    }

}
