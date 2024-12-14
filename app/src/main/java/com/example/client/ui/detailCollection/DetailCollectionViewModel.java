package com.example.client.ui.detailCollection;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.client.data.model.Collection;
import com.example.client.data.responestory.HomeRepository;

import java.util.List;

public class DetailCollectionViewModel extends ViewModel {
    private final HomeRepository repository;
    private final MutableLiveData<Collection> collection;

    public DetailCollectionViewModel(HomeRepository homeRepository) {
        this.repository = homeRepository;
        this.collection =  new MutableLiveData<>();;
    }

    public LiveData<Collection> getCollectionById(String id) {
        repository.fetchCollectionById(id, new HomeRepository.DataCallback<Collection>() {
            @Override
            public void onSuccess(Collection data) {
                collection.postValue(data);
            }
            @Override
            public void onFailure(Throwable throwable) {
                Log.d(">>>>>>", "onFailure: "+throwable);
            }
        });
        return collection;
    }

}
