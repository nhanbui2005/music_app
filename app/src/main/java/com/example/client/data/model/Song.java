package com.example.client.data.model;

import java.io.Serializable;
import java.util.List;

public class Song implements Serializable {
    private String _id;
    private String name;
    private List<Artist> artist;
    private String image;
    private String lyrics;
    private int duration;
    private String audio_url;

    // Default constructor
    public Song() {
    }

    public Song(String _id, String name, List<Artist> artist, String image, String lyrics, int duration, String audio_url) {
        this._id = _id;
        this.name = name;
        this.artist = artist;
        this.image = image;
        this.lyrics = lyrics;
        this.duration = duration;
        this.audio_url = audio_url;
    }

    public Song(String _id, String name, List<Artist> artist, String image, String audio_url, int duration) {
        this._id = _id;
        this.name = name;
        this.artist = artist;
        this.image = image;
        this.duration = duration;
        this.audio_url = audio_url;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAudio_url() {
        return audio_url;
    }

    public void setAudio_url(String audio_url) {
        this.audio_url = audio_url;
    }

    // Getter và setter cho artists
    public List<Artist> getArtists() {
        return artist;
    }

    public void setArtists(List<Artist> artist) {
        this.artist = artist;
    }
}

