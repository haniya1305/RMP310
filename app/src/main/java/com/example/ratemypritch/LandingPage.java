package com.example.ratemypritch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LandingPage extends AppCompatActivity {

    DB_Helper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button loglog, signingUp, signUpLater;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        EditText email_signin = (EditText) findViewById(R.id.email);
        EditText password_signin = (EditText) findViewById(R.id.pass);

        loglog = (Button) findViewById(R.id.button6);
        signingUp = (Button) findViewById(R.id.button7);
        signUpLater = (Button) findViewById(R.id.button8);
        DB = new DB_Helper(this);


        Intent intentGoMain = new Intent(this, MainView.class);
        loglog.setOnClickListener(new View.OnClickListener() {
            Boolean loggedin = false;

            @Override
            public void onClick(View view) {
//                loggedin = true;
//                startActivity(intentGoMain);

                String user = email_signin.getText().toString();
                String pass = password_signin.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LandingPage.this, "Enter all the fields.", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass == true) {
                        Toast.makeText(LandingPage.this, "Sign in successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainView.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LandingPage.this, "Invalid Account.", Toast.LENGTH_SHORT).show();
                    }
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