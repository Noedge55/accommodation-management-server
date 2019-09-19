package org.noedge.web;

import org.noedge.domain.Hostel;
import org.noedge.domain.Person;
import org.noedge.domain.Result;
import org.noedge.service.BusinessService;
import org.noedge.service.HostelService;
import org.noedge.tools.ConversionUtils;
import org.noedge.tools.MyDateFomat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 */
@RestController
public class HostelController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HostelService hostelService;

    @Autowired
    private BusinessService businessService;

    @RequestMapping(value = "/getHostels")
    public  Result getHostels(HttpServletRequest request){
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute(session.getId());
        Integer personId = person.getId();
        List<Hostel> hostelList = hostelService.getAllByPIdPermission(personId);

        return Result.getResult(0,"success",hostelList);
    }

    @RequestMapping(value = "/getHomehostelList")
    public Result getHomehotelList(@RequestParam Map map){
        Object personObject = map.get("personId");
        if(null == personObject){
            return Result.getResult(-1,"参数不能为空",null);
        }

        Integer personId = null;
        try {
            personId = Integer.parseInt(String.valueOf(personObject));
        }catch (NumberFormatException e){
            return Result.getResult(-2,"参数必须为整型",null);
        }


        List<Hostel> hostelList = hostelService.getAllByPIdPermission(personId);

        if(null == hostelList || hostelList.isEmpty()){
            return Result.getResult(-3,"暂无管理的旅社",null);
        }

        List<Integer> hostelIds = new ArrayList<>();
        for(Hostel hostel:hostelList){
            hostelIds.add(hostel.getId());
        }

        Map<Integer,Map<String,Integer>> livingNumMap = businessService.getTodayLivingNumByHostelIds(hostelIds, MyDateFomat.formatDate());

        List<Map<String,Object>> resultList = new ArrayList<>();
        for(Hostel hostel:hostelList){
            Map<String,Object> temp = new HashMap<>();
            temp.put("hostelId",hostel.getId());
            temp.put("name",hostel.getName());
            temp.put("area",hostel.getArea());
            temp.put("address",hostel.getAddress());
            temp.put("livingNum", ConversionUtils.returnZero(livingNumMap.get(hostel.getId()).get("livingNum")));
            temp.put("totalNum",ConversionUtils.returnZero(livingNumMap.get(hostel.getId()).get("totalNum")));
            resultList.add(temp);
        }

        return Result.getResult(0,"success",resultList);
    }

    @RequestMapping(value = "/addHostel")
    public Result addHostel(HttpServletRequest request,@RequestParam Map<String,String> reqParam) throws UnsupportedEncodingException {
        HttpSession session = request.getSession();
        Person person =(Person) session.getAttribute(session.getId());
        Integer personId = person.getId();

        String name = ConversionUtils.toUTF8Str(reqParam.get("name"));
        String area = ConversionUtils.toUTF8Str(reqParam.get("area"));
        String address = ConversionUtils.toUTF8Str(reqParam.get("address"));

        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(area) || StringUtils.isEmpty(address)){
            return Result.getResult(-1,"参数不能为空",null);
        }

        String now = MyDateFomat.formatTime();
        Hostel hostel = new Hostel();
        hostel.setName(name);
        hostel.setArea(area);
        hostel.setAddress(address);
        hostel.setCreatePId(personId);
        hostel.setCreateTime(now);
        hostel.setUpdateTime(now);
        hostel.setCreatePId(personId);
        hostel.setLastUpdatePId(personId);
        boolean isAdd = hostelService.addHostel(hostel,personId);
        if(!isAdd){
            return Result.getResult(-2,"数据插入失败",null);
        }
        return  Result.getResult(0,"添加旅社成功",null);
    }
}
