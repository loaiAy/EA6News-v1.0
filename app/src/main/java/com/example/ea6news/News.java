package com.example.ea6news;

import java.util.ArrayList;

public class News {

    private String stat;
    private String total;
    private ArrayList<Model> articles;

    public News(String stat, String total, ArrayList<Model> articles) {
        this.stat = stat;
        this.total = total;
        this.articles = articles;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public ArrayList<Model> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Model> articles) {
        this.articles = articles;
    }
}
