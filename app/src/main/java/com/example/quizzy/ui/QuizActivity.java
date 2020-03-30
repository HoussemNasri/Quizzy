package com.example.quizzy.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.quizzy.R;
import com.example.quizzy.helpers.CategoryHelper;
import com.example.quizzy.ui.callback.CountDownTimerCallback;

public class QuizActivity extends AppCompatActivity implements CountDownTimerCallback {

    private String currentCategoryName = "";
    private int currentCategoryId = -1;
    private TextView toolbarTitle;
    private Toolbar toolbar;

    private QuestionTimerView timerView;

    public static final String TAG = QuizActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        receiveingCategoryData();
        settingUpToolbar();

        timerView = new QuestionTimerView(10, this, this);
        timerView.start();

    }

    public void receiveingCategoryData() {
        Intent intent = getIntent();
        currentCategoryId = intent.getIntExtra(MainActivity.CATEGORY_KEY, -1);
        currentCategoryName = CategoryHelper.getCategoryName(currentCategoryId);
    }


    public void settingUpToolbar() {
        toolbarTitle = findViewById(R.id.quiz_toolbar_title);
        toolbarTitle.setText(currentCategoryName);
        toolbar = findViewById(R.id.quiz_toolbar);
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(e -> onBackPressed());
    }


    @Override
    public void onTimerStart() {
        Toast.makeText(this, "Timer Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTimerEnd() {
        Toast.makeText(this, "Timer Ended", Toast.LENGTH_SHORT).show();
    }
}
