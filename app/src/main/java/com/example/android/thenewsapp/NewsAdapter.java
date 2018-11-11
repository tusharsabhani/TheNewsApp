package com.example.android.thenewsapp;

import android.content.ContentProvider;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {

    private static final String DATE_SEPERATOR = "T";
    private Context mContext;

    NewsAdapter(Context context, ArrayList<News> news){super(context,0,news);
    mContext = context;}

    @NonNull
    @Override
    public View getView(int position,@Nullable View convertView,@NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list, parent, false);
        }

        News news = getItem(position);

        String date;
        String time;
        String dateTime = news.getmDate();
        if (dateTime.contains(DATE_SEPERATOR)) {
            String[] parts = dateTime.split(DATE_SEPERATOR);
            date = parts[0];
            time = parts[1];
        }else{
            date = getContext().getString(R.string.noDate);
        }

        TextView dateView = listItemView.findViewById(R.id.date);
        dateView.setText(date);

        TextView titleView = listItemView.findViewById(R.id.headline);
        titleView.setText(news.getmTitle());

        TextView categoryView = listItemView.findViewById(R.id.category);
        categoryView.setText(news.getmCategory());

        TextView authorView = listItemView.findViewById(R.id.author);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        boolean showAuthorName = sharedPreferences.getBoolean(
                mContext.getString(R.string.author_name_key),
                Boolean.parseBoolean(mContext.getString(R.string.default_author_value))
        );

        if(showAuthorName){
            authorView.setVisibility(View.VISIBLE);
            authorView.setText(news.getmAuthor());
        }else{
            authorView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
