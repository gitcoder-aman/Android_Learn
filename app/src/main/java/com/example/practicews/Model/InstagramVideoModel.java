package com.example.practicews.Model;

import java.util.List;

public class InstagramVideoModel {

    private List<InstagramItemDetailModel> items;

    private int num_results;
    private boolean more_available;

    public InstagramVideoModel(List<InstagramItemDetailModel> items, int num_results, boolean more_available) {
        this.items = items;
        this.num_results = num_results;
        this.more_available = more_available;
    }

    public InstagramVideoModel() {
    }

    public int getNum_results() {
        return num_results;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public boolean isMore_available() {
        return more_available;
    }

    public void setMore_available(boolean more_available) {
        this.more_available = more_available;
    }

    public List<InstagramItemDetailModel> getItems() {
        return items;
    }

    public void setItems(List<InstagramItemDetailModel> items) {
        this.items = items;
    }
}
