package com.xiayu.touchevent;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;

/**
 * Created by Administrator on 2017/6/3.
 */

public class ViewB extends View {

    private static final String TAG = "ViewB";
    private int mDirection = 0;
    public ViewB(Context context) {
        super(context);
    }

    public ViewB(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewB(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "dispatchTouchEvent-ACTION_DOWN..." + event.getAction());
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "dispatchTouchEvent-ACTION_UP..." + event.getAction());
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "onTouchEvent-ACTION_DOWN..." + event.getAction());
                break;
            case MotionEvent.ACTION_UP:

           /*     mX = (int)event.getX();
                mY = (int)event.getY();*/
                mX = getLeft();
                mY = getTop();
                Log.i(TAG, "onTouchEvent-ACTION_UP..." + "mX:"+mX+"   mY:"+mY);

                if(mDirection == 0){
                    mDirection = 1;

                }else{
                    mDirection = 0;

                }
                break;
            default:
                break;
        }
        //return super.onTouchEvent(event);
        return true;
    }

    private int mParentWidth;
    private int mParentHeight;
    private int mWidth;
    private int mHeight;
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        View pareview = (View)getParent();
        mWidth = w;
        mHeight = h;
        mParentWidth = pareview.getWidth() - mWidth;
        startAnimator(new BounceInterpolator(),mParentWidth);
    }


    private ValueAnimator mAnimator;
    private void startAnimator(Interpolator interpolator, int distance) {
        mAnimator = ValueAnimator.ofInt(0,distance);
        mAnimator.setDuration(5000);
        mAnimator.setRepeatCount(100);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int distance = (Integer) animation.getAnimatedValue();
                onUpdate(distance);
            }
        });
        mAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {}

            @Override
            public void onAnimationRepeat(Animator animation) {}

            @Override
            public void onAnimationEnd(Animator animation) {
                //cleanupAnimation();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                //cleanupAnimation();
            }
        });
        mAnimator.setInterpolator(interpolator);
        mAnimator.start();
    }

    private int mX=0;
    private int mY=0;
    private void onUpdate(int distance){


        if(mDirection == 0 ) {
            Log.d(TAG, "onUpdate: mX:"+ mX+"   mY:"+mY +"  distance:"+distance+"  distance + mWidth:"+(distance + mWidth) + "   mHeight:"+mHeight);
            layout(distance, mY, distance + mWidth, mY+mHeight);
        }else{
            Log.d(TAG, "onUpdate: mX:"+ mX+"   mY:"+mY +"  distance:"+distance+"   mWidth:"+ mWidth + "distance+mHeight:"+(distance+mHeight));

            layout(mX, distance, mX+mWidth, distance+mHeight);

        }

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       // setMeasuredDimension(100| MeasureSpec.EXACTLY,100| MeasureSpec.EXACTLY);

        Log.d(TAG, "onMeasure: width:"+MeasureSpec.getSize(widthMeasureSpec)+
                "  hight:"+MeasureSpec.getSize(heightMeasureSpec));
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec),MeasureSpec.getSize(heightMeasureSpec));
        //setMeasuredDimension(50,50);
    }


}
