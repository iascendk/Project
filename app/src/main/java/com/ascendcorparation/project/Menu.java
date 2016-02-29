package com.ascendcorparation.project;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    protected Button bt1, bt2, bt3; // Используемые переменные
    protected Typeface tf1;
    protected Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);

        bt1.setOnClickListener(this); // Устанавливаем обработчик нажатия кнопки
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);

        tf1 = Typeface.createFromAsset(getAssets(), "FL.ttf");
        bt1.setTypeface(tf1);
        bt2.setTypeface(tf1);
        bt3.setTypeface(tf1);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.bt1: // Если нажата кнопка b1, переход на активити инструкции
                intent = new Intent(Menu.this, Instruction.class);
                startActivity(intent);
                break;
            case R.id.bt2: // Если нажата кнопка b2, переход на активити статистики
                intent = new Intent(Menu.this, Statistics.class);
                startActivity(intent);
                break;
            case R.id.bt3: // // Если нажата кнопка b3, переход на активити игры
                intent = new Intent(Menu.this, Play.class);
                startActivity(intent);
                break;
        }
    }
}
