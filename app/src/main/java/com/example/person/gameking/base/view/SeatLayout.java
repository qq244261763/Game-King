package com.example.person.gameking.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.RelativeLayout;

import com.example.person.gameking.R;

public class SeatLayout extends RelativeLayout {
    public SeatLayout(Context context) {
       super(context,null);
    }

    public SeatLayout(Context context, AttributeSet attrs) {
        super(context, attrs,0);
        init(context,attrs,0);

    }

    public SeatLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    private void init(Context context,AttributeSet attrs, int defStyleAttr) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SearchView, defStyleAttr, 0);
        boolean isOpponent = ta.getBoolean(R.styleable.SeatLayout_opponent,false);
        ta.recycle();
        Log.e("isOpponent",isOpponent+"");

    }

}
