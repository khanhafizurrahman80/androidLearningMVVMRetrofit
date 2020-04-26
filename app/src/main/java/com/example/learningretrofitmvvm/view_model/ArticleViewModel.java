package com.example.learningretrofitmvvm.view_model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.learningretrofitmvvm.repository.ArticleRepository;
import com.example.learningretrofitmvvm.response.ArticleResponse;

public class ArticleViewModel extends ViewModel {

    private ArticleRepository articleRepository;
    private LiveData<ArticleResponse> articleResponseLiveData;

    public void init(){
        if (articleResponseLiveData != null){
            return;
        }
        articleRepository = articleRepository.getInstance();
        articleResponseLiveData = articleRepository.getMovieArticles("movies", "84a7decf3110498ea372bd16dd0601e8");
        Log.d("here is the response data", String.valueOf(articleResponseLiveData));
    }

    public LiveData<ArticleResponse> getArticleResponseLiveData() {
        return articleResponseLiveData;
    }
}
