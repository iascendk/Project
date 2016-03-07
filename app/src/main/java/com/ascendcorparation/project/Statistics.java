package com.ascendcorparation.project;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Statistics extends AppCompatActivity {
    SharedPreferences pref;
    TextView tv;
    int hscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        tv = (TextView) findViewById(R.id.tv);
        pref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        tv.setText("The highest score " + hscore);
    }
}
