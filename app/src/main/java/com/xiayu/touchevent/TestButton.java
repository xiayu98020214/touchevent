package com.xiayu.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by 七喜 on 2017/5/24.
 */

public class TestButton extends android.support.v7.widget.AppCompatButton {
    private final static String tag = "yan";
    public TestButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "TestButton-onTouchEvent-ACTION_DOWN...");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(tag, "TestButton-onTouchEvent-ACTION_UP...");
                break;
            default:break;
        }

        boolean flag = super.onTouchEvent(event);//最底层的view，肯定返回true。
        Log.i(tag,"flag;"+flag);
        return flag;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i(tag, "TestButton-dispatchTouchEvent-ACTION_DOWN...");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(tag, "TestButton-dispatchTouchEvent-ACTION_UP...");
                break;
            default:break;
        }

        return super.dispatchTouchEvent(event);
    }

}