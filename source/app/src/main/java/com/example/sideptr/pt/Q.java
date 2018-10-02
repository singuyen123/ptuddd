package com.example.sideptr.pt;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Q extends AppCompatActivity {
    public static final long Strat_Time_In_Millis = 6000;

    private TextView mTextViewCountDownTimer;
    private TextView mTextViewQuestion;
    private Button mButtonViewAnswerA;
    private Button mButtonViewAnswerB;
    private Button mButtonViewAnswerC;
    private Button mButtonViewAnswerD;


    private CountDownTimer mCountDownTimer;
    private long mTimeLeftInMillis = Strat_Time_In_Millis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q);
        mTextViewCountDownTimer = findViewById(R.id.CountDown);
        mTextViewQuestion =  findViewById(R.id.Question);
        mButtonViewAnswerA = findViewById(R.id.answerA);
        mButtonViewAnswerB = findViewById(R.id.answerB);
        mButtonViewAnswerC = findViewById(R.id.answerC);
        mButtonViewAnswerD = findViewById(R.id.answerD);

        mButtonViewAnswerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonViewAnswerA.setBackgroundResource(R.mipmap.button2);
            }
        });
        mButtonViewAnswerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonViewAnswerB.setBackgroundResource(R.mipmap.button4);
            }
        });
        startTimer();
    }
    private void startTimer(){
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTextViewCountDownTimer.setText("00:00");
                Toast.makeText(getApplicationContext(),"time out", Toast.LENGTH_LONG).show();
            }
        }.start();
    }

    private void pauseTimer(){
        mCountDownTimer.cancel();
    }

    private void resetTimer(){
        mTimeLeftInMillis = Strat_Time_In_Millis;
        updateCountDownText();
    }

    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMillis/1000) /60;
        int seconds = (int) (mTimeLeftInMillis/1000) %60;
        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        mTextViewCountDownTimer.setText(timeLeftFormatted);
    }
}
