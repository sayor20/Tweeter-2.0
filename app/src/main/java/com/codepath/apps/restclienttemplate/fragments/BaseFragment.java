package com.codepath.apps.restclienttemplate.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.codepath.apps.restclienttemplate.R;
import com.codepath.apps.restclienttemplate.adapters.TwitterAdapter;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.ArrayList;

public class BaseFragment extends Fragment {

    protected TwitterAdapter tAdapter;
    protected ArrayList<Tweet> tweets;
    private ListView lvTweets;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tweets = new ArrayList<Tweet>();
        tAdapter = new TwitterAdapter(getContext(), tweets);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.base_fragment, parent, false);
        lvTweets = (ListView) v .findViewById(R.id.lvTweets);
        lvTweets.setAdapter(tAdapter);
        return v;
    }
}
