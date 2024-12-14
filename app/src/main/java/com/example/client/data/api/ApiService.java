package com.example.client.data.api;

import com.example.client.data.model.Collection;
import com.example.client.data.model.Song;
import com.example.client.utills.ResponseData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiService {
    @GET("songs")
    Call<ResponseData<List<Song>>> getMusicData();

    @GET("collections")
    Call<ResponseData<List<Collection>>> getCollections();

    @GET("collections/{id}")
    Call<ResponseData<Collection>> getCollectionById(@Path("id") String id);

}
