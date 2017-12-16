package com.example.nautatvanavlakha.abcd;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by abhishek on 8/12/17.
 */
@IgnoreExtraProperties
public class NotificationData {

    private String Message;
    private String Tittle;
    private String id;

    public NotificationData(String Message, String Tittle, String id) {
        this.Message = Message;
        this.Tittle = Tittle;
        this.id = id;
    }

    public String getMessage() {
        return Message;
    }

    public String getTittle() {
        return Tittle;
    }

    public String getId() {
        return id;
    }
}
