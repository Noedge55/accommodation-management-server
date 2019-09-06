package org.noedge.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @Description:
 */
public class MyDecimalFomart {
    private static Logger logger = LoggerFactory.getLogger(MyDecimalFomart.class);


    public static double formatTwoScalesRoundHalfUp(double num){
        return new BigDecimal(num).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    public static double formatTwoScalesRoundHalfUp(String numStr){
        double num = 0.00;
        try{
            if(null != numStr && !"".equals(numStr)){
                num = Double.valueOf(numStr);
            }
        }catch (NumberFormatException e){
            logger.error("原类型无法转换成数字",e);
        }
        return new BigDecimal(num).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
