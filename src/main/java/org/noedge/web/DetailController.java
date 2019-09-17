package org.noedge.web;

import org.noedge.dao.RoomDao;
import org.noedge.domain.Person;
import org.noedge.domain.Result;
import org.noedge.tools.MyDateFomat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 */
@RestController
public class DetailController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoomDao roomDao;
    @RequestMapping(value = "/getRoomList")
    public Result getRoomList(HttpServletRequest request, @RequestParam Map<String,String> reqParam){
        String hostelIdStr = reqParam.get("hostelId");
        String date = reqParam.get("date");
        if(StringUtils.isEmpty(hostelIdStr)){
            return Result.getResult(-1,"旅社id不能为空",null);
        }
        Integer hostelId ;
        try {
            hostelId = NumberUtils.parseNumber(hostelIdStr,Integer.class);
        }catch (IllegalArgumentException e){
            logger.error("",e);
            return Result.getResult(-2,"id必须为数字",null);
        }
        if(StringUtils.isEmpty(date)){
            date = MyDateFomat.formatDate();
        }else if(!MyDateFomat.isFormatDate(date)){
            return Result.getResult(-3,"日期格式错误(yyyy-MM-dd)",null);
        }

        Map param = new HashMap();
        param.put("hostelId",hostelId);
        param.put("date",date);
        List<Map> list =  roomDao.selectRoomListByHostelIdAndDate(param);
        return Result.getResult(0,"success",list);
    }

    @RequestMapping(value = "/getCheckInRoomByOrderId")
    public Result getCheckInRoomByOrderId(@RequestParam Map<String,String> reqParam){

        String orderIdStr = reqParam.get("orderId");
        if(StringUtils.isEmpty(orderIdStr)){
            return Result.getResult(-1,"参数不能为空",null);
        }

        Integer orderId ;
        try {
            orderId = NumberUtils.parseNumber(orderIdStr,Integer.class);
        }catch (IllegalArgumentException e){
            logger.error("",e);
            return Result.getResult(-2,"id必须为数字",null);
        }
        List<Map> list = roomDao.selectCheckInRoomByOrderId(orderId);
        return Result.getResult(0,"success",list);
    }
}
