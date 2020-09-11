package com.example.onboardingfold.pagetransformer;

import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.example.onboardingfold.fragment.OnboardingPage1Fragment;
import com.example.onboardingfold.fragment.adapter.MyCustomFragmentPagerAdapter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static androidx.test.InstrumentationRegistry.getContext;
import static org.junit.Assert.assertNotNull;

public class IntroPageTransformerTest {

    private ViewPager testPager;
    private ViewPager.PageTransformer testPageTransformer;
    private OnboardingPage1Fragment fragment = new OnboardingPage1Fragment();
    private ImageView testArtWork;
    private ImageView testArtStairs;

    @Mock
    MyCustomFragmentPagerAdapter testAdapter = new MyCustomFragmentPagerAdapter(fragment.getFragmentManager());

    // Intiate the viewPager and PagerAdapter
    @Before
    public void init_PageTransformer() {
        testPager = new ViewPager(getContext());
        testPageTransformer = new IntroPageTransformer();
        fragment = (OnboardingPage1Fragment) OnboardingPage1Fragment.newInstance(1);
        testPager.setAdapter(testAdapter);
        testPager.setPageTransformer(false, testPageTransformer);
    }

    // Checking for PageTransformer NOT NULL
    @Test
    public void test_ViewNotNull() {
        assertNotNull(testPageTransformer);
    }
}