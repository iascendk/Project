package com.ascendcorparation.project;// Название пакета

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity { // Объявление самого класса, который наследуется (extends) от абстрактного класса AppCompatActivity
    private ProgressBar progressBar; // Объявление переменных
    private MyProgressBar pb;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Приложение создаёт и отображает разметку активности

        super.onCreate(savedInstanceState); // Конструктор родительского класса, выполняющий необходимые операции для работы активности
        setContentView(R.layout.activity_main); // Подключение содержимого из файла разметки.

        Typeface tf1 = Typeface.createFromAsset(getAssets(), "FL.ttf"); // Создание и спользование шрифта для TextView из папки Assets
        TextView tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setTypeface(tf1);

        progressBar = (ProgressBar) findViewById(R.id.progressBar); // Создание индикатора прогресса
        pb = new MyProgressBar(this);
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) { // Установка максимального значения и обновления прогресса
                    progressStatus += 5;

                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            pb.setProgress(progressStatus);
                        }
                    });
                    try {
                        // Остановить на 300 миллисекунд, чтобы замедлить процесс
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    class MyProgressBar extends ProgressBar
    {
        public MyProgressBar(Context context) {
            super(context);
        }

        @Override
        public void setProgress(int progress) // Устанавливает заданное значение индикатора прогресса
        {
            super.setProgress(progress);
            if(progress == this.getMax()) // Если progressStatus = 100,то открывается второе активити
            {
                Intent intent = new Intent(MainActivity.this, Menu.class);
                startActivity(intent);
            }
        }
    }
    }
