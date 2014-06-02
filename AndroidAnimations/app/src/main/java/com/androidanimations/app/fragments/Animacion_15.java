package com.androidanimations.app.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.androidanimations.app.R;

public class Animacion_15 extends Fragment {

    private View rootView;
    private Activity activity;
    private AnimationDrawable animation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_animacion_15, container, false);

        final Button boton = (Button)rootView.findViewById(R.id.boton);

        final Animation vibrar = AnimationUtils.loadAnimation(activity, R.anim.animacion_vibracion);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boton.startAnimation(vibrar);
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        this.activity = activity;
    }
}