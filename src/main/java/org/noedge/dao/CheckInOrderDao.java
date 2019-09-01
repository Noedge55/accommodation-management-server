package org.noedge.dao;

import org.noedge.domain.Result;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Description:
 */
@Repository("checkInOrderDao")
public interface CheckInOrderDao {
    public Result getOrders(Map param);
}
