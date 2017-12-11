package com.example.nautatvanavlakha.abcd;

/**
 * Created by abhishek on 8/12/17.
 */

public class notification {

    private String messege;
    private String title;

    public notification(String messege, String title) {
        this.messege = messege;
        this.title = title;
    }

    public String getMessege() {
        return messege;
    }

    public String getTitle() {
        return title;
    }
}
