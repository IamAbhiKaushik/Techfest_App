package com.techfest.tf2017.abcd;

/**
 * Created by amank on 28/11/17.
 */

class Item {

    private final String event_name;

    private final String imageResource;

    private final String time_venue;

    private final String introR;

    private final String descR;

    public Item(String mevent_name, String mimageResource, String mtime_venue, String mdescR, String mintroR) {

        event_name = mevent_name;

        imageResource = mimageResource;

        time_venue = mtime_venue;

        descR = mdescR;

        introR = mintroR;


    }

    public String getEvent_name() {
        return event_name;
    }

    public String getImageResource() {
        return imageResource;
    }

    public String getTime_venue() {
        return time_venue;
    }

    public String getIntroR() {
        return introR;
    }

    public String getDescR() {
        return descR;
    }
}




