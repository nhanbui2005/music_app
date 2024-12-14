package com.example.client.data.model;

import java.io.Serializable;

public class Artist implements Serializable {
    String _id;
    String name;
    String description;
    String image;

    public Artist() {
    }

    public Artist(String _id, String name, String description, String image) {
        this._id = _id;
        this.name = name;
        this.description = description;
        this.image = image;
    }
    public Artist(String _id, String name) {
        this._id = _id;
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
