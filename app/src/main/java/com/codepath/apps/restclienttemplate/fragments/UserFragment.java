package com.codepath.apps.restclienttemplate.fragments;

import android.os.Bundle;
import android.util.Log;

import com.codepath.apps.restclienttemplate.TwitterApplication;
import com.codepath.apps.restclienttemplate.TwitterClient;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;

public class UserFragment extends BaseFragment{

    private TwitterClient client;   // instantiating twitter client

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = TwitterApplication.getRestClient();    // singleton class
        downloadUserFeed();
    }

    public static UserFragment newInstance(String screenname){
        UserFragment ufragment  = new UserFragment();
        Bundle args = new Bundle();
        args.putString("screenname", screenname);
        ufragment.setArguments(args);
        return ufragment;
    }


    private void downloadUserFeed() {

        String screen_name = getArguments().getString("screenname");
        // getting timeline data
        client.getUserData(screen_name, new JsonHttpResponseHandler() {
            // success
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray) {
                tweets = Tweet.fromJSONArray(jsonArray);
                tAdapter.addAll(tweets);
            }

            // failure
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                Log.e("msgd", "error getting User Timeline JSON");
            }
        });
    }
}
