package org.noedge.service;

import org.noedge.domain.Hostel;

import java.util.List;

public interface HostelService {
    List<Hostel> getAll();
    List<Hostel> getAllByPIdPermission(int permissionPId);
    boolean addHostel(Hostel hostel,Integer personId);
}
