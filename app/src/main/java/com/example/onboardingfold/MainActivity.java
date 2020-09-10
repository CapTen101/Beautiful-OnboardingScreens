package com.example.onboardingfold;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Toast;

import com.example.onboardingfold.fragment.adapter.MyCustomFragmentPagerAdapter;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    FragmentStateAdapter mFragmentPagerAdapter;
    MaterialButton mCTAButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCTAButton = findViewById(R.id.get_started_button);

        ViewPager2 mViewPager = findViewById(R.id.onboardingViewPager);
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
//                Toast.makeText(MainActivity.this, "Selected page position: " + position+1, Toast.LENGTH_SHORT).show();
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