package com.newer.fleamarket;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewpager;
    TabLayout tabLayout;
    TabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        //使用Toolbar带头Actionbar
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //关联Tab和Viewpager
        tabAdapter = new TabAdapter(this, getSupportFragmentManager());
        //预加载
        viewpager.setOffscreenPageLimit(2);
        viewpager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewpager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void image_home(View view) {

        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.home_product:
                intent.setClass(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void classify_list(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.imageView_classify:
                intent.setClass(MainActivity.this, ClassifyActivity.class);
                startActivity(intent);
                break;
        }
    }
}
