package com.example.person.gameking.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * !Created by Administrator on 2018/3/3.
 */

public class BattleView extends FrameLayout {


    private int riverH = 50;//河道高度
    private int gridSize = 10;//格子大小
    private int gridDistanceH = 50;//格子间高度
    private int distance = 100;//魔法与怪兽间高度
    private int paddingLeft = 0;
    private int paddingTop = 0;
    private int paddingRight = 0;
    private int paddingButtom = 0;
    private int[] beastOpponentOne;
    private int[] beastOpponentTwo;
    private int[] beastOpponentThree;
    private int[] beastOpponentFour;
    private int[] beastOpponentFive;

    private int[] beastOne;
    private int[] beastFive;
    private int[] beastTwo;
    private int[] beastThree;
    private int[] beastFour;
    private int[] magicOpponentOne;
    private int[] magicOpponentTwo;
    private int[] magicOpponentThree;
    private int[] magicOpponentFour;
    private int[] magicOpponentFive;
    private int[] magicOne;
    private int[] magicTwo;
    private int[] magicThree;
    private int[] magicFour;
    private int[] magicFive;

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

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paddingLeft=getPaddingLeft();
        paddingRight=getPaddingRight();
        paddingTop=getPaddingTop();
        paddingButtom=getPaddingBottom();

        int height = getMeasuredHeight();//view的高度
        int width = getMeasuredWidth();//view的宽度
        int riverY = height/2-riverH/2+paddingTop;//河道y轴坐标
        int fieldH = riverY-paddingTop;//场上高度
        int fieldW = width-paddingRight-paddingLeft;//场上宽度
        int centerX = width/2;//x轴中心宽度



        //绘制格子
        Paint paint = new Paint();
        //beast区
        paint.setColor(Color.YELLOW);
        //opponent
        beastOpponentOne = drawGrid(canvas,paint,centerX,fieldH-riverH);
        beastOpponentTwo = drawGrid(canvas,paint,fieldW/2/2+paddingLeft,beastOpponentOne[1]- gridDistanceH);
        beastOpponentThree = drawGrid(canvas,paint,centerX+(fieldW/2/2),beastOpponentTwo[1]);
        beastOpponentFour = drawGrid(canvas,paint,paddingLeft,beastOpponentThree[1]- gridDistanceH);
        beastOpponentFive = drawGrid(canvas,paint,fieldW+paddingRight,beastOpponentThree[1]- gridDistanceH);
        //me
        beastOne = drawGrid(canvas,paint,centerX,fieldH+riverH);
        beastTwo = drawGrid(canvas,paint,fieldW/2/2+paddingLeft,beastOne[1]+ gridDistanceH);
        beastThree = drawGrid(canvas,paint,centerX+(fieldW/2/2),beastTwo[1]);
        beastFour = drawGrid(canvas,paint,paddingLeft,beastThree[1]+ gridDistanceH);
        beastFive = drawGrid(canvas,paint,fieldW+paddingRight,beastFour[1]);
        //magic区
        paint.setColor(Color.BLUE);
        //opponent
        magicOpponentOne = drawGrid(canvas,paint,beastOpponentOne[0],beastOpponentOne[1]-distance);
        magicOpponentTwo = drawGrid(canvas,paint,beastOpponentTwo[0],beastOpponentTwo[1]-distance);
        magicOpponentThree = drawGrid(canvas,paint,beastOpponentThree[0],beastOpponentThree[1]-distance);
        magicOpponentFour = drawGrid(canvas,paint,beastOpponentFour[0],beastOpponentFour[1]-distance);
        magicOpponentFive = drawGrid(canvas,paint,beastOpponentFive[0],beastOpponentFive[1]-distance);
        //me
        magicOne = drawGrid(canvas,paint,beastOne[0],beastOne[1]+distance);
        magicTwo = drawGrid(canvas,paint,beastTwo[0],beastTwo[1]+distance);
        magicThree = drawGrid(canvas,paint,beastThree[0],beastThree[1]+distance);
        magicFour = drawGrid(canvas,paint,beastFour[0],beastFour[1]+distance);
        magicFive = drawGrid(canvas,paint,beastFive[0],beastFive[1]+distance);

    }

    /**
     *绘制格子并返回xy坐标
     * @param canvas
     * @param paint
     * @param x
     * @param y
     */
    private int[] drawGrid(Canvas canvas,Paint paint,int x,int y) {

        canvas.drawCircle(x,y,gridSize, paint);
        return new int[]{x,y};

    }
}
