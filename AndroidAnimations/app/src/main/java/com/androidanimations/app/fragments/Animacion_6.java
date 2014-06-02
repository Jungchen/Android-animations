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
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

public class Animacion_6 extends Fragment {

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


        final AnimatorSet set = new AnimatorSet();
        final AnimatorSet set2 = new AnimatorSet();

        set.playTogether(
                ObjectAnimator.ofFloat(imagen5, "scaleX", 1, 0.5f),
                ObjectAnimator.ofFloat(imagen5, "scaleY", 1, 0.5f)
        );

        set2.playTogether(
                ObjectAnimator.ofFloat(imagen5,"scaleX", 0.5f, 1),
                ObjectAnimator.ofFloat(imagen5,"scaleY", 0.5f, 1)
        );

        set2.setStartDelay(1000);

        imagen5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set.setDuration(1000).start();
                set2.setDuration(1000).start();
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
