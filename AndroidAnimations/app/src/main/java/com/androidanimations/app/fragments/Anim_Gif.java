package com.androidanimations.app.fragments;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.androidanimations.app.R;

public class Anim_Gif extends Fragment {

    private View rootView;
    private Activity activity;
    private AnimationDrawable animation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_anim_gif, container, false);

        ImageView image = (ImageView) rootView.findViewById(R.id.imagen1);
        image.setBackgroundResource(R.drawable.anim_gif);
        animation = (AnimationDrawable)image.getBackground();
        animation.start();

        return rootView;
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        this.activity = activity;
    }
}