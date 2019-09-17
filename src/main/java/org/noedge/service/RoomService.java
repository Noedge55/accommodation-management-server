package org.noedge.service;

import java.util.List;
import java.util.Map;

public interface RoomService {
    List<Map> getRoomListByHostelIdAndDate(Map param);
    List<Map> getCheckInRoomByOrderId(Integer orderId);
}
