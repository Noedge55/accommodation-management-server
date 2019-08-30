package org.noedge.tools;

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
}
