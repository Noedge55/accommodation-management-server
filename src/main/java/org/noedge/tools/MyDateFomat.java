package org.noedge.tools;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
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
}
