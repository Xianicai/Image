package com.example.lenovo.kuaikan.utils;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

/**
 * Created by Zhanglibin on 2017/4/23.
 */

public class Animators {
    /**
     * 点赞的动画
     * */
    public static void doLikeAnimator(final ImageView imageView, final RecyclerView.Adapter adapter){
        PropertyValuesHolder pvhA = PropertyValuesHolder.ofFloat("alpha", 0f,
                1f);
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("scaleX", 0f,
                1.5f, 1f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleY", 0f,
                1.5f, 1f);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(imageView, pvhA, pvhX, pvhY).setDuration(800);
        animator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(android.animation.Animator animation) {
                adapter.notifyDataSetChanged();
            }

        });

        animator.start();
    }
}
