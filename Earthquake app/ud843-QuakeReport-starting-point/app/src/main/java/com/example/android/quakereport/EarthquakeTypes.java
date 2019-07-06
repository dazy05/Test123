package com.example.android.quakereport;

/**
 * Created by PC on 08-Jul-17.
 */

public class EarthquakeTypes {

    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;
    private String mUrl;

    public EarthquakeTypes(double magnitude,String location,long timeInMilliseconds,String url )
    {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    public double getMagnitude()
    {
        return mMagnitude;
    }
    public String getLocation()
    {
        return mLocation;
    }
    public long getTimeInMilliseconds()
    {
        return mTimeInMilliseconds;
    }
    public String getUrl(){
        return mUrl;
    }
}
