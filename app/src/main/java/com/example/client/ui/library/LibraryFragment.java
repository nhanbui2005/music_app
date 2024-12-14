package com.example.client.ui.library;

import android.os.Bundle;
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

import com.example.client.data.adapter.LibraryAdapter;
import com.example.client.databinding.FragmentLibraryBinding;


import java.util.List;

public class LibraryFragment extends Fragment {

    private FragmentLibraryBinding binding;
    private LibraryViewModel libraryViewModel;
    private LibraryAdapter libraryAdapter;

    public LibraryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLibraryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Khởi tạo ViewModel
        libraryViewModel = new ViewModelProvider(this).get(LibraryViewModel.class);

        // Thiết lập RecyclerView
        setupRecyclerView();

        // Quan sát dữ liệu từ ViewModel
        libraryViewModel.getLibraryItems().observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> libraryItems) {
                libraryAdapter.updateData(libraryItems);
            }
        });

        // Sự kiện nút thêm nghệ sĩ
        binding.fabAddArtist.setOnClickListener(v -> addNewArtist());
    }

    /**
     * Thiết lập RecyclerView
     */
    private void setupRecyclerView() {
        binding.recyclerViewLibrary.setLayoutManager(new LinearLayoutManager(getContext()));
        libraryAdapter = new LibraryAdapter(new LibraryAdapter.OnLibraryItemClickListener() {
            @Override
            public void onLibraryItemClick(String itemName) {
                Toast.makeText(getContext(), "Bạn đã chọn: " + itemName, Toast.LENGTH_SHORT).show();
            }
        });
        binding.recyclerViewLibrary.setAdapter(libraryAdapter);
    }

    /**
     * Hàm thêm nghệ sĩ mới
     */
    private void addNewArtist() {
        libraryViewModel.addArtist("Nghệ sĩ mới");
        Toast.makeText(getContext(), "Đã thêm nghệ sĩ mới", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
