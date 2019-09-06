package org.noedge.service;

import java.util.Map;

/**
 * @Description:
 */
public interface IncomeExpenditureBillService {
    Map<Integer,Double> getBillStatistics(Map param);
}
