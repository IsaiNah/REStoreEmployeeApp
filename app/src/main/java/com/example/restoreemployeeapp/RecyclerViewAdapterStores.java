package com.example.restoreemployeeapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapterStores extends RecyclerView.Adapter<RecyclerViewAdapterStores.ViewHolder> {

    private static final String TAG = "SEA_LOG";
    private Context context;//For layout inflater
    private List<Store> list; //List of List of Facial Features

    private PassData passData; // Interface to pass data from adapter to Coworker fragment

    public RecyclerViewAdapterStores(Context context, List<Store> list/*, PassData passData*/)
    {
        try {
            this.context = context;
            this.list = list;
            /*this.passData = passData;*/
        }catch (Exception e)
        {
            Log.d(TAG, "Exception in RecyclerViewAdapter:" + e);
        }
    }

    //Returns UI Elements
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_layoutstore, null);// inflates the cardview layout

        return new ViewHolder(view);
    }

    //Binds data to viewholder
    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewAdapterStores.ViewHolder holder, int position) {
        final Store store = list.get(position);
        Log.d(TAG, "onBindViewHolder: counter!!");
        try {
            holder.textName.setText(store.getName());
            holder.textAddress.setText(store.getAddress());
           // holder.textPhone.setText(user.getPhone());
            //holder.imageView.setImageDrawable(context.getResources().getDrawable(store.getImage()));

            holder.cardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    // FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();

                    Log.d(TAG, "onClick: Clicked on " + holder.getLayoutPosition());

                }
            });

        } catch (Exception e) {
            Log.d(TAG, "onBindViewHolder: " + e);
        }
    }




    @Override
    public int getItemCount() {

        Log.d(TAG, "getItemCount: value of list size  : " + list.size());
        return this.list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView textName, textAddress;
        CardView cardView;

        public ViewHolder(View itemView)
        {
            super(itemView);


            imageView = itemView.findViewById(R.id.store_picture);
            textName = itemView.findViewById(R.id.store_name);
            textAddress = itemView.findViewById(R.id.store_address);
            //textPhone = itemView.findViewById(R.id.user_phone);
            cardView  = itemView.findViewById(R.id.card_store);
            Log.d(TAG, "Setting click listener: ");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick: ");
            Store store = list.get(getAdapterPosition());


            Toast.makeText(v.getContext(), "Item is clicked Store " + store.getName(), Toast.LENGTH_SHORT).show();

            //Launching DialogFragment

          /*  Log.d(TAG, "onClick: is highlight status : " + findMatch.isHighlight());
            if(!findMatch.isHighlight()) {
                cardView.setCardBackgroundColor(Color.parseColor("#c3b180"));
                findMatch.HighLight();

            }else {
                cardView.setCardBackgroundColor(Color.parseColor("#000000"));
                findMatch.HighLight();
            }*/

            Log.d(TAG, "onClick: New OnClick Object = " + store.getName() + " ");

            //passData.passdata(store.getEmail());
            //FragmentDialogCoworkerExpanded fragmentDialogCoworkerExpanded =  new FragmentDialogCoworkerExpanded();
            //get

        }
    }
}