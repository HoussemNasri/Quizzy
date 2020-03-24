package com.example.quizzy.api.remote;

import androidx.lifecycle.LiveData;

import com.example.quizzy.api.QuestionItemResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface QuizService {

    @GET
    Call<LiveData<QuestionItemResponse>> fetchQuestions(@QueryMap Map<String, String> params);

}
