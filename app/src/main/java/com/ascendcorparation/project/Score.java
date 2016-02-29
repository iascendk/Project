package com.ascendcorparation.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    protected Button bt;
    TextView tv2, tv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        bt = (Button) findViewById(R.id.bt);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);

        int score = getIntent().getExtras().getInt("score", 13); // Получение данных из прошлой активности
        bt.setText(String.valueOf(score));

        switch (score) { // Вставка в TextView записей в зависимости от полученного балла
            case 1:
            case 2:
            case 3:
                tv3.setText(R.string.sc1);
                tv2.setText(R.string.l1);
                break;
            case 4:
            case 5:
                tv3.setText(R.string.sc2);
                tv2.setText(R.string.l1);
                break;
            case 6:
            case 7:
                tv3.setText(R.string.sc3);
                tv2.setText(R.string.l2);
                break;
            case 8:
            case 9:
                tv3.setText(R.string.sc4);
                tv2.setText(R.string.l2);
                break;
            case 10:
            case 11:
                tv3.setText(R.string.sc5);
                tv2.setText(R.string.l3);
                break;
            case 12:
            case 13:
                tv3.setText(R.string.sc6);
                tv2.setText(R.string.l3);
                break;
            case 14:
            case 15:
            case 16:
                tv3.setText(R.string.sc7);
                tv2.setText(R.string.l3);
                break;
            case 17:
            case 18:
                tv3.setText(R.string.sc8);
                tv2.setText(R.string.l4);
                break;
            case 19:
            case 20:
                tv3.setText(R.string.sc9);
                tv2.setText(R.string.l4);
                break;
            default:
                tv3.setText(R.string.sc10);
                tv2.setText(R.string.l5);

        }



        Button share = (Button) findViewById(R.id.share); // Поделиться сообщением
        share.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "What if?");
                    String sAux = "\nLet me recommend you this application\n\n";
                    sAux = sAux + "https://Play.google.com/store/apps/details?id=Orion.S.. \n\n";
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    startActivity(Intent.createChooser(i, "choose one"));
                } catch (Exception e) { //e.toString();
                }

            }
        });


        Button exit = (Button) findViewById(R.id.exit); // Выход из приложения
        exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });

    }

}
