package com.example.client.data.responestory;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.client.data.api.ApiService;
import com.example.client.data.api.RetrofitInstant;
import com.example.client.data.model.Collection;
import com.example.client.data.model.Song;
import com.example.client.utills.ResponseData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository {
    private final ApiService apiService;

    public HomeRepository() {
        apiService = RetrofitInstant.api();
    }

    public void fetchSongs(final DataCallback<List<Song>> callback) {
        apiService.getMusicData().enqueue(new Callback<ResponseData<List<Song>>>() {
            @Override
            public void onResponse(@NonNull Call<ResponseData<List<Song>>> call, @NonNull Response<ResponseData<List<Song>>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Song> songs = response.body().getData();
                    callback.onSuccess(songs);
                } else {
                    callback.onFailure(new Exception("Lỗi khi lấy dữ liệu bài hát"));
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseData<List<Song>>> call, @NonNull Throwable throwable) {
                Log.e("HomeRepository", "Lỗi khi lấy dữ liệu bài hát: " + throwable.getMessage());
                callback.onFailure(throwable);
            }
        });
    }

    public void fetchCollections(final DataCallback<List<Collection>> callback) {
        apiService.getCollections().enqueue(new Callback<ResponseData<List<Collection>>>() {
            @Override
            public void onResponse(@NonNull Call<ResponseData<List<Collection>>> call, @NonNull Response<ResponseData<List<Collection>>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Collection> collections = response.body().getData();
                    callback.onSuccess(collections);
                } else {
                    callback.onFailure(new Exception("Lỗi khi lấy dữ liệu bộ sưu tập"));
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseData<List<Collection>>> call, @NonNull Throwable throwable) {
                callback.onFailure(throwable);
            }
        });
    }
    public void fetchCollectionById(String id, final DataCallback<Collection> callback) {
        apiService.getCollectionById(id).enqueue(new Callback<ResponseData<Collection>>() {
            @Override
            public void onResponse(@NonNull Call<ResponseData<Collection>> call, @NonNull Response<ResponseData<Collection>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Collection collection = response.body().getData();
                    callback.onSuccess(collection);
                } else {
                    Log.d(">>>>>>", ":collectionId:  "+"333333");

                    callback.onFailure(new Exception("Lỗi khi lấy dữ liệu bộ sưu tập với ID: " + id));
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseData<Collection>> call, @NonNull Throwable throwable) {
                Log.d(">>>>>>", ":collectionId:  "+throwable);

                callback.onFailure(throwable);
            }
        });
    }

    // Giao diện callback để xử lý kết quả
    public interface DataCallback<T> {
        void onSuccess(T data);
        void onFailure(Throwable throwable);
    }
}
