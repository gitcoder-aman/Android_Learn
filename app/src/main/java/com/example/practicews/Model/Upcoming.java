package com.example.practicews.Model;

import java.util.List;

public class Upcoming {

    private int page;
    private List<UpcomingList>results;


    public Upcoming() {
    }

    public Upcoming(int page, List<UpcomingList> results) {
        this.page = page;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<UpcomingList> getResults() {
        return results;
    }

    public void setResults(List<UpcomingList> results) {
        this.results = results;
    }
}
