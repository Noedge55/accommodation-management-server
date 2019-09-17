package org.noedge.dao;

import org.noedge.domain.Permission;
import org.springframework.stereotype.Repository;

@Repository("permissionDao")
public interface PermissionDao {
    int insertPermission(Permission permission);
}
