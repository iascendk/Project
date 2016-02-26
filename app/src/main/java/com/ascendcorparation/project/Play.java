package com.ascendcorparation.project;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Play extends AppCompatActivity {
    int minteger;
    protected TextView mCount;
    int score;
    protected TextView question;
    protected Button shuffle;
    protected Random random;
    protected Question questionnaire;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        mCount = (TextView) findViewById(R.id.mCount);
        init();
        if (Question.count(Question.class) != 35) {
            fillDB();
        }



        shuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                random = new Random();
                int x = random.nextInt(34) + 1;
                questionnaire = Question.findById(Question.class, x);
                String q = questionnaire.getQuestion();
                question.setText(q);

            }
        });

        new CountDownTimer(30000, 1000) {

            //Здесь обновляем текст счетчика обратного отсчета с каждой секундой
            public void onTick(long millisUntilFinished) {
                mCount.setText(
                        String.valueOf((int) (+millisUntilFinished / 1000)));
            }

            //Задаем действия после завершения отсчета:
            public void onFinish() {
                Intent intent = new Intent(Play.this, Score.class);
                intent.putExtra("score", 13);
                startActivity(intent);
            }
        }
                .start();
    }

    public void init() {
        shuffle = (Button) findViewById(R.id.shuffle);
        question = (TextView) findViewById(R.id.question);
    }

    public void fillDB() {
        for (int i = 0; i < 35; i++) {
            System.out.println(getResources().getStringArray(R.array.questions)[i]);
            questionnaire = new Question(getResources().getStringArray(R.array.questions)[i], i);
            Question.save(questionnaire);
        }

    }


    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }

    public void decreaseInteger(View view) {
        minteger = minteger - 1;
        display(minteger);
    }

    private void display(int number) {
        TextView score = (TextView) findViewById(
                R.id.score);
        score.setText("" + number);
    }

}



