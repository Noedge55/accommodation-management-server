package org.noedge.web;

import org.noedge.domain.Person;
import org.noedge.domain.Result;
import org.noedge.service.BusinessService;
import org.noedge.service.IncomeExpenditureBillService;
import org.noedge.tools.MyDateFomat;
import org.noedge.tools.MyDecimalFomart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 */
@RestController
public class CheckInOrderController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BusinessService businessService;
    @Autowired
    private IncomeExpenditureBillService incomeExpenditureBillService;

    @RequestMapping(value = "/getOrders")
    public Result getOrders(HttpServletRequest request,@RequestParam Map<String,String> param){
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute(session.getId());
        Integer personId = person.getId();
        String dateType = param.get("dateType");
        String startDate = param.get("startDate");
        String endDate = param.get("endDate");
        String pageStr = param.get("page");
        String checkIds = param.get("checkIds");
        int page = 0;
        try{
            if(!StringUtils.isEmpty(pageStr)){
                page = Integer.parseInt(pageStr);
            }
        }catch (NumberFormatException e){
            logger.error("page必须为数字",e);
            return Result.getResult(-1,"page必须为数字",null);
        }
        if(StringUtils.isEmpty(dateType)){
            dateType = "all";
        }
        switch (dateType){
            case "thisWeek":
                startDate = MyDateFomat.formatThisWeekMonday();
                endDate = MyDateFomat.formatThisWeekSunday();
                break;
            case "thisMonth":
                startDate = MyDateFomat.formatThisMonthFirstDay();
                endDate = MyDateFomat.formatThisMonthLastDay();
                break;
            case "today":
                startDate = MyDateFomat.formatDate();
                endDate = MyDateFomat.formatDate();
                break;
        }

        Map<String,Object> param2 = new HashMap<>();
        param2.put("personId",personId);
        param2.put("dateType",dateType);
        param2.put("startDate",startDate);
        param2.put("endDate",endDate);
        param2.put("page",page);
        param2.put("checkIds",checkIds);

        Map<Integer,Double> billStatistics = incomeExpenditureBillService.getBillStatistics(param2);
        List<Map> billStatisticsList = new ArrayList<>();
        billStatisticsList.add(billStatistics);


        List<Map> billList = businessService.getOrdersByPage(param2);


        Map<String,List> result = new HashMap<>();
        result.put("billStatistics",billStatisticsList);
        result.put("billList",billList);

        return Result.getResult(0,"success",result);
    }
}
