import com.alibaba.fastjson.JSON;
import com.mysql.cj.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noedge.domain.LoginStatus;
import org.noedge.service.BusinessService;
import org.noedge.service.IncomeExpenditureBillService;
import org.noedge.tools.MyDateFomat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:spring-context.xml"})
public class TestDemo {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
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

    @Autowired
    private BusinessService businessService;
    @Autowired
    private IncomeExpenditureBillService incomeExpenditureBillService;
    @Test
    public void getTodayLivingNumByHostelIdTest(){
        List<Integer> hostelIds = new ArrayList<Integer>() ;
        hostelIds.add(1);
        Map<Integer,Map<String,Integer>> map = businessService.getTodayLivingNumByHostelIds(hostelIds, MyDateFomat.formatDate());
        logger.info(map.toString());
    }

    @Test
    public void getBillStatisticsTest(){
        Map<String,Object> param2 = new HashMap<>();
        param2.put("personId",1);
        param2.put("dateType","all");
        param2.put("hostelId",1);
//        param2.put("startDate",startDate);
//        param2.put("endDate",endDate);
//        param2.put("page",page);
//        List<Map> list = incomeExpenditureBillService.getBillStatistics(param2);

//        logger.info(list.toString());

    }
}
