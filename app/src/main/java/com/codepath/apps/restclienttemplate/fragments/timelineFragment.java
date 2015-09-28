package com.codepath.apps.restclienttemplate.fragments;


import android.os.Bundle;
import android.util.Log;

import com.codepath.apps.restclienttemplate.TwitterApplication;
import com.codepath.apps.restclienttemplate.TwitterClient;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;

public class TimelineFragment extends BaseFragment {

    private TwitterClient client;   // instantiating twitter client

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = TwitterApplication.getRestClient();    // singleton class
        downloadTimelineFeed();
    }

    public static TimelineFragment newInstance(){
        TimelineFragment tfragment  = new TimelineFragment();
        // Bundle args = new Bundle();
        // args.putInt("count", count);
        // args.putString("title", title);
        // tfragment.setArguments(args);
        return tfragment;
    }

    private void downloadTimelineFeed() {
        // getting timeline data
        client.getTimelineData(new JsonHttpResponseHandler() {
            // success
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray) {
                tweets = Tweet.fromJSONArray(jsonArray);
                tAdapter.addAll(tweets);
            }

            // failure
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                Log.e("msgd", "error getting Twitter Timeline JSON");
            }
        });
    }
}
