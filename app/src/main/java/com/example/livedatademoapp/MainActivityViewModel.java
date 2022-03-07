package com.example.livedatademoapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private String TAG = MainActivityViewModel.class.getSimpleName();
    MutableLiveData<String> currentName;

    public MutableLiveData<String> getCurrentName() {
        if (currentName == null) {
            currentName = new MutableLiveData<>();
        }
        return currentName;
    }
}
