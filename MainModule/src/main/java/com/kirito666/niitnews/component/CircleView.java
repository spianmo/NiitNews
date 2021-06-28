package com.kirito666.niitnews.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.kirito666.niitnews.R;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:CircleView.java
 * @LastModified:2021/06/29 02:16:29
 */

public class CircleView extends View {


    /**
     * 控件的宽度
     */
    private int mWidth;
    /**
     * 控件的高度
     */
    private int mHeight;
    /**
     * 内颜色
     */
    public int inColor;
    /**
     * 边框颜色
     */
    private int outColor;
    /**
     * 边框粗细
     */
    private int outStrokeWidth;


    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.StockManage);
        inColor = array.getColor(R.styleable.StockManage_inColor, Color.WHITE);
        outColor = array.getColor(R.styleable.StockManage_outColor, -1);
        outStrokeWidth = array.getDimensionPixelSize(R.styleable.StockManage_stroke, 0);
        mWidth = array.getDimensionPixelSize(R.styleable.StockManage_cwidth, 0);
        mHeight = array.getDimensionPixelSize(R.styleable.StockManage_cheight, 0);

        array.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(mWidth, mHeight);
    }


    @Override
    protected void onDraw(Canvas canvas) {

        int min = Math.min(mWidth, mHeight);
        canvas.drawBitmap(createCircleImage(null, min), 0, 0, null);

    }

    private Bitmap createCircleImage(Bitmap source, int min) {

        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap target = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(target);

        canvas.drawCircle(min / 2, min / 2, min / 2, paint);

        /**
         * 使用SRC_IN，参考上面的说明
         */
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        if (source != null)// 画图片
            canvas.drawBitmap(source, 0, 0, paint);
        else { // 画圆
            paint.setColor(inColor);
            canvas.drawCircle(min / 2, min / 2, min / 2, paint);
        }

        if (outColor != 0) {
            // 让画出的图形是空心的
            paint.setStyle(Paint.Style.STROKE);
            // 设置画出的线的 粗细程度
            paint.setStrokeWidth(outStrokeWidth);
            paint.setColor(outColor);
            canvas.drawCircle(min / 2, min / 2, min / 2, paint);
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1);
        paint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fm = paint.getFontMetrics();
        return target;
    }

}