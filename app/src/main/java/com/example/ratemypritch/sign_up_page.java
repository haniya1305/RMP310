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

    DB_Helper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button sign_up, sign_up_later;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        EditText email_signup = (EditText) findViewById(R.id.email);
        EditText password_signup = (EditText) findViewById(R.id.password);
        EditText repassword_signup = (EditText) findViewById(R.id.repassword);
        ImageButton back_button = (ImageButton) findViewById(R.id.imageButton7);
        sign_up = findViewById(R.id.button);
        sign_up_later = findViewById(R.id.button2);
        DB = new DB_Helper(this);

        Intent intent = new Intent(this, LandingPage.class);
        back_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        Intent intent3 = new Intent(this, MainView.class);
        sign_up_later.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(intent3);
            }
        });

//        Intent intent2 = new Intent(this, LandingPage.class);
        sign_up.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                if (email_signup.getText().toString().length() != 0 && password_signup.getText().toString().length() != 0){
//                    startActivity(intent2);
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "No values for signup", Toast.LENGTH_SHORT).show();
//                }

                String user = email_signup.getText().toString();
                String pass = password_signup.getText().toString();
                String repass = repassword_signup.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(sign_up_page.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(sign_up_page.this, "User Registered successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LandingPage.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(sign_up_page.this, "Sign-up failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(sign_up_page.this, "User already exists! Please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(sign_up_page.this, "Passwords does not match!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });




    }


}