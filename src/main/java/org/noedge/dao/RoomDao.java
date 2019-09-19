package org.noedge.dao;

import org.noedge.domain.Room;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("roomDao")
public interface RoomDao {
    List<Map> selectRoomListByHostelIdAndDate(Map hostelId);
    List<Map> selectCheckInRoomByOrderId(Integer orderId);
    int insertRoom(Room room);

    /**
     * 查询房间已入住人数
     * @param hostelId
     * @param date
     * @return
     */
    List<Map> selectRoomLivingNum(Integer hostelId,String date);

    /**
     * 查询旅社房间基本信息
     * @param hostelId
     * @return
     */
    List<Room> selectRoomInfoByHostelId(Integer hostelId);
}
