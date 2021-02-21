package com.example.mypizza;

public class RecyclerViewItem {

    private int imageResource;
    private String titleNews;
    private String subtitleNews;

    public RecyclerViewItem(int imageResource, String titleNews, String subtitleNews) {
        this.imageResource = imageResource;
        this.titleNews = titleNews;
        this.subtitleNews = subtitleNews;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitleNews() {
        return titleNews;
    }

    public String getSubtitleNews() {
        return subtitleNews;
    }

}
