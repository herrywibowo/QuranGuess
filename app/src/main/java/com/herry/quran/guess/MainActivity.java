package com.herry.quran.guess;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.herry.quran.guess.dao.DatabaseHelper;
import com.herry.quran.guess.dao.QuranDao;
import com.herry.quran.guess.dao.QuranFace;
import com.herry.quran.guess.data.ViewAyat;
import com.herry.quran.guess.data.ViewWord;
import com.herry.quran.guess.services.GuessFace;
import com.herry.quran.guess.services.GuessImpl;

import java.io.IOException;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper mDBHelper = null;
    private GuessFace guess = null;
    private QuranFace wordDao;
    private ViewWord viewWord;

    private Button ansA;
    private Button ansB;
    private TextView question;
    private TextView score;
    private Button close;

    private TextView ayat;
    private TextView arti;
    private Dialog dialog;

    private View.OnClickListener guessClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            guessClick(v);
        }
    };

    private View.OnClickListener dialogClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialog.hide();
        }
    };

    private View.OnClickListener closeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mDBHelper = new DatabaseHelper(this);
        this.dialog = new Dialog(this,android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.activity_ayat);
        try {
            mDBHelper.createDataBase();
            mDBHelper.openDataBase();
            wordDao = new QuranDao(mDBHelper.getWritableDatabase());
            guess = new GuessImpl(wordDao);
            ansA = findViewById(R.id.ansA);
            ansB = findViewById(R.id.ansB);
            question = findViewById(R.id.question);
            score = findViewById(R.id.score);
            close = findViewById(R.id.close);
            ayat = dialog.findViewById(R.id.ayat);
            arti = dialog.findViewById(R.id.arti);
            ayat.setOnClickListener(dialogClickListener);
            arti.setOnClickListener(dialogClickListener);
            ansA.setOnClickListener(guessClickListener);
            ansB.setOnClickListener(guessClickListener);
            close.setOnClickListener(closeClickListener);
            updateFronted(false);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void guessClick(View v){
        Button currentAns = (Button)v;
        String guessText = (String) currentAns.getText();
        boolean correction = viewWord.isCorrect(guessText);

        if(correction){
            v.setBackgroundColor(Color.GREEN);
            ViewAyat viewAyat = guess.rollingAyat();
            if(viewAyat !=null){
                displayAyat(viewAyat);
            }
        }else{
            flipColor(guessText);
        }
        next(2000, correction);
    }

    private void flipColor(String guessText){
        if(guessText.equals(ansA.getText().toString())){
            ansB.setBackgroundColor(Color.GREEN);
        }else{
            ansA.setBackgroundColor(Color.GREEN);
        }
    }

    private void updateFronted(boolean next){
        viewWord = guess.rollingWord(next);
        this.setTitle(viewWord.getSurah()+" ayat "+viewWord.getAyat());
        ansA.setText(viewWord.getArtiA());
        ansB.setText(viewWord.getArtiB());
        question.setText(viewWord.getKata());
        score.setText(viewWord.getScore()+"");
        ansA.setBackgroundColor(Color.BLUE);
        ansB.setBackgroundColor(Color.BLUE);
    }

    private void next(long time, final boolean next){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                updateFronted(next);
            }
        }, time);

    }

    private void displayAyat(ViewAyat viewAyat){
        dialog.setTitle(viewAyat.getSurah()+" ayat "+viewAyat.getAyat());
        ayat.setText(viewAyat.getIsiAyat());
        arti.setText(viewAyat.getArtiAyat());
        dialog.show();
    }
}
