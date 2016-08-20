package com.youloft.icalanderdemo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Administrator on 2016/8/19.
 */
public class CalanderCaculate {

    private static final  CalanderCaculate calanderCaculate=new CalanderCaculate();
    public  static CalanderCaculate getInstance(){
        return calanderCaculate;
    }
    public int  getFirstWeekOfMonth(int year,int month) throws ParseException {
        Calendar nowDate = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //'2010-08-10'这是自己输入的需要计算的年月日
        nowDate.setTime(sdf.parse(Integer.toString(year)+"-"+Integer.toString(month)+"-01"));
        int dayone = nowDate.get(Calendar.DAY_OF_WEEK)-1;
        return  dayone;
    }


    public int getDaysOfMonth(int year,int month){
        int days[]={31,31,28,31,30,31,30,31,31,30,31,30,31};
        if(2==month && 0==(year%4) && (0!=(year%100) || 0==(year%400))){
            //判断闰年，当   month=2   时才判断，以减少计算量
            days[2]=29;
        }
        return days[month];
    }
}
