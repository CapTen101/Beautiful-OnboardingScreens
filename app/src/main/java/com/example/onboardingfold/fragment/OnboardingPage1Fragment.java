package com.example.onboardingfold.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
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
    private int TextAnimationDuration;

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
        ImageAnimationDuration = 1500;
        TextAnimationDuration = 1000;

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
        helloText.setVisibility(View.INVISIBLE);
        yourText.setVisibility(View.INVISIBLE);
        ownText.setVisibility(View.INVISIBLE);
        privateText.setVisibility(View.INVISIBLE);
        cloudText.setVisibility(View.INVISIBLE);
        isText.setVisibility(View.INVISIBLE);
        oneText.setVisibility(View.INVISIBLE);
        stepText.setVisibility(View.INVISIBLE);
        awayText.setVisibility(View.INVISIBLE);
        swipeText.setVisibility(View.INVISIBLE);

        // Animation goes from Alpha 0 to 1 through Fade-In
        artCloud.setAlpha(0f);
        artWork.setAlpha(0f);
        helloText.setAlpha(0f);
        yourText.setAlpha(0f);
        ownText.setAlpha(0f);
        privateText.setAlpha(0f);
        cloudText.setAlpha(0f);
        isText.setAlpha(0f);
        oneText.setAlpha(0f);
        stepText.setAlpha(0f);
        awayText.setAlpha(0f);
        swipeText.setAlpha(0f);

        // Now making them VISIBLE
        artCloud.setVisibility(View.VISIBLE);
        artWork.setVisibility(View.VISIBLE);
        helloText.setVisibility(View.VISIBLE);
        yourText.setVisibility(View.VISIBLE);
        ownText.setVisibility(View.VISIBLE);
        privateText.setVisibility(View.VISIBLE);
        cloudText.setVisibility(View.VISIBLE);
        isText.setVisibility(View.VISIBLE);
        oneText.setVisibility(View.VISIBLE);
        stepText.setVisibility(View.VISIBLE);
        awayText.setVisibility(View.VISIBLE);
        swipeText.setVisibility(View.VISIBLE);


        // This pathInterpolator implements the Cubic-Bezier curve
        final Interpolator customInterpolator = new PathInterpolator(.47f, 0f, 0f, .99f);

        // This animation implements the Cubic-Bezier Animation
        final Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.textview_animation);
        anim.setInterpolator(customInterpolator);

        artCloud.animate().alpha(1f).setDuration(ImageAnimationDuration).setListener(null);
        artWork.animate().alpha(1f).setDuration(ImageAnimationDuration).setListener(null);

        helloText.setAnimation(anim);
        helloText.animate().alpha(1f).setStartDelay(4000).setDuration(TextAnimationDuration).setListener(null);

        isText.setAnimation(anim);
        isText.animate().alpha(1f).setStartDelay(4000).setDuration(TextAnimationDuration).setListener(null);

        yourText.setAnimation(anim);
        yourText.animate().alpha(1f).setStartDelay(4000).setDuration(TextAnimationDuration).setListener(null);

        ownText.setAnimation(anim);
        ownText.animate().alpha(1f).setStartDelay(4000).setDuration(TextAnimationDuration).setListener(null);

        privateText.setAnimation(anim);
        privateText.animate().alpha(1f).setStartDelay(4000).setDuration(TextAnimationDuration).setListener(null);

        cloudText.setAnimation(anim);
        cloudText.animate().alpha(1f).setStartDelay(4000).setDuration(TextAnimationDuration).setListener(null);

        oneText.setAnimation(anim);
        oneText.animate().alpha(1f).setStartDelay(4000).setDuration(TextAnimationDuration).setListener(null);

        stepText.setAnimation(anim);
        stepText.animate().alpha(1f).setStartDelay(4000).setDuration(TextAnimationDuration).setListener(null);

        anim.setStartOffset(2000);
        awayText.setAnimation(anim);
        awayText.animate().alpha(1f).setStartDelay(4000).setDuration(TextAnimationDuration).setListener(null);


        swipeText.animate()
                .alpha(1f)
                .setDuration(TextAnimationDuration)
                .setStartDelay(4500)
                .setListener(null);

        return view;
    }
}