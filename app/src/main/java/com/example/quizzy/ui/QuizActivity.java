package com.example.quizzy.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.quizzy.R;
import com.example.quizzy.helpers.CategoryHelper;

public class QuizActivity extends AppCompatActivity {

    private String currentCategoryName = "";
    private int currentCategoryId = -1;

    private TextView toolbarTitle;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        receiveingCategoryData();

        toolbarTitle = findViewById(R.id.quiz_toolbar_title);
        toolbarTitle.setText(currentCategoryName);
        settingUpToolbar();
    }

    public void receiveingCategoryData() {
        Intent intent = getIntent();
        currentCategoryId = intent.getIntExtra(MainActivity.CATEGORY_KEY, -1);
        currentCategoryName = CategoryHelper.getCategoryName(currentCategoryId);
    }


    public void settingUpToolbar() {
        toolbar = findViewById(R.id.quiz_toolbar);
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(e -> onBackPressed());

    }


}
