package com.example.ratemypritch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class sign_up_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button b1, b2;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        EditText email_signup = (EditText) findViewById(R.id.email);
        EditText password_signup = (EditText) findViewById(R.id.password);
        ImageButton back_button = (ImageButton) findViewById(R.id.imageButton7);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);

        Intent intent = new Intent(this, LandingPage.class);
        back_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        Intent intent3 = new Intent(this, MainView.class);
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(intent3);
            }
        });

        Intent intent2 = new Intent(this, LandingPage.class);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (email_signup.getText().toString().length() != 0 && password_signup.getText().toString().length() != 0){
                    startActivity(intent2);
                }
                else{
                    Toast.makeText(getApplicationContext(), "No values for signup", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }


}