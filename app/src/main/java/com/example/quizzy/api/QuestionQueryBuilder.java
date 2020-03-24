package com.example.quizzy.api;

import com.example.quizzy.model.CategoryId;
import com.example.quizzy.model.Difficulty;
import com.example.quizzy.model.QuestionType;

import java.util.HashMap;
import java.util.Map;

public class QuestionQueryBuilder {
    private Map<String, String> queryMap;

    public QuestionQueryBuilder(Integer amount) {
        queryMap = new HashMap<>();
        queryMap.put("amount", String.valueOf(amount));
    }

    public QuestionQueryBuilder addCategory(CategoryId categoryId) {
        queryMap.put("category", String.valueOf(categoryId.getCategoryId()));

        return this;
    }

    public QuestionQueryBuilder addDifficulty(Difficulty difficulty) {
        queryMap.put("difficulty", difficulty.name().toLowerCase());
        return this;
    }

    public QuestionQueryBuilder addType(QuestionType type) {
        queryMap.put("type", type.name().toLowerCase());
        return this;
    }

    public Map<String, String> build() {
        return queryMap;
    }


    @Override
    public String toString() {
        return queryMap.toString();
    }
}
