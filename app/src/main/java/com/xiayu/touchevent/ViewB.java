package com.xiayu.touchevent;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2017/6/3.
 */

public class ViewB extends View {

    private static final String TAG = "ViewB";
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
                Log.i(TAG, "onTouchEvent-ACTION_UP..." + event.getAction());
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
        //return true;
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
