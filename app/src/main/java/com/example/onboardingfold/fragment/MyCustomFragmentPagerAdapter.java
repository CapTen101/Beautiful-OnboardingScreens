package com.example.onboardingfold.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyCustomFragmentPagerAdapter extends FragmentStateAdapter {

    // for storing the total number of pages in the viewPager
    private static int NUM_PAGES = 2;

    public MyCustomFragmentPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    // Returns the fragment to display for that particular page
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show OnboardingPage1Fragment
                return OnboardingPage1Fragment.newInstance(1);
            case 1: // Fragment # 1 - This will show SecondFragment
                return OnboardingPage2Fragment.newInstance(2);
            default:
                return null;
        }
    }

    // returns total number of pages
    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
