package com.example.pc.customadapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 08-Jul-17.
 */

public class AndroidFlavourAdapter extends ArrayAdapter<AndroidFlavour> {


    public AndroidFlavourAdapter(Activity context, ArrayList<AndroidFlavour> androidFlavours) {
        super(context, 0 , androidFlavours);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        final AndroidFlavour currentAndroidFlavour = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.version_name);
        nameTextView.setText(currentAndroidFlavour.getmVersionName());
        nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"u clicked on"+currentAndroidFlavour.getmVersionName(),Toast.LENGTH_LONG).show();
            }
        });

        TextView numberTextView = (TextView) listItemView.findViewById(R.id.version_number);
        numberTextView.setText(currentAndroidFlavour.getmVersionNumber());



        return listItemView;



    }
}
