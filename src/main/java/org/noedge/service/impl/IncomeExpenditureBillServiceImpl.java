package org.noedge.service.impl;

import org.noedge.dao.IncomeExpenditureBillDao;
import org.noedge.service.IncomeExpenditureBillService;
import org.noedge.tools.MyDecimalFomart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 */
@Service("incomeExpenditureBillServiceImpl")
public class IncomeExpenditureBillServiceImpl implements IncomeExpenditureBillService {

    @Autowired
    private IncomeExpenditureBillDao incomeExpenditureBillDao;
    @Override
    public Map<Integer, Double> getBillStatistics(Map param) {
        List<Map<String,Object>> billStatisticsList = incomeExpenditureBillDao.selectBillStatistics(param);
        Map<Integer,Double> billStatistics = new HashMap<>();
        for(Map<String,Object> temp:billStatisticsList){
            billStatistics.put(Integer.valueOf(temp.get("bill_type").toString()), MyDecimalFomart.formatTwoScalesRoundHalfUp(temp.get("total_amount").toString()));
        }
        if(!billStatistics.containsKey(0)){
            billStatistics.put(0,MyDecimalFomart.formatTwoScalesRoundHalfUp(0));
        }
        if(!billStatistics.containsKey(1)){
            billStatistics.put(1,MyDecimalFomart.formatTwoScalesRoundHalfUp(0));
        }
        if(!billStatistics.containsKey(2)){
            billStatistics.put(2,MyDecimalFomart.formatTwoScalesRoundHalfUp(0));
        }
        return billStatistics;
    }
}
