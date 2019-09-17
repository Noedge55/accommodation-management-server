package org.noedge.dao;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("roomDao")
public interface RoomDao {
    List<Map> selectRoomListByHostelIdAndDate(Map hostelId);
    List<Map> selectCheckInRoomByOrderId(Integer orderId);
}
