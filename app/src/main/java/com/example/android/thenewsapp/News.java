package com.example.android.thenewsapp;

public class News {

    private String mTitle;
    private String mCategory;
    private String mDate;
    private String mUrl;
    private String mAuthor;

    News(String title, String category, String date,String url,String author){
        mTitle = title;
        mCategory = category;
        mDate = date;
        mUrl = url;
        mAuthor = author;
    }

    public String getmDate(){
        return mDate;
    }

    public String getmTitle(){
        return  mTitle;
    }

    public  String getmCategory(){
        return mCategory;
    }

    public  String getmUrl(){
        return  mUrl;
    }

    public String getmAuthor(){return  mAuthor;}
}


