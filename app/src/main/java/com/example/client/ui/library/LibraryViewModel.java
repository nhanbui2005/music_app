package com.example.client.ui.library;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class LibraryViewModel extends ViewModel {

    private final MutableLiveData<List<String>> libraryItems = new MutableLiveData<>();

    public LibraryViewModel() {
        // Khởi tạo dữ liệu ban đầu
        List<String> initialItems = new ArrayList<>();
        initialItems.add("Playlist yêu thích");
        initialItems.add("Album gần đây");
        initialItems.add("Nghệ sĩ theo dõi");
        libraryItems.setValue(initialItems);
    }

    /**
     * Trả về LiveData cho danh sách thư viện
     */
    public LiveData<List<String>> getLibraryItems() {
        return libraryItems;
    }

    /**
     * Hàm thêm nghệ sĩ mới vào danh sách
     */
    public void addArtist(String artistName) {
        List<String> currentItems = new ArrayList<>(libraryItems.getValue());
        currentItems.add(artistName);
        libraryItems.setValue(currentItems);
    }
}
