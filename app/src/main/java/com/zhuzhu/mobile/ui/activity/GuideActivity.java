package com.zhuzhu.mobile.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.zhuzhu.mobile.R;
import com.zhuzhu.mobile.common.Constant;
import com.zhuzhu.mobile.common.util.ACache;
import com.zhuzhu.mobile.ui.adapter.GuideFragmentAdapter;
import com.zhuzhu.mobile.ui.fragment.GuideFragment;
import com.zhuzhu.mobile.ui.widget.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.btn_enter)
    Button mBtnEnter;


    @BindView(R.id.activity_guide)
    RelativeLayout mActivityGuide;
    @BindView(R.id.indicator)
    CircleIndicator mIndicator;


    private GuideFragmentAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);


        initData();
    }

    private void initData() {


        List<Fragment> fragments = new ArrayList<>();

        fragments.add(GuideFragment.newInstance(R.drawable.guide_1, R.color.color_bg_guide1, R.string.guide_1));
        fragments.add(GuideFragment.newInstance(R.drawable.guide_2, R.color.color_bg_guide2, R.string.guide_2));
        fragments.add(GuideFragment.newInstance(R.drawable.guide_3, R.color.color_bg_guide3, R.string.guide_3));

        mAdapter = new GuideFragmentAdapter(getSupportFragmentManager());

        mAdapter.setFragments(fragments);

        mViewpager.setCurrentItem(0);
        mViewpager.setOffscreenPageLimit(mAdapter.getCount());
        mViewpager.setAdapter(mAdapter);

        mViewpager.addOnPageChangeListener(this);

//        mViewpager.setPageTransformer();

        mIndicator.setViewPager(mViewpager);


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


        mBtnEnter.setVisibility((position == mAdapter.getCount() - 1) ? View.VISIBLE : View.GONE);

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @OnClick(R.id.btn_enter)
    public void onClick() {

        ACache.get(this).put(Constant.IS_SHOW_GUIDE,"0");
        startActivity(new Intent(this,MainActivity.class));
        this.finish();

    }
}
