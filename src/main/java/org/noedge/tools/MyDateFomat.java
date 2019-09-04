package org.noedge.tools;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description:
 */
public class MyDateFomat  {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    private static final String datePattern = "yyyy-MM-dd";
    private static final String timePattern = "yyyy-MM-dd HH:mm:ss";

    public static String formatDate(){
        simpleDateFormat.applyPattern(datePattern);
        return simpleDateFormat.format(new Date());
    }

    public static String formatTime(){
        simpleDateFormat.applyPattern(timePattern);
        return simpleDateFormat.format(new Date());
    }

    public static String formatThisWeekMonday(){
        Calendar cal = Calendar.getInstance();
        int thisDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int mondayOfweek = 2;
        int differenceDay = 0;
        if(thisDayOfWeek == 1){
            differenceDay = -6;
        }else {
            differenceDay = 2-mondayOfweek;
        }
        cal.add(Calendar.DATE,differenceDay);
        simpleDateFormat.applyPattern(datePattern);
        return simpleDateFormat.format(cal.getTime());
    }

    public static String formatThisWeekSunday(){
        Calendar cal = Calendar.getInstance();
        int thisDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int sundayOfWeek = 8;
        cal.add(Calendar.DATE,sundayOfWeek-thisDayOfWeek);
        simpleDateFormat.applyPattern(datePattern);
        return simpleDateFormat.format(cal.getTime());
    }

    public static String formatThisMonthFirstDay(){
        Calendar cal = Calendar.getInstance();
        int thisDayOfMonth = cal.get(Calendar.DAY_OF_MONTH) - 1;
        int differenceDay = -(thisDayOfMonth - 1);

        cal.add(Calendar.DATE,differenceDay);
        simpleDateFormat.applyPattern(datePattern);
        return simpleDateFormat.format(cal.getTime());
    }

    public static String formatThisMonthLastDay(){
        Calendar cal = Calendar.getInstance();
        int maxDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DATE,maxDayOfMonth);
        simpleDateFormat.applyPattern(datePattern);
        return simpleDateFormat.format(cal.getTime());
    }
}
