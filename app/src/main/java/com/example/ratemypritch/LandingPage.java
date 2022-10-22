package com.example.ratemypritch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button loglog, signingUp, signUpLater;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        loglog = (Button) findViewById(R.id.button6);
        signingUp = (Button) findViewById(R.id.button7);
        signUpLater = (Button) findViewById(R.id.button8);



        Intent intentGoMain = new Intent(this, MainView.class);
        loglog.setOnClickListener(new View.OnClickListener() {
            Boolean loggedin = false;

            @Override
            public void onClick(View view) {
                loggedin = true;
                startActivity(intentGoMain);
            }
        });

        Intent intentSignUp = new Intent(this, sign_up_page.class);
        signingUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(intentSignUp);
            }
        });

        Intent intentUnsigned = new Intent(this, MainView.class);
        signUpLater.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(intentUnsigned);
            }
        });
    }
}