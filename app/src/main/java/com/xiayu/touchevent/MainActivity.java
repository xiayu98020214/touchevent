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

    }


    public boolean dispatchTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        switch(ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "MainActivity-dispatchTouchEvent-ACTION_DOWN...");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "MainActivity-dispatchTouchEvent-ACTION_UP...");
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
                Log.i(TAG, "MainActivity-onTouchEvent-ACTION_DOWN...");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "MainActivity-onTouchEvent-ACTION_UP...");
                break;
            default:break;
        }
        return super.onTouchEvent(event);
    }
}
