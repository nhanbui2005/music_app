package com.example.client.ui.home;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.client.R;
import com.example.client.config.AppViewModelFactory;
import com.example.client.databinding.FragmentHomeBinding;
import com.example.client.ui.home.adapter.CollectionAdapter;
import com.example.client.data.model.Collection;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements CollectionAdapter.OnCollectionClickListener { // Implement interface

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }




    @Override
    public void onCollectionClick(String collectionId) {
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
