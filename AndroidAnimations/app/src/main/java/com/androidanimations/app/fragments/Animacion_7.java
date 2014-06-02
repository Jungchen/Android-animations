package com.androidanimations.app.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.androidanimations.app.R;
import com.nineoldandroids.animation.ArgbEvaluator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;

public class Animacion_7 extends Fragment {

    private View rootView;
    private Activity activity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_anim_gif, container, false);

        FrameLayout layout = (FrameLayout) rootView.findViewById(R.id.layout);
        layout.addView(new AnimationBackground(activity));

        return rootView;
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        this.activity = activity;
    }



    public class AnimationBackground extends View {

        private static final int BLUE = 0xff8080FF;
        private static final int GREEN = 0xff80ff80;

        public AnimationBackground(Context context) {

            super(context);

            ValueAnimator colorAnim = ObjectAnimator.ofInt(context, "backgroundColor", GREEN, BLUE);
            colorAnim.setDuration(3000);
            colorAnim.setEvaluator(new ArgbEvaluator());
            colorAnim.setRepeatCount(ValueAnimator.INFINITE);
            colorAnim.setRepeatMode(ValueAnimator.REVERSE);
            colorAnim.start();
        }

        protected void onDraw(Canvas canvas) {
                canvas.save();
                canvas.restore();
        }
    }
}
