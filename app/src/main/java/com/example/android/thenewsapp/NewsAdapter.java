package com.example.android.thenewsapp;

import android.content.Context;
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
    private static final String Date_Seperator = "Z";

    NewsAdapter(Context context, ArrayList<News> news){super(context,0,news);}

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

        return listItemView;
    }
}
