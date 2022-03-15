package com.zhuzhu.mobile.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.zhuzhu.mobile.ui.bean.FragmentInfo;
import com.zhuzhu.mobile.ui.fragment.CategoryFragment;
import com.zhuzhu.mobile.ui.fragment.GamesFragment;
import com.zhuzhu.mobile.ui.fragment.RankingFragment;
import com.zhuzhu.mobile.ui.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 2016/12/8.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {




    private List<FragmentInfo> mFragments = new ArrayList<>(4);


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);

        initFragments();
    }



    private void initFragments(){

        mFragments.add(new FragmentInfo("推荐",RecommendFragment.class));
        mFragments.add(new FragmentInfo ("排行", RankingFragment.class));


        mFragments.add(new FragmentInfo ("游戏", GamesFragment.class));
        mFragments.add(new FragmentInfo ("分类", CategoryFragment.class));

    }


    @Override
    public Fragment getItem(int position) {


        try {
            return (Fragment) mFragments.get(position).getFragment().newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return  null;

//        Fragment fragment = null;
//        switch (position){
//
//            case 0:
//                fragment = new RecommendFragment();
//                break;
//
//            case 1:
//                fragment = new RankingFragment();
//                break;
//
//            case 2:
//                fragment = new GamesFragment();
//                break;
//
//            case 3:
//                fragment = new CategoryFragment();
//                break;
//
//        }
//
//        return fragment;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getTitle();
    }
}
