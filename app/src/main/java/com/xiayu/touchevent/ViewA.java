package com.xiayu.touchevent;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;

/**
 * Created by Administrator on 2017/6/3.
 */

public class ViewA extends ViewGroup {
    private static final String TAG = "ViewA";

    private View mChild;
    private int mWidth;
    private int mHeight;

    public ViewA(Context context) {
        super(context);
    }

    public ViewA(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public ViewA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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

    private void onUpdate(int distance){

        mChild.layout(distance,0,distance+mChild.getMeasuredWidth(),mChild.getMeasuredHeight());

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "dispatchTouchEvent-ACTION_DOWN..." + ev.getAction());
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "dispatchTouchEvent-ACTION_UP..." + ev.getAction());
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "onTouchEvent-ACTION_DOWN..." + event.getAction());
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "onTouchEvent-ACTION_UP..." + event.getAction());
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d(TAG, "onSizeChanged() called with: w = [" + w + "], h = [" + h + "], oldw = [" + oldw + "], oldh = [" + oldh + "]");
        mWidth = w;
        mHeight = h;
        mChild = getChildAt(0);
        int width = w - mChild.getMeasuredWidth();
        startAnimator(new BounceInterpolator(),width);

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "onInterceptTouchEvent-ACTION_DOWN..." + ev.getAction());
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "onInterceptTouchEvent-ACTION_UP..." + ev.getAction());
                break;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);

    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        Log.d(TAG, "onLayout() called with: b = [" + b + "], i = [" + i + "], i1 = [" + i1 + "], i2 = [" + i2 + "], i3 = [" + i3 + "]");
        final View child = getChildAt(0);
        Log.d(TAG, "child.getMeasuredWidth():" + child.getMeasuredWidth() + "    child.getMeasuredHeight():" + child.getMeasuredHeight());

        child.layout(0, 0, child.getMeasuredWidth(), child.getMeasuredHeight());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = getChildCount();
        final View child = getChildAt(0);
        final LayoutParams lp = child.getLayoutParams();
        child.measure(lp.width | MeasureSpec.EXACTLY, lp.height | MeasureSpec.EXACTLY);
        Log.i(TAG, "count:" + count);
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
        // setMeasuredDimension(200,200);
    }
}
