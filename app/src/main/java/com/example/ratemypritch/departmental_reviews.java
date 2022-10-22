package com.example.ratemypritch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;

public class departmental_reviews extends AppCompatActivity {

    //private Button
    private String heading, body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departmental_reviews);

        RatingBar beyondBar = (RatingBar) findViewById(R.id.beyondBar);
        ImageButton backButton = (ImageButton) findViewById(R.id.backBtn);
        ImageButton forwardButton = (ImageButton) findViewById(R.id.beyondForward);

        Intent intent = new Intent(this, CurrentReviews.class);
        Intent intent2 = new Intent(this, MainView.class);
        Intent rating  = getIntent();
        Bundle bundle2 = new Bundle();

        Bundle bundle = rating.getExtras();
        if (rating.hasExtra("review")) {

            Float review = bundle.getFloat("review");
            heading = bundle.getString("title");
            body = bundle.getString("comment");
            beyondBar.setRating(review);
        }


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
                bundle2.putFloat("review", beyondBar.getRating());
                bundle2.putString("title", heading.toString());
                bundle2.putString("comment", body.toString());
                intent2.putExtras(bundle2);
                startActivity(intent2);
            }
        });


    }
}