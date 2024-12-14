package com.example.client.ui.home;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.client.data.model.Collection;
import com.example.client.data.model.Song;
import com.example.client.data.responestory.HomeRepository;

import java.util.Collections;
import java.util.List;

public class HomeViewModel extends ViewModel {
    private final HomeRepository repository;
    private final MutableLiveData<List<Song>> songList;
    private final MutableLiveData<List<Collection>> collectionList;
    private final MutableLiveData<Song> miniMusic = new MutableLiveData<>();

    public HomeViewModel(HomeRepository homeRepository) {
        this.repository = homeRepository;
        collectionList = new MutableLiveData<>();
        songList = new MutableLiveData<>();
    }
    public void setMiniMusic(Song song) {

        miniMusic.setValue(song);
    }

    public LiveData<Song> getMiniMusic() {
        return miniMusic;
    }

    public LiveData<List<Song>> getSongData() {
        repository.fetchSongs(new HomeRepository.DataCallback<List<Song>>() {
            @Override
            public void onSuccess(List<Song> data) {
                songList.setValue(data);
            }
            @Override
            public void onFailure(Throwable throwable) {
                songList.setValue(null);
            }
        });
        return songList;
    }
    public LiveData<List<Collection>> getCollections() {
        repository.fetchCollections(new HomeRepository.DataCallback<List<Collection>>() {
            @Override
            public void onSuccess(List<Collection> data) {
                collectionList.setValue(data);
            }
            @Override
            public void onFailure(Throwable throwable) {
                songList.setValue(null);
            }
        });
        return collectionList;
    }

}
