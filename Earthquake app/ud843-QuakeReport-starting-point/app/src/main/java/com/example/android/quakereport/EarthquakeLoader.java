package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by PC on 14-Aug-17.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<EarthquakeTypes>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    private String mUrl;
    public EarthquakeLoader(Context context,String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<EarthquakeTypes> loadInBackground() {
        if(mUrl == null)
        {
            return null;
        }

        List<EarthquakeTypes> result = QueryUtils.fetchEarthquakeData(mUrl);
        return result;
    }
}
