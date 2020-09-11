package com.example.onboardingfold;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import com.example.onboardingfold.fragment.adapter.MyCustomFragmentPagerAdapter;
import com.example.onboardingfold.pagetransformer.IntroPageTransformer;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    FragmentPagerAdapter mFragmentPagerAdapter;
    MaterialButton mCTAButton;
    ViewPager mViewPager;
    PagerTabStrip mPagerTabStrip;

    // Duration for the Fade-In animation
    private int AnimationDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setting the animation duration for the Get Started Button (in milliseconds)
        AnimationDuration = 3500;

        mCTAButton = findViewById(R.id.get_started_button);
        mViewPager = findViewById(R.id.onboardingViewPager);
//        mPagerTabStrip = findViewById(R.id.pager_strip);
        final TabLayout tabLayout = findViewById(R.id.tab_layout);

        // Intially all the views are invisible and then they come in through animations
        mCTAButton.setVisibility(View.INVISIBLE);
//        mPagerTabStrip.setVisibility(View.INVISIBLE);

        // Animation goes from Alpha 0 to 1 through Fade-In
        mCTAButton.setAlpha(0f);
//        mPagerTabStrip.setAlpha(0f);
        mCTAButton.setVisibility(View.VISIBLE);
//        mPagerTabStrip.setVisibility(View.VISIBLE);

        // Setting the viewPager and viewPager Adapter
        mFragmentPagerAdapter = new MyCustomFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mFragmentPagerAdapter);
//        tabLayout.setBackgroundResource(R.drawable.page_control_indicator_item_active);
        tabLayout.setupWithViewPager(mViewPager, true);
        tabLayout.setTabIndicatorFullWidth(false);


//        InkPageIndicator inkPageIndicator = (InkPageIndicator) findViewById(R.id.indicator);
//        inkPageIndicator.setViewPager(mViewPager);

        // Set a PageTransformer
        mViewPager.setPageTransformer(false, new IntroPageTransformer());

        mCTAButton.animate()
                .alpha(1f)
                .setDuration(AnimationDuration)
                .setStartDelay(4500)
                .setListener(null);

//        mPagerTabStrip.animate()
//                .alpha(1f)
//                .setDuration(AnimationDuration)
//                .setStartDelay(4500)
//                .setListener(null);

        // Whenever the user tries to scroll the pages, this listener will change the length
        // and color of the PageIndicatorSlider above the page
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will provide us the PageIndicatorSlider float values
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Drawable drawable = ContextCompat.getDrawable(getBaseContext(), R.drawable.page_control_indicator_item_active);
//                drawable.setBounds(0,0,106*positionOffset,8);
            }

            // Do something here when the user lands at a particular page
            @Override
            public void onPageSelected(int position) {
//                mPagerTabStrip.setBackgroundResource(R.drawable.page_control_indicator_item_active);


            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE / SCROLL_STATE_DRAGGING / SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}