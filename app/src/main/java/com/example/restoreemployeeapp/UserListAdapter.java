package com.example.restoreemployeeapp;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Srijith on 08-10-2017.
 */

public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements
        SwipeAndDragHelper.ActionCompletionContract {
    private static final String TAG = "SEA_Log";
    private static final int USER_TYPE = 1;
    private static final int HEADER_TYPE = 2;
    private List<Employee> usersList;
    private ItemTouchHelper touchHelper;
    private PassData passData;
   // private PassFromAdapter passFromAdapter;


    /*public interface PassFromAdapter {
        void adapterPass(String data);
    }*/

    public UserListAdapter(PassData passData) {
        //this.usersList = usersList;
        this.passData = passData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case USER_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_user_list_item, parent, false);
                return new UserViewHolder(view);
            case HEADER_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_user_list_section_header, parent, false);
                return new SectionHeaderViewHolder(view);
            default:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_user_list_item, parent, false);
                return new UserViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final int itemViewType = getItemViewType(position);
        if (itemViewType == USER_TYPE) {
            ((UserViewHolder) holder).username.setText(usersList.get(position).getName());
            Glide.with(holder.itemView).load(usersList.get(position).getImageUrl()).into(((UserViewHolder) holder).userAvatar);
            ((UserViewHolder) holder).reorderView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                        touchHelper.startDrag(holder);
                    }
                    return false;
                }
            });
        } else {
            SectionHeaderViewHolder headerViewHolder = (SectionHeaderViewHolder) holder;
            headerViewHolder.sectionTitle.setText(usersList.get(position).getType());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");

               //final String itemClicked;
                PopupMenu popupMenu = new PopupMenu(v.getContext(),v);
                //popupMenu.setOnMenuItemClickListener();

                Log.d(TAG, "onClick: " + ((usersList).get(position).getName()));
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Log.d(TAG, "onMenuItemClick: " + menuItem.toString());
                        //TODO PASS Class along with location
                        passData.passdata(menuItem.toString() + " " + (usersList).get(position).getName() + " " + (usersList).get(position).getId()/* + holder.itemView.*/);
                        Log.d(TAG, "onMenuItemClick: " + (usersList).get(position).getClass());
                        return false;
                    }
                });
                popupMenu.inflate(R.menu.popupuserloc_menu);
                popupMenu.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return usersList == null ? 0 : usersList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (TextUtils.isEmpty(usersList.get(position).getName())) {
            return HEADER_TYPE;
        } else {
            return USER_TYPE;
        }
    }

    public void setUserList(List<Employee> usersList) {
        this.usersList = usersList;
        notifyDataSetChanged();
    }

    @Override
    public void onViewMoved(int oldPosition, int newPosition) {
        Employee targetEmployee = usersList.get(oldPosition);
        //Checking current rank
        Log.d(TAG, "Checking Rank: " + targetEmployee.getRank() + " type " + targetEmployee.getType());
        //Checking what type is ABOVE current employee, will orient based on the type located above
        Employee employeeAbove = usersList.get(newPosition - 1);
        //Logging employee above new position
        Log.d(TAG, "Employee above type: " + employeeAbove.getType());
        Employee employee = new Employee(targetEmployee);
        employee.setType(employeeAbove.getType());
        usersList.remove(oldPosition);
        usersList.add(newPosition, employee);
        notifyItemMoved(oldPosition, newPosition);
        Log.d(TAG, "onViewMoved:  Move detected, position updated. Old pos " + oldPosition + " New pos " + newPosition );
    }

    @Override
    public void onViewSwiped(int position) {
        usersList.remove(position);
        notifyItemRemoved(position);
    }

    public void setTouchHelper(ItemTouchHelper touchHelper) {

        this.touchHelper = touchHelper;
    }

    //TODO TEST
    public void setPos(String location, int oldposition)
    {
        Log.d(TAG, "setPos: Location " + location);
        for (int i = 0; i < usersList.size(); i++ )
        {
           if (usersList.get(i).getType().equals(location))
           {
               Log.d(TAG, "setPos: Location Match, Position = " + usersList.get(i).getId());
                int newposition = i++;
               Log.d(TAG, "setPos: Current positions oldPos " + oldposition + " newPos " + newposition);
               onViewMoved(oldposition, newposition);
           }
        }
    }

}
