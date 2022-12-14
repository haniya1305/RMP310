package com.example.ratemypritch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

public class departmental_reviews extends AppCompatActivity {

    //private Button
    private String heading, body;
    DB_Helper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departmental_reviews);

        DB = new DB_Helper(this);

        RatingBar beyondBar = (RatingBar) findViewById(R.id.beyondBar);
        ImageButton backButton = (ImageButton) findViewById(R.id.backBtn);
        ImageButton forwardButton = (ImageButton) findViewById(R.id.beyondForward);
        TextView sample = (TextView) findViewById(R.id.textView2);

        //sample.setText("This is a test");

        Intent intent = new Intent(this, CurrentReviews.class);
        Intent intent2 = new Intent(this, MainView.class);
        Intent rating  = getIntent();

        Bundle bundle = rating.getExtras();
        if (rating.hasExtra("review")) {

            Float review = bundle.getFloat("review");
            heading = bundle.getString("title");
            body = bundle.getString("comment");
            beyondBar.setRating(review);
        }

        beyondBar.setRating(DB.avgreview());

        //sample.setText(heading);


        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // IF YOU ARE WORKING ON THE PREVIOUS PAGE, USE THIS TO GET THE INFORMATION
                startActivity(intent2);
            }
        });


    }
}