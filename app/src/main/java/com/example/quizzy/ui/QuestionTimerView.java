package com.example.quizzy.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.example.quizzy.R;
import com.example.quizzy.ui.callback.CountDownTimerCallback;
import com.timqi.sectorprogressview.ColorfulRingProgressView;

public class QuestionTimerView implements Runnable{

    private static final String TAG = "QuestionTimerView";
    private int seconds;
    private CountDownTimerCallback mTimerCallback;
    private ColorfulRingProgressView mTimer;
    private TextView tvPercent;

    private Handler mHandler;

    public QuestionTimerView (int seconds, CountDownTimerCallback timerCallback, Activity context) {
        this.seconds = seconds;
        this.mTimerCallback = timerCallback;
        mTimer = context.findViewById(R.id.spv);
        tvPercent = context.findViewById(R.id.tvPercent);

        mHandler = new Handler();
    }

    public void reset () {
        mTimer.setPercent(100.0f);
        tvPercent.setText(String.valueOf(seconds));
    }

    @SuppressLint("SetTextI18n")
    public void start () {
        mTimerCallback.onTimerStart();
        reset();
        Thread t = new Thread(this);
        t.start();
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void run() {
        while (mTimer.getPercent() > 0.0f) {
            Log.d(TAG, "run: " + mTimer.getPercent());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//              Update the value background thread to UI thread
            mHandler.post(() -> {
                float newValue = mTimer.getPercent() - 5.0f / seconds;
                mTimer.setPercent(newValue);
                float newCurrentSeconds = seconds * newValue / 100.0f;
                tvPercent.setText("" + (int) newCurrentSeconds);
            });
        }
        mHandler.post(()->mTimerCallback.onTimerEnd());
    }
}
