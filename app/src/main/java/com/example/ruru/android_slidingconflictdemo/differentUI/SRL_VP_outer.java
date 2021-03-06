package com.example.ruru.android_slidingconflictdemo.differentUI;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

import java.lang.reflect.Field;

public class SRL_VP_outer extends SwipeRefreshLayout {
    public SRL_VP_outer(Context context) {
        super(context);
    }

    public SRL_VP_outer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            super.onInterceptTouchEvent(ev);
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//        super.requestDisallowInterceptTouchEvent(b);
        Class cls = ViewGroup.class;
        try {
            Field field = cls.getField("mGroupFlags");
            int c = (int) field.get(this);
            if (disallowIntercept) {
                field.set(this, 2900051);
            } else {
                field.set(this, 2245715);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
