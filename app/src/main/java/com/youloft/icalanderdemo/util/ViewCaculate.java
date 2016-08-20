package com.youloft.icalanderdemo.util;

/**
 * Created by Administrator on 2016/8/19.
 */
public class ViewCaculate {
    //饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的。
    private static final  ViewCaculate caculate=new ViewCaculate();
    public int lineCaculate(int currentWeek,int MonthDay)
    {

            //last最后一周非满周剩下的天数，full为满周的周数
            int last=(MonthDay+currentWeek-8)%7;
            int full=(MonthDay+currentWeek-8)/7;
        if(last!=0)
        {
            return full+2;
        }
        else
        {
            return full+1;
        }
    }
    public static ViewCaculate getInstance(){
        return caculate;
    }
}
