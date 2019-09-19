package org.noedge.web;

import org.noedge.domain.Person;
import org.noedge.domain.Result;
import org.noedge.domain.Room;
import org.noedge.service.PermissionService;
import org.noedge.service.RoomService;
import org.noedge.tools.ConversionUtils;
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
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 */
@RestController
public class RoomController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoomService roomService;

    /**
     * 添加房间
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "/addRoom")
    public Result addRoom(HttpServletRequest request, @RequestParam Map<String, String> map){
        //旅社id
        String hostelIdStr = "";
        //房间名称
        String name = "";
        //床位总数
        String totalNumStr = "";
        try {
            hostelIdStr = ConversionUtils.toUTF8Str(map.get("hostelId"));
            name = ConversionUtils.toUTF8Str(map.get("name"));
            totalNumStr = ConversionUtils.toUTF8Str(map.get("totalNum"));
        } catch (UnsupportedEncodingException e) {
            logger.error("编码转换错误",e);
            return Result.getResult(-3,"编码转换错误",null);
        }

        if(StringUtils.isEmpty(hostelIdStr) || StringUtils.isEmpty(name) || StringUtils.isEmpty(totalNumStr)){
            return Result.getResult(-1,"参数不能为空",null);
        }
        int totalNum = 0;
        int hostelId = 0;
        try{
            totalNum = Integer.parseInt(totalNumStr);
            hostelId = Integer.parseInt(hostelIdStr);
        }catch (NumberFormatException e){
            logger.error("类型转换错误",e);
            return Result.getResult(-4,"参数类型转换错误",null);
        }

        if(totalNum <= 0){
            return  Result.getResult(-2,"床位数必须为大于0的整数",null);
        }

        boolean isSuccess = false;
        HttpSession session = request.getSession();
        //用户id
        Integer personId = ((Person)session.getAttribute(session.getId())).getId();
        if(permissionService.judgePermission(personId,hostelId)){
            Room room = new Room();
            room.setName(name);
            room.setHostelId(hostelId);
            room.setTotalNum(totalNum);
            String nowTime = MyDateFomat.formatTime();
            room.setCreateTime(nowTime);
            room.setUpdateTime(nowTime);
            room.setCreatePId(personId);
            room.setLastUpdatePId(personId);
            isSuccess = roomService.addRoom(room);
        }else {
            return Result.getResult(-5,"您没有权限做此操作",null);
        }

        if(!isSuccess){
            return Result.getResult(-6,"添加房间失败",null);
        }
        return Result.getResult(0,"添加房间成功",null);
    }

    @RequestMapping(value = "/getHostelCanLiving")
    public Result getHostelCanLiving(@RequestParam Map<String,String> reqParam){
        String hostelIdStr = reqParam.get("hostelId");
        String checkInDate = reqParam.get("checkInDate");
        String checkOutDate = reqParam.get("checkOutDate");
        if(StringUtils.isEmpty(hostelIdStr) || StringUtils.isEmpty(checkInDate) || StringUtils.isEmpty(checkOutDate)){
            return Result.getResult(-1,"参数不能为空",null);
        }
        int hostelId;
        int dayDiff;
        try {
            dayDiff = MyDateFomat.getDateDiffDay(checkInDate,checkOutDate);
            hostelId = Integer.parseInt(hostelIdStr);
        } catch (ParseException e) {
            logger.info("日期格式错误");
            return Result.getResult(-2,"参数格式错误",null);
        }catch (NumberFormatException e){
            logger.info("Integer转换错误");
            return Result.getResult(-2,"参数格式错误",null);
        }

        if(dayDiff <= 0){
            return Result.getResult(-3,"入住日期不能大于等与离店日期",null);
        }

        //查询旅社房间基本信息
        List<Room> roomList = roomService.getRoomInfoByHostelId(hostelId);
        if(null == roomList || roomList.size() <= 0){
            return  Result.getResult(-4,"该旅社暂无房间，请添加房间",null);
        }

        //查询日期入住期间旅社每间房子的可用床位
        for(int i = 0 ; i < dayDiff ; i++){

        }

        return Result.getResult(0,"success",null);
    }
}
