package com.techfest.tf2017.abcd;

import java.util.ArrayList;

class data {

    private final ArrayList<String> name;
    private final ArrayList<String> link;
    private final ArrayList<String> imglink;
    private final ArrayList<String> intro;
    private final ArrayList<String> time;

    public data(ArrayList<String> mname, ArrayList<String> mlink, ArrayList<String> minglink, ArrayList<String> mintro, ArrayList<String> mtime) {

        name = mname;
        link = mlink;
        imglink = minglink;
        intro = mintro;
        time = mtime;

    }

    public ArrayList<String> getMName() {
        return name;
    }

    public ArrayList<String> getLink() {
        return link;
    }

    public ArrayList<String> getImglink() {
        return imglink;
    }

    public ArrayList<String> getIntro() {
        return intro;
    }

    public ArrayList<String> getMTime() {
        return time;
    }


}

