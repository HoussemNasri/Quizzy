package com.example.quizzy.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.quizzy.R;
import com.example.quizzy.helpers.CategoryHelper;

public class QuizActivity extends AppCompatActivity {

    private String currentCategoryName = "";
    private int currentCategoryId = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        receivceCategoryData();

    }

    public void receivceCategoryData () {
        Intent intent = getIntent();
        currentCategoryId = intent.getIntExtra(MainActivity.CATEGORY_KEY, -1);
        currentCategoryName = CategoryHelper.getCategoryName(currentCategoryId);
    }


}
