package com.example.ratemypritch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageButton settingsButton, nourish, grill, chef, dessert;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);
        settingsButton = (ImageButton) findViewById(R.id.imageButton5);
        nourish = (ImageButton) findViewById(R.id.Settings);
        grill = (ImageButton) findViewById(R.id.imageButton0);
        chef = (ImageButton) findViewById(R.id.imageButton3);
        dessert = (ImageButton) findViewById(R.id.imagebutton);

        Intent intentSettings = new Intent(this, my_reviews.class);
        settingsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(intentSettings);
            }
        });

        Intent nourished = new Intent(this, CurrentReviews.class);
        nourish.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(nourished);
            }
        });

        Intent grilled = new Intent(this, CurrentReviews.class);
        grill.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(grilled);
            }
        });

        Intent chefed = new Intent(this, CurrentReviews.class);
        chef.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(chefed);
            }
        });

        Intent desserted = new Intent(this, CurrentReviews.class);
        dessert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(desserted);
            }
        });
    }
}