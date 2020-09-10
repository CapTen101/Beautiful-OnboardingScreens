package com.example.onboardingfold.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.icu.number.Scale;
import android.os.Bundle;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.fragment.app.Fragment;

import com.example.onboardingfold.R;

public class OnboardingPage1Fragment extends Fragment {

    // All views (Text and Images)
    private ImageView artCloud;
    private ImageView artWork;
    private TextView helloText;

    // Each word has a seperate textview
    // For initiating the animation seperately
    private TextView yourText, ownText;
    private TextView privateText, cloudText, isText;
    private TextView oneText, stepText, awayText;

    private TextView swipeText;

    // store the page number
    private int pageNumber;

    // Duration for the Fade-In animation
    private int ImageAnimationDuration;

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
        ImageAnimationDuration = 1000;

        // defining all the views in the fragment
        artCloud = view.findViewById(R.id.art_cloud_image);
        artWork = view.findViewById(R.id.art_work_image);
        helloText = view.findViewById(R.id.hello_text);
        yourText = view.findViewById(R.id.your);
        ownText = view.findViewById(R.id.own);
        privateText = view.findViewById(R.id._private);
        cloudText = view.findViewById(R.id.cloud);
        isText = view.findViewById(R.id.is);
        oneText = view.findViewById(R.id.one);
        stepText = view.findViewById(R.id.step);
        awayText = view.findViewById(R.id.away);
        swipeText = view.findViewById(R.id.swipe_text);

        // Intially all the views are invisible and then they come in through animations
        artCloud.setVisibility(View.INVISIBLE);
        artWork.setVisibility(View.INVISIBLE);

        // Animation goes from Alpha 0 to 1 through Fade-In
        artCloud.setAlpha(0f);
        artWork.setAlpha(0f);
        artCloud.setVisibility(View.VISIBLE);
        artWork.setVisibility(View.VISIBLE);

        // This pathInterpolator implements the Cubic-Bezier curve
        final Interpolator customInterpolator = new PathInterpolator(.47f, 0f, 0f, .99f);

        // This animation implements the Cubic-Bezier Animation
        @SuppressLint("ResourceType")
        final Animation anim = AnimationUtils.loadAnimation(getContext(), R.animator.textview_animation);
        anim.setInterpolator(customInterpolator);

//        // Here, two different threads are used for simultaneous starting two animations of the images
//        Thread artCloudAnimationThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//
//        Thread artWorkAnimationThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });

//        Thread helloThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                anim.setStartTime(ImageAnimationDuration);
//                helloText.startAnimation(anim);
//            }
//        });
//
//        Thread isThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                anim.setStartOffset(4000);
//                helloText.startAnimation(anim);
//            }
//        });

        // start the animations
//        artCloudAnimationThread.start();
//        artWorkAnimationThread.start();
        artCloud.animate().alpha(1f).setDuration(ImageAnimationDuration).setListener(null);
        artWork.animate().alpha(1f).setDuration(ImageAnimationDuration).setListener(null);
        helloText.setAnimation(anim);
        helloText.animate().setDuration(500).setStartDelay(4000).setListener(null);
        isText.startAnimation(anim);

//        // Closing off the residual threads
//        artCloudAnimationThread.interrupt();
//        artWorkAnimationThread.interrupt();
//        artCloudAnimationThread = null;
//        artWorkAnimationThread = null;

        return view;
    }
}