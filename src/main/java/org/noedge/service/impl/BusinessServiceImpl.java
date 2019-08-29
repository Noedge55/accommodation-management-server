package org.noedge.service.impl;

import org.noedge.dao.BusinessDao;
import org.noedge.service.BusinessService;
import org.noedge.tools.MyDateFomat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description:
 */
@Service("businessServiceImpl")
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private BusinessDao businessDao;
    public Map<Integer,Map<String,Integer>> getTodayLivingNumByHostelIds(List<Integer> hostelIds, String today) {
        List<Map<String,Integer>> livingNumList= businessDao.selectHostelLivingNumAll(hostelIds, MyDateFomat.formatDate());
        Map<Integer,Map<String,Integer>> result = new HashMap<Integer, Map<String, Integer>>();
        for(Map<String,Integer> temp:livingNumList){
            result.put(temp.get("hostel_id"),temp);
        }
        return result;
    }
}
