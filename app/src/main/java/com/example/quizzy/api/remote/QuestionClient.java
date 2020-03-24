package com.example.quizzy.api.remote;

import androidx.lifecycle.LiveData;

import com.example.quizzy.api.QuestionItemResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;

public class QuestionClient {

    private static final String BASE_URL = "";
    private Retrofit mRetrofit;

    public QuestionClient() {
        mRetrofit = RetrofitClient.getRetrofitClient(BASE_URL);
    }

    public Call<LiveData<QuestionItemResponse>> loadQuestions(int amount, Map<String, String> queries) {

        return null;
    }
}
