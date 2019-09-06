package org.noedge.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 */
@Repository("incomeExpenditureBillDao")
public interface IncomeExpenditureBillDao {
    List<Map<String,Object>> selectBillStatistics(Map param);
}
