package com.techfest.tf2017.abcd;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nautatvanavlakha.abcd.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by Abhishek on 09-12-2017.
 */

public class MyNotificationAdapter extends RecyclerView.Adapter<MyNotificationAdapter.ViewHolder> {

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;
    DatabaseReference mDatabaseReference;
    private List<NotificationData> listItems;
    private Context context;

    public MyNotificationAdapter(List<NotificationData> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notifiation_item, parent, false);

        mAuth = FirebaseAuth.getInstance();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
//        DatabaseReference mChildDataRef = mDatabaseReference.child("Notifications").
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NotificationData listItem = listItems.get(position);


        holder.textViewTittle.setText(listItem.getTittle());
        holder.textViewMessage.setText(listItem.getMessage());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewTittle, textViewMessage;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewTittle = (TextView) itemView.findViewById(R.id.noti_tittle);
            textViewMessage = (TextView) itemView.findViewById(R.id.noti_message);
        }
    }
}
