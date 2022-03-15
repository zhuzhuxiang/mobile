package com.zhuzhu.mobile.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zhuzhu.mobile.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideFragment extends Fragment {


    public static final String IMG_ID = "IMG_ID";
    public static final String COLOR_ID = "COLOR_ID";
    public static final String TEXT_ID = "TEXT_ID";

    @BindView(R.id.imgView)
    ImageView mImgView;
    @BindView(R.id.text)
    TextView mText;

    @BindView(R.id.rootView)
    LinearLayout mRootView;


    private View mView;

    public static GuideFragment newInstance(int imgResId, int bgColorResId, int textResId) {

        GuideFragment fragment = new GuideFragment();

        Bundle bundle = new Bundle();

        bundle.putInt(IMG_ID, imgResId);
        bundle.putInt(COLOR_ID, bgColorResId);
        bundle.putInt(TEXT_ID, textResId);
        fragment.setArguments(bundle);

        return fragment;


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_guide, container, false);

        ButterKnife.bind(this, mView);
        initData();

        return mView;
    }

    private void initData() {

        Bundle args = getArguments();

        int colorId = args.getInt(COLOR_ID);
        int imgId = args.getInt(IMG_ID);
        int textId = args.getInt(TEXT_ID);


        mRootView.setBackgroundColor(getResources().getColor(colorId));
        mImgView.setImageResource(imgId);
        mText.setText(textId);



    }
}
