package com.example.client;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.client.data.adapter.SongAdapter;
import com.example.client.ui.home.HomeViewModel;
import com.example.client.data.model.Song; // Assuming you have a Song model class
import com.example.client.config.AppViewModelFactory; // Import your ViewModel factory

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
