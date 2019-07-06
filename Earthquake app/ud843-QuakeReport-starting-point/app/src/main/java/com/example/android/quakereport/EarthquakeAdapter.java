package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.location.Location;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by PC on 08-Jul-17.
 */

public class EarthquakeAdapter extends ArrayAdapter<EarthquakeTypes> {

    private static final String Location_Seperator = "of";
    public EarthquakeAdapter(Activity context, ArrayList<EarthquakeTypes> earthquakes) {
        super(context, 0 , earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View list_itemview = convertView;
        if (list_itemview == null){
            list_itemview = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        EarthquakeTypes currentEarthquake = getItem(position);



        TextView magnitudeTextView = (TextView) list_itemview.findViewById(R.id.magnitude);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        magnitudeCircle.setColor(magnitudeColor);

        String formattedMagnitude = formatettedMagnitude(currentEarthquake.getMagnitude());
        magnitudeTextView.setText(formattedMagnitude);

        String originalLocation = currentEarthquake.getLocation();
        String primaryLocation;
        String locationOffset;
        if(originalLocation.contains(Location_Seperator)){
            String [] parts = originalLocation.split(Location_Seperator);
            locationOffset = parts[0] + Location_Seperator;
            primaryLocation = parts[1];
        }
        else
        {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView locationOffsetTextView = (TextView) list_itemview.findViewById(R.id.location_offset);
        locationOffsetTextView.setText(locationOffset);

        TextView primaryLocationTextView = (TextView) list_itemview.findViewById(R.id.primary_location);
        primaryLocationTextView.setText(primaryLocation);

        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());
        String formattedDate = formatDate(dateObject);

        TextView dateTextView = (TextView) list_itemview.findViewById(R.id.date);
        dateTextView.setText(formattedDate);

        TextView timeTextView = (TextView) list_itemview.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeTextView.setText(formattedTime);

        return list_itemview;
    }

    private int getMagnitudeColor(double magnitude) {

        int magnitudeResourseId;
        int magnitudeFloor = (int) Math.floor(magnitude);

        switch (magnitudeFloor){
            case 1:
                magnitudeResourseId = R.color.magnitude1;
                break;
            case 2:
                magnitudeResourseId = R.color.magnitude2;
                break;
            case 3:
                magnitudeResourseId = R.color.magnitude3;
                break;
            case 4:
                magnitudeResourseId = R.color.magnitude4;
                break;
            case 5:
                magnitudeResourseId = R.color.magnitude5;
                break;
            case 6:
                magnitudeResourseId = R.color.magnitude6;
                break;
            case 7:
                magnitudeResourseId = R.color.magnitude7;
                break;
            case 8:
                magnitudeResourseId = R.color.magnitude8;
                break;
            case 9:
                magnitudeResourseId = R.color.magnitude9;
                break;
            default:
                magnitudeResourseId = R.color.magnitude10PLUS;
                break;
        }
        return ContextCompat.getColor(getContext(),magnitudeResourseId);
    }

    private String formatettedMagnitude(double magnitude) {

        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private String formatTime(Date dateObject) {

        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm:a");
        return timeFormat.format(dateObject);
    }

    private String formatDate(Date dateObject) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
}
