package com.example.client.ui;

import static java.security.AccessController.getContext;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import com.example.client.R;
import com.example.client.config.AppViewModelFactory;
import com.example.client.data.model.Song;
import com.example.client.databinding.ActivityLandingBinding;
import com.example.client.service_notification.MusicService;
import com.example.client.ui.detailCollection.DetailCollectionViewModel;
import com.example.client.ui.home.HomeFragment;
import com.example.client.ui.home.HomeViewModel;
import com.example.client.ui.library.LibraryFragment;
import com.example.client.ui.search.SearchFragment;
import com.example.client.ui.user.UserFragment;
import com.squareup.picasso.Picasso;

public class LandingActivity extends AppCompatActivity {

    private ActivityLandingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}