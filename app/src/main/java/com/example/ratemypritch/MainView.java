package com.example.ratemypritch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import kotlinx.coroutines.MainCoroutineDispatcher;

public class MainView extends AppCompatActivity {
    private String heading, body;
    DB_Helper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageButton settingsButton, nourish, grill, chef, dessert, graph;
        super.onCreate(savedInstanceState);
        DB = new DB_Helper(this);
        setContentView(R.layout.activity_main_view);
        TextView titleView = (TextView) findViewById(R.id.textView1);
        settingsButton = (ImageButton) findViewById(R.id.imageButton5);

        nourish = (ImageButton) findViewById(R.id.Settings);
        grill = (ImageButton) findViewById(R.id.imageButton0);
        chef = (ImageButton) findViewById(R.id.imageButton3);
        dessert = (ImageButton) findViewById(R.id.imagebutton);
        RatingBar stars = (RatingBar) findViewById(R.id.ratingBar);
        graph = (ImageButton) findViewById(R.id.graphButton);

        Intent rating  = getIntent();
        Bundle bundle = rating.getExtras();

        stars.setRating(DB.avgreview());

        if (rating.hasExtra("review")) {

            Float review = bundle.getFloat("review");
            heading = bundle.getString("title");
            body = bundle.getString("comment");
            stars.setRating(review);
        }

        Intent intentSettings = new Intent(this, my_reviews.class);
        Bundle bundle2 = new Bundle();
        settingsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // IF YOU ARE WORKING ON THE PREVIOUS PAGE, USE THIS TO GET THE INFORMATION
                bundle2.putFloat("review", stars.getRating());
                bundle2.putString("title", heading);
                bundle2.putString("comment", body);
                intentSettings.putExtras(bundle2);
                startActivity(intentSettings);
            }
        });

        Intent nourished = new Intent(this, departmental_reviews.class);
        nourish.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(nourished);
            }
        });

        Intent grilled = new Intent(this, departmental_reviews.class);
        grill.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(grilled);
            }
        });

        Intent chefed = new Intent(this, departmental_reviews.class);
        chef.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(chefed);
            }
        });

        Intent desserted = new Intent(this, departmental_reviews.class);
        dessert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(desserted);
            }
        });

        Intent gra = new Intent(this, graph.class);
        graph.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(gra);
            }
        });
    }
}