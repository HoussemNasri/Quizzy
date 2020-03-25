package com.example.quizzy.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quizzy.R;
import com.example.quizzy.helpers.CategoryHelper;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String CATEGORY_KEY = "category_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void userChoosedCategory(View view) {
        String viewTag = view.getTag().toString();
        int viewId = view.getId();
        int categoryId = -1;
        if (!viewTag.isEmpty()) {
            categoryId = CategoryHelper.getCategoryId(viewTag);
        } else {
            categoryId = CategoryHelper.getRandomCategoryId();
        }

        startQuizActivity(categoryId);

    }

    public void startQuizActivity (int categoryId) {
        Intent quizActivity = new Intent(this, QuizActivity.class);
        quizActivity.putExtra(CATEGORY_KEY, categoryId);
        startActivity(quizActivity);
    }
}
