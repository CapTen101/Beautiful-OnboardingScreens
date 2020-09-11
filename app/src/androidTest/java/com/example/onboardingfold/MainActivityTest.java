package com.example.onboardingfold;

import android.app.Activity;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.viewpager.widget.ViewPager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    ActivityScenario activityScenario;
    private ViewPager testPager;
    private FragmentPagerAdapter testAdapter;


    @Before
    public void setUp() throws Exception {
        testPager = new ViewPager(new Activity());
        testAdapter = (FragmentPagerAdapter) testPager.getAdapter();
    }

    @Test
    public void shouldSetAndGetAdapter() throws Exception {
        assertNull(testPager.getAdapter());

        testPager.setAdapter(testAdapter);
        assertSame(testAdapter, testPager.getAdapter());
    }

    @Test
    public void testMainInit() {
        activityScenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.onboardingViewPager)).check(matches(isDisplayed()));
        onView(withId(R.id.tab_layout)).check(matches(isDisplayed()));
    }

}