package com.example.onboardingfold.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.onboardingfold.R;

public class OnboardingPage1Fragment extends Fragment {

    // All views (Text and Images)
    private ImageView artCloud;
    private ImageView artWork;
    private TextView helloText;
    private TextView mainText;
    private TextView swipeText;

    // store the page number
    private int pageNumber;

    // Duration for the Fade-In animation
    private int AnimationDuration;

    // a newInstance constructor for assigning a page no. to each of the onboarding pages
    public static Fragment newInstance(int pageNumber) {
        OnboardingPage1Fragment fragmentFirst = new OnboardingPage1Fragment();
        Bundle args = new Bundle();
        args.putInt("PageNumberofThis", pageNumber);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt("PageNumberofThis", 0);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onboarding_item1, container, false);

        // setting the animation duration for the Get Started Button (in milliseconds)
        AnimationDuration = 1000;

        artCloud = view.findViewById(R.id.art_cloud_image);
        artWork = view.findViewById(R.id.art_work_image);

        artCloud.setVisibility(View.INVISIBLE);
        artWork.setVisibility(View.INVISIBLE);

        artCloud.setAlpha(0f);
        artWork.setAlpha(0f);

        artCloud.setVisibility(View.VISIBLE);
        artWork.setVisibility(View.VISIBLE);

        Thread artCloudAnimationThread = new Thread(new Runnable() {
            @Override
            public void run() {
                artCloud.animate().alpha(1f).setDuration(AnimationDuration).setListener(null);
            }
        });

        Thread artWorkAnimationThread = new Thread(new Runnable() {
            @Override
            public void run() {
                artWork.animate().alpha(1f).setDuration(AnimationDuration).setListener(null);
            }
        });

        artCloudAnimationThread.start();
        artWorkAnimationThread.start();

        return view;
    }
}
