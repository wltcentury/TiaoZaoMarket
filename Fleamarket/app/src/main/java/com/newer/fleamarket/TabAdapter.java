package com.newer.fleamarket;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-02-23.
 */
public class TabAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments=new ArrayList<>();
    String[]data=new String[]{"首页","分类","发现","我的"};

    /**
     *
     * @param context
     * @param fm        Fragment管理
     */
    public TabAdapter(Context context, FragmentManager fm) {
        super(fm);

       fragments.add(new HomeFragment());
       fragments.add(new ClassifyFragment());
       fragments.add(new Fragment());
       fragments.add(new MyFragment());
    }

    /**
     * 获得总数
     * @return
     */
    @Override
    public int getCount() {
        return data.length;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return data[position];
    }
}
