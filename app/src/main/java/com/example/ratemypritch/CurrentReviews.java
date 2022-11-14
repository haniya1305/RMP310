package com.example.ratemypritch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

public class CurrentReviews extends AppCompatActivity {

    DB_Helper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_reviews);
        ImageButton backbutton = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton createbutton = (ImageButton) findViewById(R.id.imageButton8);

        DB = new DB_Helper(this);

        TextView heading = (TextView) findViewById(R.id.textView3);
        TextView body = (TextView) findViewById(R.id.textView5);

        RatingBar totalrating = (RatingBar) findViewById(R.id.ratingBar2);
        RatingBar userrating = (RatingBar) findViewById(R.id.ratingBar4);

        Intent intent = new Intent(this, departmental_reviews.class);
        Intent intent2 = new Intent(this, AssignReview.class);
        //Intent ratings = getIntent();
        Bundle bundle2 = new Bundle();
        totalrating.setRating(DB.avgreview());

        /*if (ratings.hasExtra("review")) {
            Bundle bundle = ratings.getExtras();
            String commenthead = bundle.getString("commenthead");
            String commentext = bundle.getString("commenttext");
            if (commenthead.length() > 0)
            {
                heading.setText(commenthead);
                body.setText(commentext);
                totalrating.setRating(2.0f);
                userrating.setRating(review);
            }
            else
            {
                totalrating.setRating(2.0f);
            }
        }
         */

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle2.putString("title", heading.toString());
                bundle2.putString("comment", body.toString());
                bundle2.putFloat("review", totalrating.getRating());
                intent.putExtras(bundle2);
                startActivity(intent);
            }
        });
        createbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });
    }
}