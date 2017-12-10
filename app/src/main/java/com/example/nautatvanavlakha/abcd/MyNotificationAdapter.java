package com.example.nautatvanavlakha.abcd;

import android.app.LauncherActivity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    private List<ListData> listItems;
    private Context context;

    public MyNotificationAdapter(List<ListData> listItems, Context context) {
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
        ListData listItem = listItems.get(position);


        holder.textViewTittle.setText(listItem.getTitle());
        holder.textViewMessage.setText(listItem.getMessege());

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
