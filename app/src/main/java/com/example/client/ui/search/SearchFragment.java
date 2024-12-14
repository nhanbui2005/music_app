package com.example.client.ui.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.client.data.adapter.SearchAdapter;
import com.example.client.databinding.FragmentSearchBinding;


import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;
    private SearchViewModel searchViewModel;
    private SearchAdapter searchAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Khởi tạo ViewModel
        searchViewModel = new ViewModelProvider(this).get(SearchViewModel.class);

        // Thiết lập RecyclerView
        setupRecyclerView();

        // Quan sát dữ liệu từ ViewModel
        searchViewModel.getSearchResults().observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> results) {
                // Cập nhật dữ liệu cho RecyclerView
                searchAdapter.updateData(results);
            }
        });

        // Thiết lập sự kiện tìm kiếm
        binding.searchButton.setOnClickListener(v -> performSearch());
    }

    private void setupRecyclerView() {
        binding.recyclerViewSearch.setLayoutManager(new LinearLayoutManager(getContext()));
        searchAdapter = new SearchAdapter(new ArrayList<>());
        binding.recyclerViewSearch.setAdapter(searchAdapter);
    }

    private void performSearch() {
        String query = binding.searchInput.getText().toString();

        if (TextUtils.isEmpty(query)) {
            Toast.makeText(getContext(), "Vui lòng nhập từ khóa tìm kiếm", Toast.LENGTH_SHORT).show();
        } else {
            // Gọi ViewModel để tìm kiếm
            searchViewModel.search(query);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
