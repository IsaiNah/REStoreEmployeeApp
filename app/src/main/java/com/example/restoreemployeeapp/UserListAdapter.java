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



public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements
        SwipeAndDragHelper.ActionCompletionContract {
    private static final String TAG = "SEA_Log";
    private static final int USER_TYPE = 1;
    private static final int HEADER_TYPE = 2;
    private List<Employee> usersList;
    private ItemTouchHelper touchHelper;
    private PassData passData;
    private PassEmployee passEmployee;
   // private PassFromAdapter passFromAdapter;


    /*public interface PassFromAdapter {
        void adapterPass(String data);
    }*/

    public UserListAdapter(/*PassData passData*/ PassEmployee passEmployee) {
        //this.usersList = usersList;
        //this.passData = passData;
        this.passEmployee = passEmployee;
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
                        //Passing Employee
                        Employee emp = usersList.get(position);
                        Log.d(TAG, "onMenuItemClick: " + emp.getName() + " " + emp.getType());
                        //Log.d(TAG, "onMenuItemClick: TESTING employee ID " + emp.getId());
                       // passData.passdata(menuItem.toString() + " " + (usersList).get(position).getName() + " " + (usersList).get(position).getId()/* + holder.itemView.*/);
                        passEmployee.passemployee(emp, menuItem.toString());
                        //passData.passemp(emp);
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
        Log.d(TAG, "onViewMoved: CALL ");
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

    public void onViewSimpleMove(int oldPosition, int newPostition)
    {
        Log.d(TAG, "onViewSimpleMove: CALL");
        Employee targetEmployee = usersList.get(oldPosition);
        Employee employee = new Employee(targetEmployee);
        usersList.remove(oldPosition);
        usersList.add(newPostition, employee);
        notifyItemMoved(oldPosition, newPostition);
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
    public void setPos(String location,/* int oldposition*/ Employee employee)
    {
        //TODO issue is with old Pos
        // Recreate all Positions???
        Log.d(TAG, "setPos: Location " + location);
        for (int i = 0; i < usersList.size(); i++ )
        {
            //TODO match by name above?
            Log.d(TAG, "setPos: !Location! = " + usersList.get(i).getType().equals(location));
          //  String setLocation =  usersList.get(i).getType();
           if (usersList.get(i).getType().equals(location) && usersList.get(i).getName().equals(""))
           {

               Log.d(TAG, "setPos: True, item positon = " + i);
           /*   if(usersList.get(i).getName().equals(""))
              {
                  Log.d(TAG, "setPos: MATCH ");
                  Log.d(TAG, "setPos: Position of get name blank " + i);
                  onViewSimpleMove(oldposition, i + 1);
                  break;
              }*/

           /*    int oldpos = employee.getId();
                usersList.add(i + 1,employee);
               usersList.remove(oldpos);
                notifyItemMoved(oldpos,i + 1);
           */
               int oldpos = employee.getId();
           onViewMoved(oldpos, ++i);
                //onViewSimpleMove(employee.getId(), i + 1);


                break;
               //Log.d(TAG, "setPos: Location Match, Position = " + usersList.get(i).getId());

             //  Log.d(TAG, "setPos: New Position " + newposition + " " + usersList.get(i).getType());
               //Log.d(TAG, "setPos: Current positions oldPos " + oldposition + " newPos " + newposition);
               //TODO onViewMoved Causing issue with positioning, create other onViewMoved method
               //TODO which will not cause positioning conflict.
               //TODO check if onViewMoved is really causing conflict
               //onViewMoved(oldposition, newposition);


           }
        }
    }

}
