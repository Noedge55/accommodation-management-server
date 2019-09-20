package org.noedge.service;

import org.noedge.domain.Room;

import java.util.List;
import java.util.Map;

public interface RoomService {
    List<Map> getRoomListByHostelIdAndDate(Map param);
    List<Map> getCheckInRoomByOrderId(Integer orderId);
    boolean addRoom(Room room);
    List<Map<Integer,Integer>> getRoomLivingNum(Integer hostelId,String date);
    List<Room> getRoomInfoByHostelId(Integer hostelId);
}
