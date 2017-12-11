package com.example.nautatvanavlakha.abcd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amank on 5/12/17.
 */

public class QueryFutil {


    public static List<Item> fetchData(int mPage) {
        List<Item> item = new ArrayList<>();
        List<String> namek = new ArrayList<>();
        List<String> linkk = new ArrayList<>();
        List<String> imglinkk = new ArrayList<>();
        List<String> introk = new ArrayList<>();
        List<String> timek = new ArrayList<>();
        if (HomePage.Data_super.loff.size() > 0) {
        namek = HomePage.Data_super.loff.get(mPage - 1).getMName();
        linkk = HomePage.Data_super.loff.get(mPage - 1).getLink();

        introk = HomePage.Data_super.loff.get(mPage - 1).getIntro();
        timek = HomePage.Data_super.loff.get(mPage - 1).getMTime();
        imglinkk = HomePage.Data_super.loff.get(mPage - 1).getImglink();

        int j = 0;
        for (String k : namek) {
            item.add(new Item(namek.get(j), imglinkk.get(j), timek.get(j), introk.get(j), linkk.get(j)));
            j = j + 1;
        }


        return item;
        }
        else {
        return null;
        }
    }


}
