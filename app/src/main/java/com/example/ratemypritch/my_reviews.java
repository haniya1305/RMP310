package com.example.ratemypritch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

public class my_reviews extends AppCompatActivity {
    private String heading, body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reviews);
        TextView title = (TextView) findViewById(R.id.textView14);
        TextView comment = (TextView) findViewById(R.id.textView5);
        Button b2 = findViewById(R.id.button2);
        ImageButton back_button = (ImageButton) findViewById(R.id.imagebutton);
        RatingBar ratingbar = (RatingBar) findViewById(R.id.ratingBar2);
        Intent rating  = getIntent();
        Bundle bundle = rating.getExtras();
        Bundle bundle2 = new Bundle();

        if (rating.hasExtra("review")) {
            Float review = bundle.getFloat("review");
            heading = bundle.getString("title");
            body = bundle.getString("comment");
            ratingbar.setRating(review);

        }

        Intent intent = new Intent(this, LandingPage.class);
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        Intent intent2 = new Intent(this, MainView.class);
        back_button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                bundle2.putString("title", title.toString());
                bundle2.putString("comment", comment.toString());
                bundle2.putFloat("rating", ratingbar.getRating());
                intent2.putExtras(bundle2);
                startActivity(intent2);
            }
        });

    }
}