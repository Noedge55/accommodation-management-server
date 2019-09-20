package org.noedge.service.impl;

import org.noedge.dao.RoomDao;
import org.noedge.domain.Room;
import org.noedge.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 */
@Service("roomService")
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;
    @Override
    public List<Map> getRoomListByHostelIdAndDate(Map param) {
        return roomDao.selectRoomListByHostelIdAndDate(param);
    }

    @Override
    public List<Map> getCheckInRoomByOrderId(Integer orderId) {
        return roomDao.selectCheckInRoomByOrderId(orderId);
    }

    @Override
    public boolean addRoom(Room room) {
        int count = 0;
        count = roomDao.insertRoom(room);
        if(count <= 0){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public List<Map<Integer,Integer>> getRoomLivingNum(Integer hostelId, String date) {
        return roomDao.selectRoomLivingNum(hostelId,date);
    }

    @Override
    public List<Room> getRoomInfoByHostelId(Integer hostelId) {
        return roomDao.selectRoomInfoByHostelId(hostelId);
    }
}
