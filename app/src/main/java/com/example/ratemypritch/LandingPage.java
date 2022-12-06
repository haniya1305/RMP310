package com.example.ratemypritch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class LandingPage extends AppCompatActivity {

//    DB_Helper DB;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button loglog, signUp, signUpLater;
        String uname, pass;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        tv = (TextView) findViewById(R.id.textView16);

        try {
            weather();
        } catch (IOException e) {
            e.printStackTrace();
        }

        EditText email_signin = (EditText) findViewById(R.id.email);
        EditText password_signin = (EditText) findViewById(R.id.pass);

        loglog = (Button) findViewById(R.id.button6);
        signUp = (Button) findViewById(R.id.button7);
        signUpLater = (Button) findViewById(R.id.button8);
//        DB = new DB_Helper(this);
        EditText username = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.pass);


        Intent intentGoMain = new Intent(this, MainView.class);
        loglog.setOnClickListener(new View.OnClickListener() {
            Boolean loggedin = false;

            @Override
            public void onClick(View view) {
//                loggedin = true;
//                startActivity(intentGoMain);

                String user = email_signin.getText().toString();
                String pass = password_signin.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(LandingPage.this, "Enter all the fields.", Toast.LENGTH_SHORT).show();
                else {
//                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
//                    if (checkuserpass == true) {
                        Toast.makeText(LandingPage.this, "Sign in successful!", Toast.LENGTH_SHORT).show();
                        startActivity(intentGoMain);
//                    } else {
//                        Toast.makeText(LandingPage.this, "Invalid Account.", Toast.LENGTH_SHORT).show();
//                    }
                }
            }
        });

        Intent intentSignUp = new Intent(this, sign_up_page.class);
        signUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(intentSignUp);
            }
        });



        Intent intentUnsigned = new Intent(this, MainView.class);
        signUpLater.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(intentUnsigned);
            }
        });
    }

    void weather() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://us-weather-by-zip-code.p.rapidapi.com/getweatherzipcode?zip=94111")
                .get()
                .addHeader("X-RapidAPI-Key", "b9dda96a07mshb89e7d029803e5dp1d7b7ejsnb0fa37653bc4")
                .addHeader("X-RapidAPI-Host", "us-weather-by-zip-code.p.rapidapi.com")
                .build();
//        Response response = client.newCall(request).execute();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String myResponse = response.body().string();
                LandingPage.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] a = myResponse.split(":");
                        tv.setText("Temperature today is "+a[7].substring(1,a[7].length()-2));  //no need of quotations
//                        City:"San Francisco"  State:"CA"
//                        TempF:"72.0"  TempC:"22.2" [7]
//                        Weather:"A Few Clouds"    WindMPH:"17.3"
//                        WindDir:"West"    RelativeHumidity:"57"
//                        VisibilityMiles:"10.00"   Code:"Success"
//                        Credits:"499999977"
                    }
                });
            }
        });
    }

}