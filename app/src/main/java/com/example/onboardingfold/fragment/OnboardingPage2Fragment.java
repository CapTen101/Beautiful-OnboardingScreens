package com.example.onboardingfold.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.onboardingfold.R;

public class OnboardingPage2Fragment extends Fragment {

    // a newInstance constructor for assigning a page no. to each of the onboarding pages
    public static Fragment newInstance(int pageNumber) {
        OnboardingPage2Fragment fragmentFirst = new OnboardingPage2Fragment();
        Bundle args = new Bundle();
        args.putInt("PageNumberofThis", pageNumber);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.onboarding_item2, container, false);



        return view;
    }
}
