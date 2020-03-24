package com.example.quizzy.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.quizzy.R;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
