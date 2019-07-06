package com.example.pc.customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<AndroidFlavour> androidFlavours = new ArrayList<AndroidFlavour>();
        androidFlavours.add(new AndroidFlavour("Donut","1.6"));
        androidFlavours.add(new AndroidFlavour("Eclair","2.0-2.1"));
        androidFlavours.add(new AndroidFlavour("Froyo","2.2-2.3"));
        androidFlavours.add(new AndroidFlavour("GingerBeard","2.3-2.3.7"));
        androidFlavours.add(new AndroidFlavour("HonetyComb","3.0-3.2.6"));
        androidFlavours.add(new AndroidFlavour("Ice-cream sandwich","4.0-4.0.4"));
        androidFlavours.add(new AndroidFlavour("Jelly Bean","4.1-4.3.1"));
        androidFlavours.add(new AndroidFlavour("Kitkat","4.4-4.4.4"));
        androidFlavours.add(new AndroidFlavour("Lollipop","5.0-5.1.1"));
        androidFlavours.add(new AndroidFlavour("Marshmallow","6.0-6.0.1"));
        androidFlavours.add(new AndroidFlavour("Naugot","7.0-7.1"));

        AndroidFlavourAdapter flavourAdapter = new AndroidFlavourAdapter(this,androidFlavours);

        ListView listView =(ListView) findViewById(R.id.listview_flavour);
        listView.setAdapter(flavourAdapter);
    }
}
