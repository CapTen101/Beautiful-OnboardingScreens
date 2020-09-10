package com.example.onboardingfold;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Toast;

import com.example.onboardingfold.fragment.MyCustomFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {

    FragmentStateAdapter mFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Toast.makeText(MainActivity.this, "Selected page position: " + position, Toast.LENGTH_SHORT).show();
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