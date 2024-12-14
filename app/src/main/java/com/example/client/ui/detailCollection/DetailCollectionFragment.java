package com.example.client.ui.detailCollection;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.client.R;
import com.example.client.config.AppViewModelFactory;
import com.example.client.data.adapter.SongAdapter;
import com.example.client.data.model.Collection;
import com.example.client.data.model.Song;
import com.example.client.databinding.FragmentDetailCollectionBinding;
import com.example.client.service_notification.MusicService;
import com.example.client.ui.LandingActivity;
import com.example.client.ui.home.HomeViewModel;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DetailCollectionFragment extends Fragment implements SongAdapter.OnSongItemClickListener {
    private FragmentDetailCollectionBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailCollectionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onSongItemClick(Song song) {

    }
}
