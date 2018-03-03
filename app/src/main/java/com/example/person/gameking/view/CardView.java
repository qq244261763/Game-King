package com.example.person.gameking.view;

import android.content.Context;

import com.example.person.gameking.R;

/**
 * !Created by Administrator on 2018/3/3.
 */

public class CardView extends android.support.v7.widget.AppCompatImageView {
    private int indexX, indexY;

    public CardView(Context context, int x, int y) {
        super(context);
        this.indexX = x;
        this.indexY = y;
        setScaleType(ScaleType.CENTER_CROP);
        setImageResource(R.drawable.abc);
    }

    public int getIndexX() {
        return indexX;
    }

    public int getIndexY() {
        return indexY;
    }
}
