package org.noedge.service.impl;

import org.noedge.dao.PermissionDao;
import org.noedge.domain.Permission;
import org.noedge.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 */
@Service("permissionServiceImpl")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public boolean judgePermission(Integer personId, Integer hostelId) {
        Permission permission = new Permission();
        permission.setPersonId(personId);
        permission.setHostelId(hostelId);
        if (permissionDao.getPermissionNum(permission) > 0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
