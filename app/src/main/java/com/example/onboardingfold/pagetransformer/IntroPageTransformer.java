package com.example.onboardingfold.pagetransformer;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.example.onboardingfold.R;

public class IntroPageTransformer implements ViewPager.PageTransformer {

    private int id;
    private int border = 0;
    private float speed = 0.8f;

    @Override
    public void transformPage(View view, float position) {

        // The view which must undergo parallax effect
        View artWorkParallax = view.findViewById(R.id.art_work_image);

        // Using ScaleX attribute to shift the view along with the page being scrolled
        if (artWorkParallax != null) {

            if (position > -1 && position < 1) {

                float width = artWorkParallax.getWidth();

                // These expressions initiate the parallax
                artWorkParallax.setTranslationX((position * width * speed));
                float scale = ((float) view.getWidth() - border) / view.getWidth();

                if (position == 0) {
                    view.setScaleX(1);
                    view.setScaleY(1);
                } else {
                    view.setScaleX(scale);
                    view.setScaleY(scale);
                }
            }
        }


        View artStairsParallax = view.findViewById(R.id.art_stairs_image);
        speed = 0.2f;

        if (artStairsParallax != null) {

            if (position > -1 && position < 1) {

                float width = artStairsParallax.getWidth();

                // These expressions initiate the parallax
                artStairsParallax.setTranslationX((position * width * speed));
                float scale = ((float) view.getWidth() - border) / view.getWidth();

                if (position == 0) {
                    view.setScaleX(1);
                    view.setScaleY(1);
                } else {
                    view.setScaleX(scale);
                    view.setScaleY(scale);
                }
            }
        }

    }

}