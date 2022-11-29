package com.example.ratemypritch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;

import im.dacer.androidcharts.BarView;

public class graph extends AppCompatActivity {

    BarView barView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        barView = (BarView)findViewById(R.id.bar_view);
        button = (Button)findViewById(R.id.bar_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                randomSet(barView);
            }
        });

    }
}