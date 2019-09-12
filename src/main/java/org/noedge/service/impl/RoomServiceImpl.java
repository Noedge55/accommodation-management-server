package org.noedge.service.impl;

import org.noedge.dao.RoomDao;
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
}
