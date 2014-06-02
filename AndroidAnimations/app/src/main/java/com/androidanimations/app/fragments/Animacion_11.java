package com.androidanimations.app.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidanimations.app.R;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.AnimatorSet;

public class Animacion_11 extends Fragment {

    private View rootView;
    private Activity activity;
    private AnimationDrawable animation;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_anim_gif, container, false);

        ImageView imagen = (ImageView) rootView.findViewById(R.id.imagen1);
        imagen.setBackgroundResource(R.drawable.anim_gif);
        animation = (AnimationDrawable)imagen.getBackground();
        animation.start();

        final AnimatorSet set = new AnimatorSet();

        set.playSequentially(
                ObjectAnimator.ofFloat(imagen, "rotation",360)
        );

        set.setDuration(3000).start();

        return rootView;
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        this.activity = activity;
    }
}
