package com.codepath.apps.restclienttemplate.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.apps.restclienttemplate.R;
import com.codepath.apps.restclienttemplate.fragments.MentionFragment;
import com.codepath.apps.restclienttemplate.fragments.TimelineFragment;


public class BaseActivity extends ActionBarActivity {

    private ViewPager vp;
    private myPageAdapter pvadapter;
    private PagerSlidingTabStrip tab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        vp = (ViewPager)findViewById(R.id.vpPager);
        tab = (PagerSlidingTabStrip) findViewById(R.id.tabs);

        pvadapter = new myPageAdapter(this.getSupportFragmentManager());
        vp.setAdapter(pvadapter);
        tab.setViewPager(vp);
    }

    public void loadProfileDetails(MenuItem mi){
        Intent i= new Intent(this, ProfileActivity.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_timeline, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_profile) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class myPageAdapter extends FragmentPagerAdapter{

        private String[] tabtitles={"home","mentions"};

        public myPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0){
                return TimelineFragment.newInstance();
            }else if(position==1){
                return MentionFragment.newInstance();
            }else{
                return new Fragment();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabtitles[position];
        }

        @Override
        public int getCount() {
            return tabtitles.length;
        }
    }
}
