package com.example.person.gameking.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.person.gameking.R;

/**
 * !Created by Administrator on 2018/3/3.
 */

public class BattleView extends FrameLayout {
    int width;
    int height;
    Bitmap cardImage;

    public BattleView(Context context) {
        super(context);
        init();
    }

    public BattleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BattleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        cardImage = BitmapFactory.decodeResource(getResources(), R.drawable.abc);

        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 36, metrics);
        height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, metrics);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            if (view instanceof CardView) {
                CardView child = (CardView) getChildAt(i);
                int left = l + child.getIndexX() * width;
                int top = t + child.getIndexY() * height;
                child.layout(left, top, left + width, top + height);
            }
        }
    }

    public void addCard(CardView view) {
        addView(view);
        postInvalidate();
    }
}
