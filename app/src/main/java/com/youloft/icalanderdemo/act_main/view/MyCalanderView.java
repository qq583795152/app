package com.youloft.icalanderdemo.act_main.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.youloft.icalanderdemo.util.CalanderCaculate;
import com.youloft.icalanderdemo.util.ViewCaculate;

import java.text.ParseException;
import java.util.Calendar;

/**
 * Created by Administrator on 2016/8/19.
 */
public class MyCalanderView extends View {
    Paint paintDate;
    private  int viewWith;
    private  int viewHeight;
    private  int monthDay=30;
    private  int currentWeek=4;
    private  int itemWith;
    private  int itemHeight;
    private  int totalWeek;
    private  int beginX;
    private  int beginY;
    private  int textSize;
    private  int year;
    private  int month;
    private  int day;


    public MyCalanderView(Context context) {
        super(context);
        initpaint();
    }

    public MyCalanderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initpaint();

    }

    private void initpaint() {
        paintDate=new Paint();
        paintDate.setColor(Color.WHITE);
        //paintDate.setStyle(Paint.Style.FILL);
        paintDate.setStyle(Paint.Style.STROKE);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(widthMeasureSpec, MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(heightMeasureSpec/2), MeasureSpec.EXACTLY));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWith=w;
        System.out.println(w+"<------with");
        System.out.println(viewWith);
        viewHeight=h;
        System.out.println(viewHeight+"<------height");
        try {
            initParameter();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void initParameter() throws ParseException {
        Calendar now = Calendar.getInstance();
         year=now.get(Calendar.YEAR);
         month=now.get(Calendar.MONTH) + 1;
         day=now.get(Calendar.DAY_OF_MONTH);

        totalWeek=ViewCaculate.getInstance().lineCaculate(currentWeek,monthDay)+1;
        itemWith=viewWith/7;
        itemHeight=viewHeight/(totalWeek);
        beginX=itemWith/3;
        beginY=itemHeight/2;
        textSize=itemWith/3;
        monthDay= CalanderCaculate.getInstance().getDaysOfMonth(year,month);
        currentWeek=CalanderCaculate.getInstance().getFirstWeekOfMonth(year,month);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //设置行列定位点坐标
        int drawColumn=(currentWeek+1)>7?1:(currentWeek+1);
        int drawLine=1;
        paintDate.setTextSize(textSize);
        for(int i=0;i<monthDay;i++)
        {

          if (i>=9)
          {
              if (i+1==day){
                  paintDate.setColor(Color.RED);
                  canvas.drawText(Integer.toString(i+1),(drawColumn-1)*itemWith+beginX,(drawLine-1)*itemHeight+beginY,paintDate);
                  paintDate.setColor(Color.BLACK);
              }
              else {
                  canvas.drawText(Integer.toString(i+1),(drawColumn-1)*itemWith+beginX,(drawLine-1)*itemHeight+beginY,paintDate);
              }

          }
            else {
              if (i+1==day){
                  paintDate.setColor(Color.RED);
                  canvas.drawText(Integer.toString(i+1), ((drawColumn-1)*itemWith+beginX+beginX*2/5),(drawLine-1)*itemHeight+beginY,paintDate);
                  paintDate.setColor(Color.BLACK);
              }
              else
              {
                  canvas.drawText(Integer.toString(i+1), ((drawColumn-1)*itemWith+beginX+beginX*2/5),(drawLine-1)*itemHeight+beginY,paintDate);
              }

          }

            System.out.println("line  "+drawLine+"column  "+drawColumn);


            if (drawColumn==7)
            {
                drawLine++;
                drawColumn=1;
            }
            else {
                drawColumn++;
            }

        }


    }
}
