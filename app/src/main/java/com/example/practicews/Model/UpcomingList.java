package com.example.practicews.Model;

public class UpcomingList {

    private String original_title;
    private String release_date;

    public UpcomingList() {
    }

    public UpcomingList(String original_title, String release_date) {
        this.original_title = original_title;
        this.release_date = release_date;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}
