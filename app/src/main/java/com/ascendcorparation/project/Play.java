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
    protected TextView question;
    protected Button shuffle;
    protected Random random;
    protected Question questionnaire;
    protected Button score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        mCount = (TextView) findViewById(R.id.mCount);
        init();
        if (Question.count(Question.class) != 35) { // Заполнение базы данных
            fillDB();
        }



        shuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Случайный вопрос из базы данных
                random = new Random();
                int x = random.nextInt(34) + 1;
                questionnaire = Question.findById(Question.class, x);
                String q = questionnaire.getQuestion();
                question.setText(q); // Вставить в TextView

            }
        });

        new CountDownTimer(30000, 1000) { // Обратный таймер на 30 секунд

            //Обновление текста счетчика с каждой секундой
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

    public void init() { // метод инициализации кнопок
        shuffle = (Button) findViewById(R.id.shuffle);
        question = (TextView) findViewById(R.id.question);
    }

    public void fillDB() { // Вытягивание вопросов из string массива
        for (int i = 0; i < 35; i++) {
            System.out.println(getResources().getStringArray(R.array.questions)[i]);
            questionnaire = new Question(getResources().getStringArray(R.array.questions)[i], i);
            Question.save(questionnaire);
        }
    }


    public void increaseInteger(View view) { // Увеличение значения
        minteger = minteger + 1;
        display(minteger);

    }

    public void decreaseInteger(View view) { // Уменьшение значения
        minteger = minteger - 1;
        display(minteger);
    }

    private void display(int number) {
        score.setText("" + number);
    }

}



