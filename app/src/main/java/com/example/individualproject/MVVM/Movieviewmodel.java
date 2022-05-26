package com.example.individualproject.MVVM;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.individualproject.Model.Moviemodel;
import com.example.individualproject.Model.homemodel;

import java.util.List;

public class Movieviewmodel extends ViewModel implements MovieRepositoryu.MovieList {

    MutableLiveData<List<Moviemodel>> mutableLiveData = new MutableLiveData<List<Moviemodel>>();
    MovieRepositoryu movieRepositoryu = new MovieRepositoryu(this);

    public Movieviewmodel(){
        movieRepositoryu.getMovie();
    }

    public LiveData<List<Moviemodel>> getHomeList(){
        return mutableLiveData;
    }

    @Override
    public void movieLists(List<Moviemodel> moviemodels) {

        mutableLiveData.setValue(moviemodels);

    }
}
