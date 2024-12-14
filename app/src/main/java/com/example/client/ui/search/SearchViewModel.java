package com.example.client.ui.search;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class SearchViewModel extends ViewModel {

    // Dữ liệu cho kết quả tìm kiếm
    private final MutableLiveData<List<String>> searchResults = new MutableLiveData<>();

    public SearchViewModel() {
        // Khởi tạo danh sách rỗng ban đầu
        searchResults.setValue(new ArrayList<>());
    }

    /**
     * Trả về LiveData cho danh sách kết quả tìm kiếm.
     */
    public LiveData<List<String>> getSearchResults() {
        return searchResults;
    }

    /**
     * Hàm thực hiện tìm kiếm dựa trên từ khóa.
     * @param query Từ khóa tìm kiếm.
     */
    public void search(String query) {
        List<String> results = new ArrayList<>();

        if (query == null || query.isEmpty()) {
            results.add("Vui lòng nhập từ khóa.");
        } else {
            // Ví dụ: Thêm kết quả giả lập
            results.add("Kết quả cho: " + query);
            results.add("Bài hát 1 liên quan đến " + query);
            results.add("Bài hát 2 liên quan đến " + query);
            results.add("Nghệ sĩ liên quan đến " + query);
        }

        // Cập nhật LiveData
        searchResults.setValue(results);
    }
}
