package com.techfest.tf2017.abcd;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by amank on 5/12/17.
 */

class ItemLoader extends AsyncTaskLoader<List<Item>> {
    private final int i;

    public ItemLoader(Context context, int k) {
        super(context);
        i = k;
    }
    @Override
    protected void onStartLoading() {
        forceLoad();
    }
    @Override
    public List<Item> loadInBackground() {
        return QueryFutil.fetchData(i);
    }
}
