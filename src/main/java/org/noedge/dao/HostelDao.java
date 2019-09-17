package org.noedge.dao;

import org.noedge.domain.Hostel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hostelDao")
public interface HostelDao {
    List<Hostel> selectAll();
    List<Hostel> selectAllByPIdPermission(int permissionPId);
    int insertHostel(Hostel hostel);
}
