package com.example.person.gameking.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.person.gameking.R;

/**
 * !Created by Administrator on 2018/3/3.
 */

public class BattleView extends FrameLayout {


    private boolean isOpponent;

    public BattleView(Context context) {
        super(context);
        init(context, null);
    }

    public BattleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BattleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BattleView);
        isOpponent = ta.getBoolean(R.styleable.BattleView_opponent,false);
        ta.recycle();
        Log.e("isOpponent", isOpponent +"");
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制格子
        int height = getMeasuredHeight();//view的高度
        int width = getMeasuredWidth();//view的宽度
        int[] one;
        int[] two;
        int[] three;
        int[] four;
        int[] five;
        if (isOpponent) {

            one = new int[]{width/2,height};
            two = new int[]{one[0]/2,height/2};
            three = new int[]{one[0]+two[0],two[1]};
            four = new int[]{0,0};
            five = new int[]{width,0};

        }else {
            one = new int[]{width/2,0};
            two = new int[]{one[0]/2,height/2};
            three = new int[]{one[0]+two[0],two[1]};
            four = new int[]{0,height};
            five = new int[]{width,height};
        }

        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(one[0],one[1],10,paint);
        canvas.drawCircle(two[0],two[1],10,paint);
        canvas.drawCircle(three[0],three[1],10,paint);
        canvas.drawCircle(four[0],five[1],10,paint);

        Log.e("one",one[1]+""+one[0]);

    }
}
