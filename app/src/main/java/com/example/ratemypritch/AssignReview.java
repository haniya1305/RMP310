package com.example.ratemypritch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;
import android.util.Log;
public class AssignReview extends AppCompatActivity {

    DB_Helper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_review);
        EditText commentstext = (EditText) findViewById(R.id.comments);
        EditText commenthead = (EditText) findViewById(R.id.comments2);
        RatingBar assignedrating = (RatingBar) findViewById(R.id.ratingBar);
        ImageButton backbutton = (ImageButton) findViewById(R.id.imageButton6);
        ImageButton assignreview = (ImageButton) findViewById(R.id.imageButton);
        DB = new DB_Helper(this);

        Intent intent = new Intent(this, CurrentReviews.class);
        backbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        Intent intent2 = new Intent(this, CurrentReviews.class);
        Bundle bundle = new Bundle();
        assignreview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(assignedrating.getRating() == 0)
                {
                    Toast.makeText(getApplicationContext(), "No Rating Inputted", Toast.LENGTH_SHORT).show();
                }
                else if ((commenthead.getText().toString().length() == 0 && !(commentstext.getText().toString().length() == 0) )|| (!(commenthead.getText().toString().length() == 0) && commentstext.getText().toString().length() == 0))
                {
                    Toast.makeText(getApplicationContext(), "Comment Inputted Incorrectly", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    bundle.putString("commenthead", commenthead.getText().toString());
                    bundle.putString("commenttext", commentstext.getText().toString());
                    bundle.putFloat("review", assignedrating.getRating());
                    if(commenthead.getText().toString().length() > 0)
                    {
                        DB.insertReview(DB.reviewidassign(), commenthead.getText().toString(), commentstext.getText().toString());
                    }
                    DB.insertRatings(DB.reviewidassign(), assignedrating.getRating());
                    intent2.putExtras(bundle);
                    startActivity(intent2);
                }


            }
        });





    }
}