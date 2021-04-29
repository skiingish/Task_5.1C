package com.sit305.task51c;

public class Places {

    // The place's ID.
    int id;

    // The place's image int.
    int imageFile;

    // The place's title and description.
    String title, description;

    // Place's Ctor
    public Places(int id, int imageFile, String title, String description) {
        this.id = id;
        this.imageFile = imageFile;
        this.title = title;
        this.description = description;
    }


    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageFile() {
        return imageFile;
    }

    public void setImageFile(int imageFile) {
        this.imageFile = imageFile;
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
}
