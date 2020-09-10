package com.example.onboardingfold.pagetransformer;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.example.onboardingfold.R;

public class IntroPageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {

        // Get the page index from the tag. This makes
        // it possible to know which page index you're
        // currently transforming - and that can be used
        // to make some important performance improvements.

        // Here you can do all kinds of stuff, like get the
        // width of the page and perform calculations based
        // on how far the user has swiped the page.
        int pageWidth = page.getWidth();
        float pageWidthTimesPosition = pageWidth * position;
        float absPosition = Math.abs(position);

        // Now it's time for the effects
        if (position <= -1.0f || position >= 1.0f) {

            // The page is not visible. This is a good place to stop
            // any potential work / animations you may have running.

        } else if (position == 0.0f) {

            // The page is selected. This is a good time to reset Views
            // after animations as you can't always count on the PageTransformer
            // callbacks to match up perfectly.

        } else {

            // The page is currently being scrolled / swiped. This is
            // a good place to show animations that react to the user's
            // swiping as it provides a good user experience.

            // Let's start by animating the title.
            // We want it to fade as it scrolls out
            View pagerStrip = page.findViewById(R.id.pager_strip);
            pagerStrip.setAlpha(1.0f - absPosition);

            // Now, we want the image to move to the right,
            // i.e. in the opposite direction of the rest of the
            // content while fading out
            View computer = page.findViewById(R.id.hello_text);

            // We're attempting to create an effect for a View
            // specific to one of the pages in our ViewPager.
            // In other words, we need to check that we're on
            // the correct page and that the View in question
//            // isn't null.
//            if (pagePosition == 0 && computer != null) {
//                computer.setAlpha(1.0f - absPosition);
//                computer.setTranslationX(-pageWidthTimesPosition * 1.5f);
//            }

            // Finally, it can be useful to know the direction
            // of the user's swipe - if we're entering or exiting.
            // This is quite simple:
            if (position < 0) {
                // Create your out animation here
            } else {
                // Create your in animation here
            }
        }
    }

}