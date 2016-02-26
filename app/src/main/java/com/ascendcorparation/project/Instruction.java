package com.ascendcorparation.project;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


    public class Instruction extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_instruction);
            Typeface tf1 = Typeface.createFromAsset(getAssets(), "FL.ttf");
            TextView tv1 = (TextView) findViewById(R.id.tv1);
            tv1.setTypeface(tf1);
            TextView tv2 = (TextView) findViewById(R.id.tv2);
            tv2.setTypeface(tf1);
            TextView tv3 = (TextView) findViewById(R.id.tv3);
            tv3.setTypeface(tf1);
            TextView tv4 = (TextView) findViewById(R.id.tv4);
            tv4.setTypeface(tf1);
            TextView tv5 = (TextView) findViewById(R.id.tv5);
            tv5.setTypeface(tf1);

        }
    }
