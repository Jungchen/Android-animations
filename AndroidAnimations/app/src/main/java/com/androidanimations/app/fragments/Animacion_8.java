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
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.AnimatorSet;

public class Animacion_8 extends Fragment {

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
        final AnimatorSet set2 = new AnimatorSet();

        ObjectAnimator animator = ObjectAnimator.ofFloat(imagen, "translationY",-450, 450);
        animator.setRepeatMode(ObjectAnimator.INFINITE);
        animator.setRepeatCount(-1);

        set.playSequentially(
                ObjectAnimator.ofFloat(imagen, "translationY",0,450)
        );

        set2.play(
                animator
        );

        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                set2.setDuration(3000).start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        set.setDuration(3000).start();

        return rootView;
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        this.activity = activity;
    }
}
