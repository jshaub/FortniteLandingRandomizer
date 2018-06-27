package me.jshaub.fortnitelandingrandomizer;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random randObj;
    Resources res;
    String[] locationArray;
    String randLocation;
    int numLocations;

    TextView locationStringView;
    Button randomizeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        randObj = new Random();
        res = getResources();
        locationArray = res.getStringArray(R.array.places);
        numLocations = locationArray.length;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationStringView = findViewById(R.id.locationString);
        randomizeButton = findViewById(R.id.randomizeButton);
    }

    private String getRandomLocation() {
        int randNum = randObj.nextInt(numLocations);
        String location = locationArray[randNum];

        return location;
    }

    public void onButtonClick(View v) {
        TextView locationStringView = findViewById(R.id.locationString);
        randLocation = getRandomLocation();

        locationStringView.setText(randLocation);
    }
}
