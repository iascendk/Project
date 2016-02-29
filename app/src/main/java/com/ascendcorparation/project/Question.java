package com.ascendcorparation.project;

import com.orm.SugarRecord;

public class Question extends SugarRecord{
    private String question;
    private int number;

    public Question() { // SugarOrm требует наличие такого конструктор
    }

    public String getQuestion() {
        return question;
    } // Возврат данных

    public Question(String question, int number) { // Создание таблицы
        this.question = question;
        this.number = number;
    }

}