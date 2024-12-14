package com.example.client.data.model;

import java.io.Serializable;
import java.util.List;

public class Collection implements Serializable {
    String _id;
    String name;
    String image;
    Artist artist;
    int duration;
    List<Song> songs;
    String description;

    //all
    public Collection(String _id, String name, String image, Artist artist, List<Song> songs, String description, int duration) {
        this._id = _id;
        this.name = name;
        this.image = image;
        this.artist = artist;
        this.duration = duration;
        this.songs = songs;
        this.description = description;
    }
    //view
    public Collection(String _id, String name, String image, String description){
        this._id = _id;
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public Collection() {
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
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}kkkkkkkk
jhggjhjhgghh
        cặc phú