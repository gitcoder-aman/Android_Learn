package com.example.practicews.Model;


import java.util.List;

public class TrendingMovieModel {

    private Integer page;

    private List<TrendingMovieResultModel> results;

    private Integer total_pages;
    private Integer total_results;

    public TrendingMovieModel() {
    }

    public TrendingMovieModel(Integer page, List<TrendingMovieResultModel> results, Integer total_pages, Integer total_results) {
        this.page = page;
        this.results = results;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }

    public Integer getPage() {
        return page;
    }

    public List<TrendingMovieResultModel> getResults() {
        return results;
    }

    public void setResults(List<TrendingMovieResultModel> results) {
        this.results = results;
    }

    public void setPage(Integer page) {
        this.page = page;
    }



    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }
}
