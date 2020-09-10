package com.example.onboardingfold;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.onboardingfold.fragment.adapter.MyCustomFragmentPagerAdapter;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    FragmentStateAdapter mFragmentPagerAdapter;
    MaterialButton mCTAButton;
    ViewPager2 mViewPager;
    private int shortAnimationDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setting the animation duration for the Get Started Button (in milliseconds)
        shortAnimationDuration = 2500;

        mCTAButton = findViewById(R.id.get_started_button);
        mViewPager = findViewById(R.id.onboardingViewPager);

        // Intially all the views are invisible and then they come in through animations
        mCTAButton.setVisibility(View.INVISIBLE);

        mCTAButton.setAlpha(0f);
        mCTAButton.setVisibility(View.VISIBLE);

        // Here the animation takes place
        mCTAButton.animate().alpha(1f).setDuration(shortAnimationDuration).setListener(null);

        // Setting the viewPager and viewPager Adapter
        mFragmentPagerAdapter = new MyCustomFragmentPagerAdapter(getSupportFragmentManager(), getLifecycle());
        mViewPager.setAdapter(mFragmentPagerAdapter);

        // Whenever the user tries to scroll the pages, this listener will change the length
        // and color of the PageControl above
        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            // Do domething here when the user lands at a particular page
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE / SCROLL_STATE_DRAGGING / SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);


            }
        });


    }
}