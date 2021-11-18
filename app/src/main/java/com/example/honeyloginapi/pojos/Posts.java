package com.example.honeyloginapi.pojos;

public class Posts {
    private String id, title, description, date_release, director, created_at, updated_at, name;

    public Posts() {
    }

    public Posts(String id, String title, String description, String date_release, String director, String created_at, String updated_at, String name) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date_release = date_release;
        this.director = director;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_release() {
        return date_release;
    }

    public void setDate_release(String date_release) {
        this.date_release = date_release;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
