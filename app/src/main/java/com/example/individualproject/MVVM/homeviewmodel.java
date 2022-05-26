package com.example.individualproject.MVVM;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.individualproject.Model.homemodel;

import java.util.List;

public class homeviewmodel extends ViewModel implements homeRepositoryu.HomeList {

    MutableLiveData<List<homemodel>> mutableLiveData = new MutableLiveData<List<homemodel>>();
    homeRepositoryu homeRepositoryu = new homeRepositoryu(this);


    public homeviewmodel(){
        homeRepositoryu.getMovie();
    }

    public LiveData<List<homemodel>> getHomeList(){
        return mutableLiveData;
    }

    @Override
    public void homeLists(List<homemodel> Homemodel) {
        mutableLiveData.setValue(Homemodel);
    }
}
