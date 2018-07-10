package com.example.aungko.suhtar.home_process;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aungko.suhtar.R;

public class HomeFragment extends Fragment {

    CardView ImageCardView;
    ImageView imageView;
    AppBarLayout mAppBarLayout;
    int mMaxScrollSize;
    static final int PERCENTAGE_TO_ANIMATE_AVATAR = 20;
    boolean mIsAvatarShown = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        ImageCardView = view.findViewById(R.id.card_view_detail);
        imageView = view.findViewById(R.id.image_view_detail);

        mAppBarLayout = view.findViewById(R.id.appbar);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMaxScrollSize = mAppBarLayout.getTotalScrollRange();

        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (mMaxScrollSize == 0)
                    mMaxScrollSize = appBarLayout.getTotalScrollRange();

                int percentage = (Math.abs(verticalOffset)) * 100 / mMaxScrollSize;

                if (percentage >= PERCENTAGE_TO_ANIMATE_AVATAR && mIsAvatarShown) {
                    mIsAvatarShown = false;

                    ImageCardView.animate()
                            .scaleY(0).scaleX(0)
                            .setDuration(200)
                            .start();
                }

                if (percentage <= PERCENTAGE_TO_ANIMATE_AVATAR && !mIsAvatarShown) {
                    mIsAvatarShown = true;

                    ImageCardView.animate()
                            .scaleY(1).scaleX(1)
                            .start();
                }
            }
        });
    }
}
