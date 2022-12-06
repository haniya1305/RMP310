package com.example.ratemypritch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AssignReview extends AppCompatActivity {

//    DB_Helper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_review);
        EditText commentstext = (EditText) findViewById(R.id.comments);
        EditText commenthead = (EditText) findViewById(R.id.comments2);
        RatingBar assignedrating = (RatingBar) findViewById(R.id.ratingBar);
        ImageButton backbutton = (ImageButton) findViewById(R.id.imageButton6);
        ImageButton assignreview = (ImageButton) findViewById(R.id.imageButton);
//        DB = new DB_Helper(this);


        Intent intent = new Intent(this, CurrentReviews.class);
        backbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
//                startActivity(intent);
            }
        });
        Intent intent2 = new Intent(this, CurrentReviews.class);
        Bundle bundle = new Bundle();
        assignreview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                try {
                    spellchecker();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if(assignedrating.getRating() == 0)
                {
                    Toast.makeText(getApplicationContext(), "No Rating Inputted", Toast.LENGTH_SHORT).show();
                }
                else if ((commenthead.getText().toString().length() == 0 && !(commentstext.getText().toString().length() == 0) )|| (!(commenthead.getText().toString().length() == 0) && commentstext.getText().toString().length() == 0))
                {
                    Toast.makeText(getApplicationContext(), "Comment Inputted Incorrectly", Toast.LENGTH_SHORT).show();
                }
//                else
//                {
//                    if(commenthead.getText().toString().length() > 0)
//                    {
//                        DB.insertReview(DB.reviewidassign(), commenthead.getText().toString(), commentstext.getText().toString(), DB.ratingidassign());
//                    }
//                    DB.insertRatings(DB.ratingidassign(), assignedrating.getRating());
//                    startActivity(intent2);
//                }

            }
        });
    }

    void spellchecker() throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://jspell-checker.p.rapidapi.com/check")
                .get()
                .addHeader("X-RapidAPI-Key", "b9dda96a07mshb89e7d029803e5dp1d7b7ejsnb0fa37653bc4")
                .addHeader("X-RapidAPI-Host", "jspell-checker.p.rapidapi.com")
                .build();


        Response response = client.newCall(request).execute();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String myResponse = response.body().string();

                AssignReview.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] s = myResponse.split(":");
                        Toast.makeText(getApplicationContext(), "There exists " + s[1] +" grammatical errors!", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
    }

}

}