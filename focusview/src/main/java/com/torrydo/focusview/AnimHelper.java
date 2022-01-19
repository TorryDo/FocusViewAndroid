package com.torrydo.focusview;

import android.view.View;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

class AnimHelper {


        public static void startSpringX(
                float startValue,
                float position,
                AnimationListener animationListener   // an interface
        ) {

            SpringAnimation spring = new SpringAnimation(new FloatValueHolder());

            SpringForce springForce = new SpringForce()
//                    .setStartValue(startValue)
                    .setStiffness(SpringForce.STIFFNESS_LOW)
                    .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
                    .setFinalPosition(position);

            spring.setStartValue(startValue)
                    .addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
                        @Override
                        public void onAnimationUpdate(DynamicAnimation animation, float value, float velocity) {
                            animationListener.onAnimate();
                        }
                    })
                    .addEndListener(new DynamicAnimation.OnAnimationEndListener() {
                        @Override
                        public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                            animationListener.onFinish();
                        }
                    });

            spring.setSpring(springForce);
            spring.start();
        }

        public static void startFlingX(
                View view,
                float startVelocity,
                Float position,
                AnimationListener animationListener   // an interface
        ) {

            FlingAnimation flingAnimation = new FlingAnimation(view, DynamicAnimation.SCALE_X);
            flingAnimation.setStartValue(startVelocity);
            flingAnimation.setMinValue(0f);
            flingAnimation.setMaxValue(position);
            flingAnimation.setFriction(1.1f);
            flingAnimation.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() {
                @Override
                public void onAnimationUpdate(DynamicAnimation animation, float value, float velocity) {
                    animationListener.onAnimate();
                }
            });

            flingAnimation.start();


        }



}
