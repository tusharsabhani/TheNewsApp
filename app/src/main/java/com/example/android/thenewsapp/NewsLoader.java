package com.example.android.thenewsapp;
import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /** Query URL */
    private String mUrl;

    public NewsLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (mUrl == null)
            return null;

        List<News> news = QueryUtils.fetchData(mUrl);
        return news;
    }
}
