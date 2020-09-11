package com.example.onboardingfold.pagetransformer;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.example.onboardingfold.R;

public class IntroPageTransformer implements ViewPager.PageTransformer {

    private int id;
    private int border = 0;
    private float speed = 0.2f;

    @Override
    public void transformPage(View view, float position) {

        View parallaxView = view.findViewById(R.id.art_work_image);

//        if (view == null ) {
//            Log.w("ParallaxPager", "There is no view");
//        }

        if (parallaxView != null) {
            if (position > -1 && position < 1) {
                float width = parallaxView.getWidth();
                parallaxView.setTranslationX((position * width * speed));
                float sc = ((float)view.getWidth() - border)/ view.getWidth();
                if (position == 0) {
                    view.setScaleX(1);
                    view.setScaleY(1);
                } else {
                    view.setScaleX(sc);
                    view.setScaleY(sc);
                }
            }
        }

    }

}