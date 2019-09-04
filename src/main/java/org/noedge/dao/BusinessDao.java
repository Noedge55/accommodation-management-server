package org.noedge.dao;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 */
@Repository("businessDao")
public interface BusinessDao {
    /**
     * 查询旅社入住人数
     * @param hostelIds
     * @return
     */
    List<Map<String,Integer>> selectTodayLivingNumByHostelIdAndDate(List<Integer> hostelIds,String today);

    /**
     * 查询旅社总居住人数
     * @param hostelIds
     * @return
     */
    List<Map<String,Integer>> selectTotalLivingNumByHostelId(List<Integer> hostelIds);

    /**
     * 查询旅社入住人数以及总人数
     * @param hostelIds
     * @param today
     * @return
     */
    List<Map<String,Integer>> selectHostelLivingNumAll(List<Integer> hostelIds,String today);

    /**
     * 分页查询订单信息
     * @param param
     * @return
     */
    List<Map> getOrdersByPage(Map param);
}
