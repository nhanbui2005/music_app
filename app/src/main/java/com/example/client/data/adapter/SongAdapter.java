package com.example.client.data.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.client.data.model.Artist;
import com.example.client.data.model.Song;
import com.example.client.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private List<Song> songs;
    private final OnSongItemClickListener listener;

    public SongAdapter(List<Song> songList, OnSongItemClickListener listener) {
        this.songs = new ArrayList<>(songList != null ? songList : new ArrayList<>());
        this.listener = listener;
    }

    public void updateSongs(List<Song> newSongs) {
        if (newSongs != null && !newSongs.isEmpty()) {
            songs.clear();
            songs.addAll(newSongs);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        holder.bind(songs.get(position));
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder {
        private final ImageView songImage;
        private final TextView songName;
        private final TextView artistName;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            songImage = itemView.findViewById(R.id.song_image);
            songName = itemView.findViewById(R.id.song_name);
            artistName = itemView.findViewById(R.id.artist_name);

            // Click listener for the entire itemView
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onSongItemClick(songs.get(position));
                }
            });
        }

        // Bind data to the views
        public void bind(Song song) {

            songName.setText(song.getName());

            StringBuilder artistNames = new StringBuilder();
            for (int i = 0; i < song.getArtists().size(); i++) {
                artistNames.append(song.getArtists().get(i).getName());
                if (i < song.getArtists().size() - 1) {
                    artistNames.append(", ");
                }
            }
            artistName.setText(artistNames.toString());

            Picasso.get()
                    .load(song.getImage())
                    .placeholder(R.drawable.icon_user_gray)
                    .into(songImage);
        }
    }

    // Listener Interface
    public interface OnSongItemClickListener {
        void onSongItemClick(Song song);
    }
}
