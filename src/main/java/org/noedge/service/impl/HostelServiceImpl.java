package org.noedge.service.impl;

import org.noedge.dao.HostelDao;
import org.noedge.domain.Hostel;
import org.noedge.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 */
@Service("hostelService")
public class HostelServiceImpl implements HostelService {

    @Autowired
    private HostelDao hostelDao;

    public List<Hostel> getAll() {
        return hostelDao.selectAll();
    }

    public List<Hostel> getAllByPIdPermission(int permissionPId) {
        return hostelDao.selectAllByPIdPermission(permissionPId);
    }
}
