import com.alibaba.fastjson.JSON;
import com.mysql.cj.Session;
import org.junit.Test;
import org.noedge.domain.LoginStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 */
public class TestDemo {
    @Test
    public void loggerTest(){
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("1231");

        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("is_login", LoginStatus.NOT_LOGGED_IN);
        logger.info(JSON.toJSONString(map));
    }

    @Test
    public void clearSession(){
//        Session session =
    }
}
