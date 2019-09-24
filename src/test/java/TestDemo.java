import com.alibaba.fastjson.JSON;
import com.mysql.cj.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.noedge.domain.Hostel;
import org.noedge.domain.LoginStatus;
import org.noedge.domain.Room;
import org.noedge.service.*;
import org.noedge.tools.MyDateFomat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
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

    @Autowired
    private PermissionService permissionService;
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
        logger.info(String.valueOf(hostelService.addHostel(hostel,1)));
        logger.info(String.valueOf(hostel.getId()));
    }

    @Test
    public void insertRoomTest(){
        Room room = new Room();
        room.setName("男生4人间");
        room.setTotalNum(4);
        room.setHostelId(13);
        room.setCreateTime("2019-09-12 15:21:00");
        room.setUpdateTime("2019-09-12 15:21:00");
        room.setCreatePId(1);
        room.setLastUpdatePId(1);
        if (permissionService.judgePermission(1, 13)) {
            logger.info("权限通过");
             if(roomService.addRoom(room)){
                logger.info("添加房间成功");
             }
        }
    }

    @Test
    public void testDateDiff() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long a = sdf.parse("2018-08-01").getTime();
        long b = sdf.parse("2018-09-01").getTime();
        logger.info(String.valueOf((int)((b-a)/(1000 * 60 * 60 * 24))));
    }
}
