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
import android.widget.ImageView;
import com.androidanimations.app.R;

public class Animacion_5 extends Fragment {

    private View rootView;
    private Activity activity;
    private AnimationDrawable animation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_anim_gif, container, false);

        final ImageView imagen5 = (ImageView) rootView.findViewById(R.id.imagen1);
        imagen5.setBackgroundResource(R.drawable.anim_gif2);
        animation = (AnimationDrawable)imagen5.getBackground();
        animation.start();
        final Animation pulse = AnimationUtils.loadAnimation(activity, R.anim.animacion_pulsacion);

        imagen5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagen5.startAnimation(pulse);
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
