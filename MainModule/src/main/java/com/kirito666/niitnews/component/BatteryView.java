package com.kirito666.niitnews.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:BatteryView.java
 * @LastModified:2021/06/29 02:16:29
 */

public class BatteryView extends View {
    private RectF batteryRecf;
    private RectF batterCenterRecf;
    private Paint mPaint;
    private Paint mTextPaint;
    private float ratio = 0.5f;
    private int lineW = 1;
    private float lineRatio = 0.5f;
    private int textSize = 9;
    private int currentValue = 100;
    PorterDuffXfermode modeTx = new PorterDuffXfermode(PorterDuff.Mode.XOR);

    public BatteryView(Context context) {
        this(context, null);
    }

    public BatteryView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        init(context);
        mTextPaint.setXfermode(null);
    }

    private void init(Context context) {
        lineW = dip2px(context, lineW);
        batteryRecf = new RectF();
        batterCenterRecf = new RectF();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.parseColor("#4ec200"));
        mPaint.setStrokeWidth(lineW);
        mPaint.setXfermode(modeTx);
        //mPaint.setStrokeCap(Paint.Cap.ROUND);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setTextSize(dip2px(context, textSize));
        mTextPaint.setXfermode(modeTx);
        mTextPaint.setColor(Color.parseColor("#4ec200"));

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heighMode = MeasureSpec.getMode(heightMeasureSpec);
        int heighSize = MeasureSpec.getSize(heightMeasureSpec);
        int mesW, mesH;
        if (widthMode == MeasureSpec.EXACTLY) {
            mesW = widthSize;
        } else {
            mesW = dip2px(getContext(), 100);
        }

        if (heighMode == MeasureSpec.EXACTLY) {
            mesH = heighSize;
        } else {
            mesH = (int) (mesW * ratio);
        }
        setMeasuredDimension(mesW, mesH);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        float batterW = w - 2 * lineW;
        float batterH = batterW * ratio;
        batteryRecf.set(lineW / 2, (h - batterH) / 2, batterW, (h + batterH) / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        resetTextPaint();
        drawBattery(canvas);
        drawBatteryCennter(canvas);
        mTextPaint.setXfermode(modeTx);
        drawText(canvas);
        mTextPaint.setXfermode(null);
    }

    private void drawText(Canvas canvas) {
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        float top = fontMetrics.top;//为基线到字体上边框的距离,即上图中的top
        float bottom = fontMetrics.bottom;//为基线到字体下边框的距离,即上图中的bottom
        int baseLineY = (int) (batteryRecf.centerY() - top / 2 - bottom / 2);//基线中间点的y轴计算公式
        String text = getFormatText(currentValue);
        canvas.drawText(text, batteryRecf.centerX(), baseLineY, mTextPaint);
    }

    private void resetTextPaint() {
        if (currentValue >= 0 && currentValue < 10) {
            mTextPaint.setColor(Color.parseColor("#FF150C"));
            mPaint.setColor(Color.parseColor("#FF150C"));
        } else {
            mTextPaint.setColor(Color.parseColor("#00ff66"));
            mPaint.setColor(Color.parseColor("#00ff66"));
        }
        /*if (currentValue>=0 && currentValue<10){
            mTextPaint.setColor(Color.parseColor("#FF150C"));
            mPaint.setColor(Color.parseColor("#FF150C"));
        }else if( currentValue>=10 && currentValue<20 ){
            mTextPaint.setColor(Color.parseColor("#FFF04A"));
            mPaint.setColor(Color.parseColor("#FFF04A"));
        }else if( currentValue>=20 && currentValue<30 ){
            mTextPaint.setColor(Color.parseColor("#BBFF5D"));
            mPaint.setColor(Color.parseColor("#BBFF5D"));
        }else if( currentValue>=30 && currentValue<50 ){
            mTextPaint.setColor(Color.parseColor("#85FF52"));
            mPaint.setColor(Color.parseColor("#85FF52"));
        }else if( currentValue>=50 && currentValue<60 ){
            mTextPaint.setColor(Color.parseColor("#85FF52"));
            mPaint.setColor(Color.parseColor("#85FF52"));
        }else if( currentValue>=60 && currentValue<80 ){
            mTextPaint.setColor(Color.parseColor("#44FF43"));
            mPaint.setColor(Color.parseColor("#44FF43"));
        }else if( currentValue>=80 && currentValue<90 ){
            mTextPaint.setColor(Color.parseColor("#44FF43"));
            mPaint.setColor(Color.parseColor("#44FF43"));
        }else if( currentValue>=90 && currentValue<=100 ){
            mTextPaint.setColor(Color.parseColor("#40FF43"));
            mPaint.setColor(Color.parseColor("#40FF43"));
        }*/
    }


    private void drawBattery(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(batteryRecf, 6, 6, mPaint);
        float H = batteryRecf.height();
        float line = H * lineRatio;
        float top = batteryRecf.top;
        canvas.drawLine(batteryRecf.right + lineW, top + (H - line) / 2, batteryRecf.right + lineW, top + (H + line) / 2, mPaint);
    }

    private void drawBatteryCennter(Canvas canvas) {
        batterCenterRecf.set(batteryRecf);
        batterCenterRecf.right = batteryRecf.width() * currentValue / 100;
        canvas.drawRect(batterCenterRecf, mTextPaint);
    }

    public void setCurrentValue(int value) {
        this.currentValue = value;
        invalidate();
    }

    public void setCurrentValue(String text) {
        this.currentValue = Integer.parseInt(text);
        invalidate();
    }

    private static int dip2px(Context context, int dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    private String getFormatText(int value) {
        return "" + value + "%";
    }
}