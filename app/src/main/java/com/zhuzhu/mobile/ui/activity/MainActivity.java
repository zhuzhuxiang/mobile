package com.zhuzhu.mobile.ui.activity;

import android.os.Bundle;
import androidx.annotation.NonNull;

import com.zhuzhu.mobile.di.component.AppComponent;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.zhuzhu.mobile.R;
import com.zhuzhu.mobile.ui.adapter.ViewPagerAdapter;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;


    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;


    private View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        initDrawerLayout(); //初始化抽屉布局
        initTabLayout();//初始化头部标签栏
    }

    private void initTabLayout() {

        PagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);

    }

    private void initDrawerLayout() {


        headerView = mNavigationView.getHeaderView(0);

        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "headerView clicked", Toast.LENGTH_LONG).show();
            }
        });


        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {

                    case R.id.menu_app_update:

                        Toast.makeText(MainActivity.this, "点击了应用更新", Toast.LENGTH_LONG).show();

                        break;


                    case R.id.menu_message:

                        Toast.makeText(MainActivity.this, "点击了消息", Toast.LENGTH_LONG).show();

                        break;
                }


                return false;
            }
        });


        mToolBar.inflateMenu(R.menu.toolbar_menu);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.open, R.string.close);

        drawerToggle.syncState();

        mDrawerLayout.addDrawerListener(drawerToggle);


    }
}
