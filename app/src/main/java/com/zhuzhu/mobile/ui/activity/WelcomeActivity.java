package com.zhuzhu.mobile.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;

import com.zhuzhu.mobile.R;
import com.zhuzhu.mobile.common.Constant;
import com.zhuzhu.mobile.common.util.ACache;
import com.eftimoff.androipathview.PathView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity {


    @BindView(R.id.pathView)
    PathView mPathView;
    @BindView(R.id.activity_welcome)
    LinearLayout mActivityWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        mPathView.getPathAnimator()
                .delay(100)
                .duration(5000)
                .interpolator(new AccelerateDecelerateInterpolator())
                .listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
                    @Override
                    public void onAnimationEnd() {
                        jump();
                    }
                })

                .start();
    }

    private void jump() {

        String isShowGuide =  ACache.get(this).getAsString(Constant.IS_SHOW_GUIDE);

        // 第一次启动进入引导页面
        if(null == isShowGuide){
            startActivity(new Intent(this,GuideActivity.class));

        }
        else{
            startActivity(new Intent(this,MainActivity.class));
        }

        this.finish();
    }
}

