package com.example.onboardingfold.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.onboardingfold.R;

public class OnboardingPage1Fragment extends Fragment {

    // store the page number
    private int pageNumber;

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
        return view;
    }
}
