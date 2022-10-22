package com.example.ratemypritch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class my_reviews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reviews);
        Button b1 = findViewById(R.id.button);
        Button b2 = findViewById(R.id.button2);
        ImageButton back_button = (ImageButton) findViewById(R.id.imagebutton);

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
                startActivity(intent2);
            }
        });

    }
}