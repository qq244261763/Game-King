package com.example.person.gameking.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.example.person.gameking.R;

import java.util.ArrayList;
import java.util.List;

/**
 * !Created by Administrator on 2018/3/3.
 */

public class CardHeapView extends View {
    private static final String TAG = "CardHeapView";
    private int num = 40;
    private List<Rect> rectList = new ArrayList<>();
    private Paint paint;
    private Bitmap cardBackground;
    private String text;
    private int width;
    private int height;

    public CardHeapView(Context context) {
        super(context);
        init();
    }

    public CardHeapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CardHeapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(width, (int)(80*0.4+height));
    }

    private void init() {
        paint = new Paint();
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(2);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setColor(Color.WHITE);
        paint.setTextSize(48);

        cardBackground = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_round);

        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 36, metrics);
        height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, metrics);
        Log.d(TAG, "init: " + width + "," + height);

        for (int i = 0; i < num; i++) {
            rectList.add(new Rect(0, 0, width, height));
        }
    }

    public void setText(String text) {
        this.text = text;
    }

    private void computeAllRect() {
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        int gap = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0.4f, metrics);
        for (int i = 0; i < num; i++) {
            Rect rect = rectList.get(i);
            rect.offsetTo(getMeasuredWidth() - rect.width(), getMeasuredHeight()-rect.height()-i+ gap);
        }
        Log.d(TAG, "computeAllRect: " + rectList.size());
    }

    public void setNum(int num) {
        this.num = num;
        rectList.clear();
        for (int i = 0; i < num; i++) {
            rectList.add(new Rect(0, 0, 0, 0));
        }

        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        computeAllRect();
        for (Rect rect : rectList) {
            if (cardBackground != null) {
                canvas.drawBitmap(cardBackground, null, rect, null);
            }
            Log.d(TAG, "onDraw: " + rect);
        }
        if (!TextUtils.isEmpty(text)) {
            canvas.drawText(text, 100, (getMeasuredHeight() + 48) / 2, paint);
        }
    }
}
