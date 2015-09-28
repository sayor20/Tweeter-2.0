package com.codepath.apps.restclienttemplate.models;

/*

"coordinates": {
      "coordinates": [
        -122.25831,
        37.871609
      ],
      "type": "Point"
    },
    "truncated": false,
    "created_at": "Tue Aug 28 21:08:15 +0000 2012",
    "favorited": false,
    "id_str": "240556426106372096",
    "in_reply_to_user_id_str": null,
    "entities": {
      "urls": [
        {
          "expanded_url": "http://blogs.ischool.berkeley.edu/i290-abdt-s12/",
          "url": "http://t.co/bfj7zkDJ",
          "indices": [
            79,
            99
          ],
          "display_url": "blogs.ischool.berkeley.edu/i290-abdt-s12/"
        }
      ],
      "hashtags": [

      ],
      "user_mentions": [
        {
          "name": "Cal",
          "id_str": "17445752",
          "id": 17445752,
          "indices": [
            60,
            64
          ],
          "screen_name": "Cal"
        },
        {
          "name": "Othman Laraki",
          "id_str": "20495814",
          "id": 20495814,
          "indices": [
            70,
            77
          ],
          "screen_name": "othman"
        }
      ]
    },
    "text": "lecturing at the \"analyzing big data with twitter\" class at @cal with @othman  http://t.co/bfj7zkDJ",
    "contributors": null,
    "id": 240556426106372096,
    "retweet_count": 3,
    "in_reply_to_status_id_str": null,
    "geo": {
      "coordinates": [
        37.871609,
        -122.25831
      ],
      "type": "Point"
    },
    "retweeted": false,
    "possibly_sensitive": false,
    "in_reply_to_user_id": null,
    "place": {
      "name": "Berkeley",
      "country_code": "US",
      "country": "United States",
      "attributes": {
      },
      "url": "http://api.twitter.com/1/geo/id/5ef5b7f391e30aff.json",
      "id": "5ef5b7f391e30aff",
      "bounding_box": {
        "coordinates": [
          [
            [
              -122.367781,
              37.835727
            ],
            [
              -122.234185,
              37.835727
            ],
            [
              -122.234185,
              37.905824
            ],
            [
              -122.367781,
              37.905824
            ]
          ]
        ],
        "type": "Polygon"
      },
      "full_name": "Berkeley, CA",
      "place_type": "city"
    },
    "source": "<a href="//www.apple.com\"" rel="\"nofollow\"">Safari on iOS</a>",
    "user": {
      "name": "Raffi Krikorian",
      "profile_sidebar_fill_color": "DDEEF6",
      "profile_background_tile": false,
      "profile_sidebar_border_color": "C0DEED",
      "profile_image_url": "http://a0.twimg.com/profile_images/1270234259/raffi-headshot-casual_normal.png",
      "created_at": "Sun Aug 19 14:24:06 +0000 2007",
      "location": "San Francisco, California",
      "follow_request_sent": false,
      "id_str": "8285392",
      "is_translator": false,
      "profile_link_color": "0084B4",
      "entities": {
        "url": {
          "urls": [
            {
              "expanded_url": "http://about.me/raffi.krikorian",
              "url": "http://t.co/eNmnM6q",
              "indices": [
                0,
                19
              ],
              "display_url": "about.me/raffi.krikorian"
            }
          ]
        },
        "description": {
          "urls": [

          ]
        }
      },
      "default_profile": true,
      "url": "http://t.co/eNmnM6q",
      "contributors_enabled": false,
      "favourites_count": 724,
      "utc_offset": -28800,
      "profile_image_url_https": "https://si0.twimg.com/profile_images/1270234259/raffi-headshot-casual_normal.png",
      "id": 8285392,
      "listed_count": 619,
      "profile_use_background_image": true,
      "profile_text_color": "333333",
      "followers_count": 18752,
      "lang": "en",
      "protected": false,
      "geo_enabled": true,
      "notifications": false,
      "description": "Director of @twittereng's Platform Services. I break things.",
      "profile_background_color": "C0DEED",
      "verified": false,
      "time_zone": "Pacific Time (US & Canada)",
      "profile_background_image_url_https": "https://si0.twimg.com/images/themes/theme1/bg.png",
      "statuses_count": 5007,
      "profile_background_image_url": "http://a0.twimg.com/images/themes/theme1/bg.png",
      "default_profile_image": false,
      "friends_count": 701,
      "following": true,
      "show_all_inline_media": true,
      "screen_name": "raffi"
    },
    "in_reply_to_screen_name": null,
    "in_reply_to_status_id": null
  }

 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Tweet {
    private String body;
    private long uid;
    private String createdate;
    private User user;

    public User getUser() {
        return user;
    }

    public String getBody() {
        return body;
    }

    public long getUid() {
        return uid;
    }

    public String getCreatedate() {
        return createdate;
    }

    public static Tweet fromJSON(JSONObject jsonObject){
        Tweet tweet = new Tweet();
        try {
            tweet.body = jsonObject.getString("text");
            tweet.uid = jsonObject.getLong("id_str");
            tweet.createdate = jsonObject.getString("created_at");
            tweet.user = User.fromJSON(new JSONObject(jsonObject.getString("user")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    return tweet;
    }

    public static ArrayList<Tweet> fromJSONArray(JSONArray jsonArray){
        ArrayList<Tweet> tweets = new ArrayList<Tweet>();
        Tweet tweet;
        for(int i=0;i<jsonArray.length();i++){
            try {
                tweet = fromJSON((JSONObject) jsonArray.get(i));
                tweets.add(tweet);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return tweets;
    }

}
