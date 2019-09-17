package org.noedge.service.impl;

import org.noedge.dao.HostelDao;
import org.noedge.dao.PermissionDao;
import org.noedge.domain.Hostel;
import org.noedge.domain.Permission;
import org.noedge.service.HostelService;
import org.noedge.tools.MyDateFomat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 */
@Service("hostelService")
public class HostelServiceImpl implements HostelService {

    @Autowired
    private HostelDao hostelDao;
    @Autowired
    private PermissionDao permissionDao;

    public List<Hostel> getAll() {
        return hostelDao.selectAll();
    }

    public List<Hostel> getAllByPIdPermission(int permissionPId) {
        return hostelDao.selectAllByPIdPermission(permissionPId);
    }

    @Override
    public boolean addHostel(Hostel hostel,Integer personId) {

        int count = 0;
        count = hostelDao.insertHostel(hostel);
        if(count > 0 ){
            Permission permission = new Permission();
            permission.setPersonId(personId);
            permission.setHostelId(hostel.getId());
            permission.setType("0");
            permission.setCreateTime(MyDateFomat.formatTime());
            permission.setCreatePId(personId);
            count = permissionDao.insertPermission(permission);
        }else {
            return Boolean.FALSE;
        }
        if(count <= 0){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
