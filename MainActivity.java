package com.example.aleff.desafio;

import java.util.Locale;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;


public class MainActivity extends ActionBarActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(adapter);

        mViewPager.setOnPageChangeListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab = actionBar.newTab().setText("Youtube").setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Letra").setTabListener(this);
        actionBar.addTab(tab);

        VideoView video= new VideoView(this);

        Uri src = Uri.parse("http://audiodonline.com/listen/?wid=VP9I8ZUwKpc&title=imagine-dragons-warriors-lyric-video");
        video.setVideoURI(src);


        video.setMediaController(new MediaController(this));

    }


    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int arg0) {
            switch (arg0) {
                case 0:
                    return new Fragment_Video();
                case 1:
                    return new Fragment_Letra();
                default:
                    return null;
            }
        }
        public int getCount() {
            return 2;
        }
    }

    //implements on pager selected
    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    @Override
    public void onPageSelected(int i) {
        getSupportActionBar().setSelectedNavigationItem(i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }


    //implements tab listener
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}
