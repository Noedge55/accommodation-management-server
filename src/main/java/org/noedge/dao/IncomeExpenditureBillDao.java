package org.noedge.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 */
@Repository("incomeExpenditureBillDao")
public interface IncomeExpenditureBillDao {
    public List<Map> getBillStatistics(Map param);
}
