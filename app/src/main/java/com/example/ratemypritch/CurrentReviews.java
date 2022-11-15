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

        TextView heading1 = (TextView) findViewById(R.id.textView3);
        TextView body1 = (TextView) findViewById(R.id.textView5);

        TextView heading2 = (TextView) findViewById(R.id.textView8);
        TextView body2 = (TextView) findViewById(R.id.textView7);

        TextView heading3 = (TextView) findViewById(R.id.textView10);
        TextView body3 = (TextView) findViewById(R.id.textView9);

        RatingBar totalrating = (RatingBar) findViewById(R.id.ratingBar2);

        RatingBar userrating1 = (RatingBar) findViewById(R.id.ratingBar4);
        RatingBar userrating2 = (RatingBar) findViewById(R.id.ratingBar5);
        RatingBar userrating3 = (RatingBar) findViewById(R.id.ratingBar8);

        Intent intent = new Intent(this, departmental_reviews.class);
        Intent intent2 = new Intent(this, AssignReview.class);
        //Intent ratings = getIntent();
        Bundle bundle2 = new Bundle();
        totalrating.setRating(DB.avgreview());

        if(DB.reviewidassign() > 2)
        {

            heading1.setText(DB.getReviewtop(DB.reviewidassign() - 1));
            body1.setText(DB.getReviewbot(DB.reviewidassign() - 1));
            userrating1.setRating(DB.getRating(DB.getRatingidatreview(DB.reviewidassign() - 1)));

            heading2.setText(DB.getReviewtop(DB.reviewidassign() - 2));
            body2.setText(DB.getReviewbot(DB.reviewidassign() - 2));
            userrating2.setRating(DB.getRating(DB.getRatingidatreview(DB.reviewidassign() - 2)));

            heading3.setText(DB.getReviewtop(DB.reviewidassign() - 3));
            body3.setText(DB.getReviewbot(DB.reviewidassign() - 3));
            userrating3.setRating(DB.getRating(DB.getRatingidatreview(DB.reviewidassign() - 3)));
        }
        else if (DB.reviewidassign() == 2)
        {

            heading1.setText(DB.getReviewtop(DB.reviewidassign() - 1));
            body1.setText(DB.getReviewbot(DB.reviewidassign() - 1));
            userrating1.setRating(DB.getRating(DB.getRatingidatreview(DB.reviewidassign() - 1)));

            heading2.setText(DB.getReviewtop(DB.reviewidassign() - 2));
            body2.setText(DB.getReviewbot(DB.reviewidassign() - 2));
            userrating2.setRating(DB.getRating(DB.getRatingidatreview(DB.reviewidassign() - 2)));
        }
        else if (DB.reviewidassign() == 1)
        {
            heading1.setText(DB.getReviewtop(DB.reviewidassign() - 1));
            body1.setText(DB.getReviewbot(DB.reviewidassign() - 1));
            userrating1.setRating(DB.getRating(DB.getRatingidatreview(DB.reviewidassign() - 1)));
        }



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