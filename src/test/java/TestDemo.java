import com.alibaba.fastjson.JSON;
import com.mysql.cj.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noedge.domain.Hostel;
import org.noedge.domain.LoginStatus;
import org.noedge.service.BusinessService;
import org.noedge.service.HostelService;
import org.noedge.service.IncomeExpenditureBillService;
import org.noedge.service.RoomService;
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

    @Autowired
    private RoomService roomService;

    @Autowired
    private HostelService hostelService;
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
        param2.put("dateType","today");
        param2.put("hostelId",1);
        param2.put("startDate","2019-01-01");
        param2.put("endDate","2019-10-01");
//        param2.put("page",page);
        Map<Integer,Double> list = incomeExpenditureBillService.getBillStatistics(param2);
        System.out.println(list);

//        logger.info(list.toString());

    }

    @Test
    public void selectRoomListByHostelIdAndDateTest(){
        Map<String,Object> param2 = new HashMap<>();
        param2.put("hostelId",1);
        param2.put("date","2019-08-28");
        List<Map> list = roomService.getRoomListByHostelIdAndDate(param2);
        logger.info(list.toString());
    }

    @Test
    public void getCheckInRoomByOrderId(){
        List<Map> list = roomService.getCheckInRoomByOrderId(1);
        logger.info(list.toString());
    }

    @Test
    public void insertHostelTest(){
        Hostel hostel = new Hostel();
        hostel.setName("向往的生活");
        hostel.setArea("湖北省武汉市武昌区");
        hostel.setAddress("江汉路");
        hostel.setCreateTime("2019-09-12 15:21:00");
        hostel.setUpdateTime("2019-09-12 15:21:00");
        hostel.setCreatePId(1);
        hostel.setLastUpdatePId(1);
        logger.info(String.valueOf(hostelService.addHostel(hostel)));
        logger.info(String.valueOf(hostel.getId()));
    }
}
