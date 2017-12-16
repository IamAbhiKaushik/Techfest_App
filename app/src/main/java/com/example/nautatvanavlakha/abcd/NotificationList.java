package com.example.nautatvanavlakha.abcd;

import android.app.Activity;
import android.app.Notification;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Abhishek on 11-12-2017.
 */

public class NotificationList extends ArrayAdapter<NotificationData> {

    private Activity context;
    private List<NotificationData> notificationList;

    public NotificationList(Activity context, List<NotificationData> notificationList) {
        super(context, R.layout.notifiation_item, notificationList);

        this.context = context;
        this.notificationList = notificationList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View listviewItem = inflater.inflate(R.layout.notifiation_item, null, true);

        TextView textViewTittle = (TextView) listviewItem.findViewById(R.id.noti_tittle);
        TextView textViewMessage = (TextView) listviewItem.findViewById(R.id.noti_message);

        NotificationData notification = notificationList.get(position);

        textViewMessage.setText(notification.getMessage());
        textViewTittle.setText(notification.getTittle());

        return listviewItem;

    }


}