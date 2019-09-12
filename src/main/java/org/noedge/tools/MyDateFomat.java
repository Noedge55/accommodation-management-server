package org.noedge.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Description:日期工具类
 */
public class MyDateFomat  {
    private static Logger  logger = LoggerFactory.getLogger(MyDateFomat.class);
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    private static final String datePattern = "yyyy-MM-dd";
    private static final String timePattern = "yyyy-MM-dd HH:mm:ss";

    /**
     * 判断date格式是否(yyyy-MM-dd)
     * @param date
     * @return
     */
    public static boolean isFormatDate(String date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            logger.error("",e);
            return false;
        }
    }

    /**
     * 判断time格式是否(yyyy-MM-dd HH:mm:ss)
     * @param time
     * @return
     */
    public static boolean isFormatTime(String time){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            dateFormat.parse(time);
            return true;
        } catch (ParseException e) {
            logger.error("",e);
            return false;
        }
    }

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
