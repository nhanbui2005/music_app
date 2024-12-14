package com.example.client.config;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.client.data.responestory.HomeRepository;
import com.example.client.ui.detailCollection.DetailCollectionViewModel;
import com.example.client.ui.home.HomeViewModel;

public class AppViewModelFactory implements ViewModelProvider.Factory {
    private final HomeRepository homeRepository;

    public AppViewModelFactory() {
        this.homeRepository = new HomeRepository();
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) new HomeViewModel(homeRepository);
        }else if (modelClass.isAssignableFrom(DetailCollectionViewModel.class)) {
            return (T) new DetailCollectionViewModel(homeRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}


