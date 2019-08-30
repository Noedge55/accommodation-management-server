package org.noedge.web;

import org.noedge.domain.Hostel;
import org.noedge.domain.Result;
import org.noedge.service.BusinessService;
import org.noedge.service.HostelService;
import org.noedge.tools.ConversionUtils;
import org.noedge.tools.MyDateFomat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 */
@RestController
public class HostelController {

    @Autowired
    private HostelService hostelService;

    @Autowired
    private BusinessService businessService;

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
        Map<String,Object> temp = new HashMap<>();
        for(Hostel hostel:hostelList){
            temp.clear();
            temp.put("hostelId",hostel.getId());
            temp.put("name",hostel.getName());
            temp.put("area",hostel.getArea());
            temp.put("address",hostel.getAddress());
            temp.put("livingNum", ConversionUtils.returnZero(livingNumMap.get(hostel.getId()).get("living_num")));
            temp.put("totalNum",ConversionUtils.returnZero(livingNumMap.get(hostel.getId()).get("total_num")));
            resultList.add(temp);
        }

        return Result.getResult(0,"success",resultList);
    }
}
