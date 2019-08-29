package org.noedge.service;

import java.util.List;
import java.util.Map;

public interface BusinessService {

    /**
     * 查询旅社入住人数以及入住总人数
     * @param hostelId
     * @param today
     * @return
     */
    public Map<Integer,Map<String,Integer>> getTodayLivingNumByHostelIds(List<Integer> hostelId, String today);
}
