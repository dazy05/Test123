package com.example.pc.customadapter;

/**
 * Created by PC on 08-Jul-17.
 */

public class AndroidFlavour {

    private String mVersionName;
    private String mVersonNmuber;

    public AndroidFlavour(String vName, String nNumber)
    {
        mVersionName=vName;
        mVersonNmuber=nNumber;
    }
    public String getmVersionName() {
        return mVersionName;
    }

    public String getmVersionNumber() {
        return mVersonNmuber;
    }
}
