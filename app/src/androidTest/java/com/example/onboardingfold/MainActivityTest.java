package com.example.onboardingfold;

import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.viewpager.widget.ViewPager;

import com.example.onboardingfold.fragment.OnboardingPage1Fragment;
import com.example.onboardingfold.fragment.adapter.MyCustomFragmentPagerAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static androidx.test.InstrumentationRegistry.getContext;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    ActivityScenario activityScenario;
    private ViewPager testPager;
    private OnboardingPage1Fragment fragment = new OnboardingPage1Fragment();

    // Intiate the viewPager and PagerAdapter
    @Before
    public void init_ViewPager() {
        testPager = new ViewPager(getContext());
        fragment = (OnboardingPage1Fragment) OnboardingPage1Fragment.newInstance(1);
    }

    @Mock
    MyCustomFragmentPagerAdapter testAdapter = new MyCustomFragmentPagerAdapter(fragment.getFragmentManager());

    // Check for proper instantiation of the viewPager PagerAdapter
    @Test
    public void test_InitAdapter() {
        assertNull(testPager.getAdapter());

        testPager.setAdapter(testAdapter);
        assertSame(testAdapter, testPager.getAdapter());
    }

    // Testing for Adapter NOT_NULL
    @Test
    public void test_AdapterNotNull() {
        assertNotNull(testAdapter);
    }

    // Testing for TabLayout and ViewPager being displayed
    @Test
    public void test_PagerDisplayed() {
        activityScenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.onboardingViewPager)).check(matches(isDisplayed()));
        onView(withId(R.id.tab_layout)).check(matches(isDisplayed()));
    }

}