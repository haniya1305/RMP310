package com.example.ratemypritch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LandingPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button loglog, signingUp, signUpLater;
        String uname, pass;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        loglog = (Button) findViewById(R.id.button6);
        signingUp = (Button) findViewById(R.id.button7);
        signUpLater = (Button) findViewById(R.id.button8);
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);




        Intent intentGoMain = new Intent(this, MainView.class);
        loglog.setOnClickListener(new View.OnClickListener() {
            Boolean loggedin = false;

            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("test@student.ubc.ca") && password.getText().toString().equals("123")){
                    loggedin = true;
                    startActivity(intentGoMain);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect Info", Toast.LENGTH_SHORT).show();
                }

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