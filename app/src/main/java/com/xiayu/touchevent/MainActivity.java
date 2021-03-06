package com.xiayu.touchevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TestButton testBtn = (TestButton)findViewById(R.id.testbutton);

        testBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i(TAG, "testBtn---onClick...");
            }
        });
        testBtn.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.i(TAG, "testBtn-onTouch-ACTION_DOWN...");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i(TAG, "testBtn-onTouch-ACTION_UP...");
                        break;
                    default:break;

                }
                return false;
            }
        });


        TestLinearLayout testLinelayout = (TestLinearLayout)findViewById(R.id.linearlayout_test);
        testLinelayout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.i(TAG, "testLinelayout-onTouch-ACTION_DOWN...");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i(TAG, "testLinelayout-onTouch-ACTION_UP...");
                        break;
                    default:break;

                }
                return false;
            }
        });

        testLinelayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i(TAG, "testLinelayout---onClick...");
            }
        });

    }


    public boolean dispatchTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        switch(ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "MainActivity-dispatchTouchEvent-ACTION_DOWN..." + ev.getAction());
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "MainActivity-dispatchTouchEvent-ACTION_UP..."+ ev.getAction());
                break;
            default:break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "MainActivity-onTouchEvent-ACTION_DOWN..."+ event.getAction());
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "MainActivity-onTouchEvent-ACTION_UP..."+ event.getAction());
                break;
            default:break;
        }
        return super.onTouchEvent(event);
    }
}
