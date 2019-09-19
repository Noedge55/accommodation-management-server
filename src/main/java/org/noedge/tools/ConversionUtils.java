package org.noedge.tools;

import java.io.UnsupportedEncodingException;

/**
 * @Description:
 */
public class ConversionUtils {
    public static Object returnZero(Object object){
        if(null == object){
            return 0;
        }
        return object;
    }

    public static String  toUTF8Str(String str) throws UnsupportedEncodingException {
        return new String(str.getBytes("ISO-8859-1"),"UTF-8");
    }
}
